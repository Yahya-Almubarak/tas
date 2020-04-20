package com.kaukajarvisoft.tas.maincomponents.interfaces;

public interface ISubject {
	boolean addCertificate(ICertificate certificate);
	boolean removeCertificate(ICertificate certificate);
	boolean addCertificateManager(IUser user);
	boolean removeCertificateManager(IUser user);
	
}
