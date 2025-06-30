package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bindings.ChildInputs;
import com.nt.bindings.CitizenAppRegistrationInputs;
import com.nt.bindings.DcSummaryReport;
import com.nt.bindings.EducationInputs;
import com.nt.bindings.IncomeInputs;
import com.nt.bindings.PlanSelectionInputs;
import com.nt.entity.CitizenAppRegistrationEntity;
import com.nt.entity.DcCaseEntity;
import com.nt.entity.DcChildrenEntity;
import com.nt.entity.DcEducationEntity;
import com.nt.entity.DcIncomeEntity;
import com.nt.entity.PlanEntity;
import com.nt.repository.IApplicationRegistrationRepository;
import com.nt.repository.IDcCaseRepository;
import com.nt.repository.IDcChildrenRepository;
import com.nt.repository.IDcEducationRepository;
import com.nt.repository.IDcIncomeRepository;
import com.nt.repository.IPlanRepository;
@Service
public class DcMgmtServiceImpl implements IDcMgmtService {
	
	@Autowired
	private IDcCaseRepository caseRepo;
	@Autowired
	private IApplicationRegistrationRepository citizenAppRepo;
	@Autowired
	private IPlanRepository planRepo;
	@Autowired
	private IDcIncomeRepository incomeRepo;
	@Autowired
	private IDcEducationRepository educationRepo;
	@Autowired
	private IDcChildrenRepository childrenRepo;
	

	@Override
	public Integer generateCaseNo(Integer appId) {
		
	//Load Citizen Data
		Optional<CitizenAppRegistrationEntity> appCitizen=citizenAppRepo.findById(appId);
		
		if(appCitizen.isPresent()) {
			DcCaseEntity caseEntity=new DcCaseEntity();
			caseEntity.setAppId(appId);
			return caseRepo.save(caseEntity).getCaseNo();
			
			
		}
		
		
		return 0;
	}

	@Override
	public List<String> showAllPlans() {
		List<PlanEntity> plansList=planRepo.findAll();
		//Get only plan Names
		List<String> planNamesList=plansList.stream().map(plan->plan.getPlanName()).toList();
		
		
		return planNamesList;
	}

	@Override
	public Integer savePlanSelection(PlanSelectionInputs plan) {
		
		Optional<DcCaseEntity>opt=caseRepo.findById(plan.getCaseNo());
		if(opt.isPresent()) {
			DcCaseEntity caseEntity=opt.get();
			caseEntity.setPlanId(plan.getPlanId());
			caseRepo.save(caseEntity);
			return caseEntity.getCaseNo();
			
		}
		
		
		return 0;
	}

	@Override
	public Integer saveIncomeDetails(IncomeInputs income) {
		
		DcIncomeEntity incomeEntity=new DcIncomeEntity();
		
		BeanUtils.copyProperties(income, incomeEntity);
		incomeRepo.save(incomeEntity);
		
		
		return income.getCaseNo();
	}

	@Override
	public Integer saveEducationDetails(EducationInputs education) {
		
		//convert Binding Object to entity Object
		DcEducationEntity educationEntity=new DcEducationEntity();
		
		BeanUtils.copyProperties(education, educationEntity);
		educationRepo.save(educationEntity);
		
		return education.getCaseNo();
		
	}

	@Override
	public Integer saveChildrenDetails(List<ChildInputs> children) {
		
		//conver each bindind class obj to Entity class onj
		children.forEach(child->{
			DcChildrenEntity childEntity=new DcChildrenEntity();
			BeanUtils.copyProperties(child, childEntity);
		childrenRepo.save(childEntity);
		
			
		});
		
		return children.get(0).getCaseNo();
		
	}

	@Override
	public DcSummaryReport showDCSummary(Integer caseNo) {
		DcIncomeEntity incomeEntity=incomeRepo.findByCaseNo(caseNo);
		DcEducationEntity educationEntity=educationRepo.findByCaseNo(caseNo);
		List<DcChildrenEntity>childsEntityList=childrenRepo.findByCaseNo(caseNo);
		Optional<DcCaseEntity> optCaseEntity=caseRepo.findById(caseNo);
		String planName=null;
		
		Integer appId=null;
		
		if(optCaseEntity.isPresent()) {
			DcCaseEntity caseEntity=optCaseEntity.get();
			Integer planId=caseEntity.getPlanId();
			 appId=caseEntity.getAppId();

			Optional<PlanEntity>optPlanEntity=planRepo.findById(planId);
			if(optPlanEntity.isPresent()) {
			planName=optPlanEntity.get().getPlanName();
		}
			
		}
		
		Optional<CitizenAppRegistrationEntity> optCitizenEntity=citizenAppRepo.findById(appId);
		CitizenAppRegistrationEntity citizenEntity=null;
		if(optCitizenEntity.isPresent())
			citizenEntity=optCitizenEntity.get();
		
		//convert entity objs to Binding objs
		IncomeInputs income=new IncomeInputs();
		BeanUtils.copyProperties(incomeEntity, income);
		EducationInputs education=new EducationInputs();
		BeanUtils.copyProperties(educationEntity, education);
		List<ChildInputs>listChilds=new ArrayList();
		
		childsEntityList.forEach(childEntity->{ChildInputs child=new ChildInputs();
		BeanUtils.copyProperties(childEntity, child);
		listChilds.add(child);
		
			
		});
		CitizenAppRegistrationInputs citizen=new CitizenAppRegistrationInputs();
		BeanUtils.copyProperties(citizenEntity, citizen);
		
		// prepare Dcsummary reeport
		DcSummaryReport report=new DcSummaryReport();
		report.setPlanName(planName);
		report.setIncomeDetails(income);
		report.setEducationDetails(education);
		report.setCitizenDetails(citizen);
		report.setChildrenDetails(listChilds);
		
		
		return report;
	}

	@Override
	public List<String> showAllPlanNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
