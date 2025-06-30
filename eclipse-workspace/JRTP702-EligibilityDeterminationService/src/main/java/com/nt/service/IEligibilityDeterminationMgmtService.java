package com.nt.service;

import com.nt.bindings.EligibilityDetailsOutput;
import com.nt.entity.EligibilityDetailsEntity;

public interface IEligibilityDeterminationMgmtService {

	
	
	public EligibilityDetailsOutput determineEligiblity(Integer caseNo);
}

	
