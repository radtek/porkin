package name.huangzhoujin.registration.persistence.sqlmapdao;

import java.util.HashMap;
import java.util.List;

import name.huangzhoujin.registration.persistence.dto.CustomDto;

public interface CustomMapper {

	@SuppressWarnings("rawtypes")
	int countByCondition(HashMap example);
	
	
	@SuppressWarnings("rawtypes")
	List<CustomDto> listByCondition(HashMap example);

}
