package name.huangzhoujin.mymaven.persistence.sqlmapdao;

import java.util.List;
import java.util.Map;

public interface CustomMapper {

	Long resetRepository();
	
	Long getMinUnusedRepositoryID();
	
	Long countByRepURL(String url);
	
	void resetRepositoryByRange(Map<String, Integer> map);
	
	List<String> repositoryTopList(int len);

}
