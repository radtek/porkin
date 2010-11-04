package net.cominfo.digiagent.service;

import net.cominfo.digiagent.persistence.dao.CommentsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CommentsService {
	
	@Autowired
	private CommentsDao commentsDao;

}
