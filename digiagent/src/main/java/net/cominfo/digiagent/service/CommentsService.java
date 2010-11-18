package net.cominfo.digiagent.service;

import java.util.Date;

import net.cominfo.digiagent.persistence.dao.CommentsDao;
import net.cominfo.digiagent.persistence.dao.SequenceDao;
import net.cominfo.digiagent.persistence.domain.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CommentsService {

	@Autowired
	private CommentsDao commentsDao;

	@Autowired
	private SequenceDao sequenceDao;

	public void save(Integer supplierId, Integer userId, String rank,
			String content, String userName) {
		Comments comments = new Comments();

		comments.setCommentId(sequenceDao.getCommentsNexId());
		comments.setCommentRank(rank);
		comments.setCommentStatus("N");
		comments.setCommentContent(content);
		comments.setCreatedBy(userName);
		comments.setCreatedDate(new Date());
		comments.setLastupdatedBy(userName);
		comments.setLastupdatedDate(new Date());
		comments.setSupplierId(supplierId);
		comments.setUserId(userId);
		commentsDao.insert(comments);

	}

}
