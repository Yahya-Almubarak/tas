package com.kaukajarvisoft.tas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaukajarvisoft.tas.policy.Policy;
import com.kaukajarvisoft.tas.policy.Role;
import com.kaukajarvisoft.tas.repositories.UserGroupRepository;
import com.kaukajarvisoft.tas.repositories.UserRepository;
import com.kaukajarvisoft.tas.users.TasUser;
import com.kaukajarvisoft.tas.users.UserGroup;

@Service
public class UserGroupService {
	@Autowired
	UserGroupRepository userGroupRepository;
	@Autowired
	UserService userService;
	
	public UserGroup createUserGroup(UserGroup userGroup) {
		return userGroupRepository.save(userGroup);
	}
	
	public void deleteUserGroup(UserGroup userGroup) {
		UserGroup _userGroup = userGroupRepository.findById(userGroup.getId()).get();
		userGroupRepository.delete(_userGroup);
	}

	public UserGroup addMemberToUserGroup(UserGroup userGroup, TasUser user) {
		UserGroup _userGroup = userGroupRepository.findById(userGroup.getId()).get();
		TasUser _user = userService.getUser(user.getId());
		_userGroup.getMembers().add(_user);
		return userGroupRepository.save(_userGroup);
	}
	
	public UserGroup removeMemberFromUserGroup(UserGroup userGroup, TasUser user) {
		UserGroup _userGroup = userGroupRepository.findById(userGroup.getId()).get();
		TasUser _user = userService.getUser(user.getId());
		_userGroup.getMembers().remove(_user);
		return userGroupRepository.save(_userGroup);
	}
	
	public UserGroup addPolicyToUserGroup(UserGroup userGroup, Policy policy) {
		UserGroup _userGroup = userGroupRepository.findById(userGroup.getId()).get();
		_userGroup.getPolicies().add(policy);
		return userGroupRepository.save(_userGroup);
	}
	
	public UserGroup removePolicyFromUserGroup(UserGroup userGroup, Policy policy) {
		UserGroup _userGroup = userGroupRepository.findById(userGroup.getId()).get();
		_userGroup.getPolicies().add(policy);
		return userGroupRepository.save(_userGroup);
	}
}
