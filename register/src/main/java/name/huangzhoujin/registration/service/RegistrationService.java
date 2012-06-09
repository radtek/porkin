package name.huangzhoujin.registration.service;

import name.huangzhoujin.registration.persistence.domain.Registration;
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

	public boolean create(Registration record) {
		int result = registrationMapper.insertSelective(record);
		return (result > 0);
	}

	public int delete(int id) {
		int result = registrationMapper.deleteByPrimaryKey(id);
		return result;
	}

	public boolean update(Registration record) {
		int result = registrationMapper.updateByPrimaryKey(record);
		return (result > 0);
	}

}
