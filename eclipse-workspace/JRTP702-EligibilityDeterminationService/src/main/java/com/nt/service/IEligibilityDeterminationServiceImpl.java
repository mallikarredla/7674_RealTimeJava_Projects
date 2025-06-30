package com.nt.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bindings.EligibilityDetailsOutput;
import com.nt.entity.COTriggersEntity;
import com.nt.entity.CitizenAppRegistrationEntity;
import com.nt.entity.DcCaseEntity;
import com.nt.entity.DcChildrenEntity;
import com.nt.entity.DcEducationEntity;
import com.nt.entity.DcIncomeEntity;
import com.nt.entity.EligibilityDetailsEntity;
import com.nt.entity.PlanEntity;
import com.nt.repository.IApplicationRegistrationRepository;
import com.nt.repository.ICOTriggerRepository;
import com.nt.repository.IDcCaseRepository;
import com.nt.repository.IDcChildrenRepository;
import com.nt.repository.IDcEducationRepository;
import com.nt.repository.IDcIncomeRepository;
import com.nt.repository.IEligibilityDeterminationRepository;
import com.nt.repository.IPlanRepository;


@Service
public class IEligibilityDeterminationServiceImpl implements IEligibilityDeterminationMgmtService {

	@Autowired
	private IDcCaseRepository caseRepo;
	@Autowired
	private IPlanRepository planRepo;
	@Autowired
	private IDcIncomeRepository incomeRepo;
	@Autowired
	private IDcChildrenRepository childrenRepo;
	
	@Autowired
	private IApplicationRegistrationRepository citizenRepo;
	
	@Autowired
	private IDcEducationRepository educationRepo;
	
	@Autowired
	private IEligibilityDeterminationRepository elgiRepo;
	
	@Autowired
	private ICOTriggerRepository triggerRepository;
	
	@Override
	public EligibilityDetailsOutput determineEligiblity(Integer caseNo) {
//get planId and App Id based on Case No
		Integer appId=null;
		Integer planId=null;
		Optional<DcCaseEntity> optCaseEntity=caseRepo.findById(caseNo);
		if(optCaseEntity.isPresent()) {
			DcCaseEntity caseEntity=optCaseEntity.get();
			planId=caseEntity.getPlanId();
			appId=caseEntity.getAppId();
			
		}
		//get plan Name
		String planName=null;
		
		Optional<PlanEntity>optPlanEntity=planRepo.findById(planId);
		if(optPlanEntity.isPresent()) {
			PlanEntity planEntity=optPlanEntity.get();
			
			planName=planEntity.getPlanName();
			
		}
		//calculat citizen age  by getting citizen DOB through App ID.
		Optional<CitizenAppRegistrationEntity> optCitizenEntity=citizenRepo.findById(appId);
		
		
		int citizenAge=0;
		String citizenName=null;
		
		if(optCitizenEntity.isPresent()) {
		CitizenAppRegistrationEntity citizenEntity=optCitizenEntity.get();
		LocalDate citizenDOB=citizenEntity.getDob();
		citizenName=citizenEntity.getFullname();
		
		LocalDate sysDate=LocalDate.now();
		citizenAge=Period.between(citizenDOB, sysDate).getYears();
		
		}
		
		
		
		
		
		//call helper method to plan condtions
		EligibilityDetailsOutput elgiOutput=applyPlanConditions( caseNo, planName,citizenAge);
		//set citizenName
		elgiOutput.setHolderName(citizenName);
		
		//save eligibility entity object
		EligibilityDetailsEntity elgiEntity=new EligibilityDetailsEntity();
		BeanUtils.copyProperties(elgiOutput, elgiEntity);
		elgiRepo.save(elgiEntity);
		//save CoTriggers object;
		COTriggersEntity triggersEntity=new COTriggersEntity();
		triggersEntity.setCaseNo(caseNo);
		triggersEntity.setTriggerStatus("PENDING");
		
		
		return elgiOutput;
	}
private EligibilityDetailsOutput applyPlanConditions(Integer caseNo,String planName,int citizenAge) {
	EligibilityDetailsOutput elgiOutput=new EligibilityDetailsOutput();
	//get income details of the citizen
	DcIncomeEntity incomeEntity=incomeRepo.findByCaseNo(caseNo);
	double empIncome=incomeEntity.getEmpIncome();
	double propertyIncome=incomeEntity.getPropertyIncome();
	
	
	if(planName.equalsIgnoreCase("SNAP")) {
		
		if(empIncome<=300) {
			elgiOutput.setPlanStatus("Approved");
			elgiOutput.setBenefitAmt(null);
		}
		else {
			elgiOutput.setPlanStatus("Denied");
			elgiOutput.setDenialReason("High Income");
			
		}
	}
	else if(planName.equalsIgnoreCase("CCAP")) {
		boolean kidsCountCondition=false;
		boolean kidAgeCondition=false;
		
		List<DcChildrenEntity>listChilds=childrenRepo.findByCaseNo(caseNo);
		if(listChilds.isEmpty()) {
			kidsCountCondition=true;
			for(DcChildrenEntity child:listChilds) {
				
				int kidAge=Period.between(child.getChildDOB(), LocalDate.now()).getYears();
				if(kidAge>16) {
					kidAgeCondition=false;
				break;
				
			}
		}
			if(empIncome<=300 && kidsCountCondition) {
				elgiOutput.setPlanStatus("Approved");
				elgiOutput.setBenefitAmt(300.0);
			}
			else {
				elgiOutput.setPlanStatus("Denied");
				elgiOutput.setDenialReason("CCAP rules are not satisfied");
				
			}
	}
	else if(planName.equalsIgnoreCase("MEDCARE")) {
		
		if(citizenAge>=65) {elgiOutput.setPlanStatus("Approved");
		elgiOutput.setBenefitAmt(350.0);
	}
		else {		elgiOutput.setPlanStatus("Denied");
		elgiOutput.setDenialReason("MEDCARE rules are not satisfied");

		}
			
	}
	else if(planName.equalsIgnoreCase("MEDAID")) {
		if(empIncome<=300&&propertyIncome==0) {
			elgiOutput.setPlanStatus("Approved");
			elgiOutput.setBenefitAmt(200.0);
		}
		else {elgiOutput.setPlanStatus("Denied");
		elgiOutput.setDenialReason("MEDAID rules are not satisfied");
		
		}
	}
	
	}else if(planName.equalsIgnoreCase("CAJW")) {
		DcEducationEntity educationEntity=educationRepo.findByCaseNo(caseNo);
		int passOutYear=educationEntity.getPassOutYear();
		if(empIncome==0&&passOutYear<LocalDate.now().getYear()) {
			elgiOutput.setPlanStatus("Approved");
			elgiOutput.setBenefitAmt(350.0);
		}
	
	 else {elgiOutput.setPlanStatus("Denied");
	elgiOutput.setDenialReason("CAJW rules are not satisfied");
	 }}
else if(planName.equalsIgnoreCase("QHP")) {
	if(citizenAge>1) {elgiOutput.setPlanStatus("Approved");
}
	else {elgiOutput.setPlanStatus("Denied");
	elgiOutput.setDenialReason("QHP rules are not satisfied");
	 }}	
	
	
	//set the common properties for elgiOutput obj only if the plan is approved
	if(elgiOutput.getPlanStatus().equalsIgnoreCase("APPROVED")) {
		
	elgiOutput.setPlanStartDate(LocalDate.now());
	elgiOutput.setPlanEndDate(LocalDate.now().plusYears(2));
	
}
	return elgiOutput;

}


}


