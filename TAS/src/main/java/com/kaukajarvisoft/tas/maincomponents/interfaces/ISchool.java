package com.kaukajarvisoft.tas.maincomponents.interfaces;

public interface ISchool {
	boolean addSubject(ISubject subject);
	boolean removeSubject(ISubject subject);
	boolean addSchoolManager(IUser user);
	boolean removeSchoolManager(IUser user);
}
