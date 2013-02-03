package name.huangzhoujin.mymaven.service;

import java.util.List;

import name.huangzhoujin.mymaven.persistence.sqlmapdao.CustomMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomService {

	@Autowired
	private CustomMapper customMapper;

	public Long getMinUnusedRepositoryID() {
		return customMapper.getMinUnusedRepositoryID();
	}
	
	public Long resetRepository(){
		return customMapper.resetRepository();
	}
	
	public List<String> getRepositoryTopList(int len){
		return customMapper.repositoryTopList(len);
	}
	
}
