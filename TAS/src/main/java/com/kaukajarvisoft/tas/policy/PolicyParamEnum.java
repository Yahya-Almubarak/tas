package com.kaukajarvisoft.tas.policy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class PolicyParamEnum {
	List<Actor> actors;
	List<Role> roles;
	List<Target> targets;
	public PolicyParamEnum() {
		actors = Arrays.asList(Actor.values());
		roles = Arrays.asList(Role.values());
		targets = Arrays.asList(Target.values());
	}
}
