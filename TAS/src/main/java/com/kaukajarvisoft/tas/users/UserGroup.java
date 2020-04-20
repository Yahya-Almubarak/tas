package com.kaukajarvisoft.tas.users;

import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.kaukajarvisoft.tas.policy.Policy;
import com.kaukajarvisoft.tas.policy.Role;

import lombok.Data;

@Data
@Entity
public class UserGroup {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
		
	private String name;
	private String description;
	
	@OneToOne
	private TasUser admin;
	
	@ManyToMany
	private List<TasUser> members;
	
	@OneToMany
	private List<Policy> policies;

}
