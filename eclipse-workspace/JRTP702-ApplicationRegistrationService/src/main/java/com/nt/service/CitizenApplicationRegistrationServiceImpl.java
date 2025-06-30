package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.nt.bindings.CitizenAppRegistrationInputs;
import com.nt.entity.CitizenAppRegistrationEntity;
import com.nt.exceptions.InvalidSSNException;
import com.nt.repository.IApplicationRegistrationRepository;

import reactor.core.publisher.Mono;


@Service
public class CitizenApplicationRegistrationServiceImpl implements ICitizenApplicationRegistrationService {

	@Autowired
	private IApplicationRegistrationRepository citizenRepo;
	@Autowired
	private RestTemplate template;
	@Autowired
	private WebClient client;
	
	
	
	@Value("${ar.ssa-web.url}")
	private String endpointUrl;
	
	@Value("${ar.state}")
	private String targetState;
	 
	@Override
	public Integer registerCitizenApplication(CitizenAppRegistrationInputs inputs)throws InvalidSSNException {
		//Target external Rest API url
		//String SSAWebUrl="http://localhost:9090/ssa-web-api/find/{ssn}";
		
		//perform webservice call to check whether SSN is  valid or not and to get the state name
		
		//ResponseEntity<String> response=template.exchange(endpointUrl, HttpMethod.GET,null,String.class,inputs.getSsn());
		
		//perform webservice call to check whether SSN is  valid or not and to get the state name(using web client)

		
		
		//get state name
		Mono<String> response=client.get().uri(endpointUrl,inputs.getSsn()).retrieve().onStatus(HttpStatus.BAD_REQUEST::equals,res->res.bodyToMono(String.class).map(ex-> new InvalidSSNException("invalid ssn"))).bodyToMono(String.class);
			String stateName=response.block();
			
		
		
		//register the citizen if he belongs to CA state 
		if(stateName.equalsIgnoreCase(targetState)) {
			CitizenAppRegistrationEntity entity=new CitizenAppRegistrationEntity();
			BeanUtils.copyProperties(inputs, entity);
        entity.setStateName(stateName);
        
        int appId=citizenRepo.save(entity).getAppId();
        return appId;
        
}
		
		throw new InvalidSSNException("invalid ssn");
		
		
		
	}
	
	
	
}
