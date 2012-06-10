package name.huangzhoujin.registration.persistence.sqlmapdao;

import java.util.HashMap;

public interface CustomMapper {

	@SuppressWarnings("rawtypes")
	int countByCondition(HashMap example);

}
