package com.nt.ms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.bindings.ChildInputs;
import com.nt.bindings.DcSummaryReport;
import com.nt.bindings.EducationInputs;
import com.nt.bindings.IncomeInputs;
import com.nt.bindings.PlanSelectionInputs;
import com.nt.service.IDcMgmtService;

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/dc-api")
@Tag(name="dc-api",description="DataCollection Module Microservice")
public class DataCollectionOperationsController {
	@Autowired
	private IDcMgmtService dcService;
	@GetMapping("/planNames")
	public ResponseEntity< List<String>>displayPlanNames(){
	//use Service
		List<String>listPlanNames=dcService.showAllPlanNames();
		return new ResponseEntity<List<String>>(listPlanNames,HttpStatus.OK);
		
		
		
	}
	
	@PostMapping("/generateCaseNo/{appId}")
	public ResponseEntity<Integer> generateCaseNo(@PathVariable Integer appId){
		
		Integer caseNo=dcService.generateCaseNo(appId);
		return  new ResponseEntity<Integer>(caseNo,HttpStatus.CREATED);
	}

		
		
	
	@PutMapping("/updatePlanSelection/")
	public ResponseEntity<Integer>savePlanSelection(@RequestBody PlanSelectionInputs inputs){
		Integer caseNo =dcService.savePlanSelection(inputs);
		return new ResponseEntity<Integer>(caseNo,HttpStatus.OK);
		
	}
	@PostMapping("/saveIncome")
	public ResponseEntity<Integer> saveIncomeDetails(@RequestBody IncomeInputs income){
		Integer caseNo=dcService.saveIncomeDetails(income);
		return new ResponseEntity<Integer>(caseNo,HttpStatus.CREATED);
		
	}

	@PostMapping("/saveEducation")
	public ResponseEntity<Integer> saveEducationDetails(@RequestBody EducationInputs education){
		Integer caseNo=dcService.saveEducationDetails(education);
		return new ResponseEntity<Integer>(caseNo,HttpStatus.CREATED);
		
	}

	

	@PostMapping("/saveChilds")
	public ResponseEntity<Integer> saveChildrenDetails(@RequestBody List<ChildInputs> childs){
		Integer caseNo=dcService.saveChildrenDetails(childs);
		return new ResponseEntity<Integer>(caseNo,HttpStatus.OK);
		
	}
    @GetMapping("/summary{caseNo}")
	public ResponseEntity<DcSummaryReport> showSummaryReport(@PathVariable Integer caseNo){
		DcSummaryReport report=dcService.showDCSummary(caseNo);
		return new ResponseEntity<DcSummaryReport>(report,HttpStatus.OK);
		
	}
	
}
