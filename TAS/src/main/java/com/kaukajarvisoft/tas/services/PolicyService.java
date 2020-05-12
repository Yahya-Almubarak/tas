package com.kaukajarvisoft.tas.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.policy.Policy;
import com.kaukajarvisoft.tas.policy.PolicyParamEnum;
import com.kaukajarvisoft.tas.repositories.PolicyRepository;

@Service
@Transactional
public class PolicyService {
	@Autowired
	private PolicyRepository policyRepository;
	
	@Transactional
	public List<Policy> getPolicies() {
		return policyRepository.findAll();
	}
	
	@Transactional
	public Policy getPolicy(Long id) {
		return policyRepository.findById(id).get();
	}
	
	@Transactional
	public Policy savePolicy(Policy policy) {
		return policyRepository.save(policy);
	}
	
	@Transactional
	public PolicyParamEnum getPolicyParamEnum() {
		return new PolicyParamEnum();
	}
}
