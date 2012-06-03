package name.huangzhoujin.registration.service;

import name.huangzhoujin.registration.persistence.sqlmapdao.RegistrationMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationMapper registrationMapper;
	
	public int countAllRegistration() {
		return registrationMapper.countByExample(null);
	}
	
}
