package com.kaukajarvisoft.tas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaukajarvisoft.tas.policy.Policy;
import com.kaukajarvisoft.tas.policy.PolicyParamEnum;
import com.kaukajarvisoft.tas.services.PolicyService;

@RestController
public class PolicyController {
	@Autowired 
	PolicyService policyService;
	
	@GetMapping("/policies")
	public ResponseEntity<List<Policy>> getPolicies() {
		List<Policy> policies = policyService.getPolicies();
		if(policies == null)
			return new ResponseEntity<List<Policy>>(policies, HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Policy>>(policies, HttpStatus.OK);
	}
	
	@GetMapping("/policy/{id}")
	public ResponseEntity<Policy> getPolicy(@PathVariable Long id) {
		Policy policy = policyService.getPolicy(id); 
		if(policy == null)
			return new ResponseEntity<Policy>(policy, HttpStatus.NOT_FOUND);
		return new ResponseEntity<Policy>(policy, HttpStatus.OK);
	}
	
	@GetMapping("policyenumeration")
	public ResponseEntity<PolicyParamEnum> getPolicyParamEnum() {
		PolicyParamEnum policyParamEnum = policyService.getPolicyParamEnum();
		if(policyParamEnum == null)
			return new ResponseEntity<PolicyParamEnum>(policyParamEnum, HttpStatus.NOT_FOUND);
		return new ResponseEntity<PolicyParamEnum>(policyParamEnum, HttpStatus.OK);
	}
	
	@PostMapping("/policy")
	public ResponseEntity<Policy> savePolicy(@RequestBody Policy policy) {
		try {
			System.out.println(policy.getActor());
			Policy _policy = policyService.savePolicy(policy);
			return new ResponseEntity<Policy>(_policy, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}		
	}
	
}
