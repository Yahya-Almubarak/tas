package com.kaukajarvisoft.tas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.policy.Policy;
import com.kaukajarvisoft.tas.policy.PolicyParamEnum;
import com.kaukajarvisoft.tas.repositories.PolicyRepository;

@Service
public class PolicyService {
	@Autowired
	private PolicyRepository policyRepository;
	
	public List<Policy> getPolicies() {
		return policyRepository.findAll();
	}
	
	public Policy getPolicy(Long id) {
		return policyRepository.findById(id).get();
	}
	
	public Policy savePolicy(Policy policy) {
		return policyRepository.save(policy);
	}
	
	public PolicyParamEnum getPolicyParamEnum() {
		return new PolicyParamEnum();
	}
}
