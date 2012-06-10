package name.huangzhoujin.registration.persistence.sqlmapdao;

import java.util.List;

import name.huangzhoujin.registration.persistence.dto.CustomDto;
import name.huangzhoujin.registration.utils.Page;

public interface CustomMapper {

	int countByCondition(Page<CustomDto> page);
	
	List<CustomDto> listByCondition(Page<CustomDto> page);

}
