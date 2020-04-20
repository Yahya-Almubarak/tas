package com.kaukajarvisoft.tas.users;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.kaukajarvisoft.tas.policy.Policy;

import lombok.Data;

@Data
@Entity
public class TasUser {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	
	private String telephoneNo;
	private String address1;
	private String address2;
	private String areaCode;
	private String City;
	

	
	@OneToMany
	private List<Policy> policies;
	
	

}
