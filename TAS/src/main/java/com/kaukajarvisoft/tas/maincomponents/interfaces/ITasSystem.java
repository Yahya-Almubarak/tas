package com.kaukajarvisoft.tas.maincomponents.interfaces;



public interface ITasSystem {
boolean addSchool(ISchool school);
boolean removeSchool(ISchool school);
boolean addSystemAdmin(IUser user);
boolean removeSystemAdmin(IUser user);
}
