package net.cominfo.digiagent.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import net.cominfo.digiagent.persistence.dao.CommentsDao;
import net.cominfo.digiagent.persistence.dao.SequenceDao;
import net.cominfo.digiagent.persistence.domain.Comments;
import net.cominfo.digiagent.persistence.domain.CommentsCriteria;
import net.cominfo.digiagent.persistence.domain.ProductBrand;
import net.cominfo.digiagent.utils.Page;

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
	
	public int countCommentsBySupplier(Integer supplierId){
		CommentsCriteria criteria = new CommentsCriteria();
		criteria.createCriteria().andSupplierIdEqualTo(supplierId);
		return commentsDao.countByExample(criteria);
	}
	
	@SuppressWarnings("unchecked")
	public List<Comments> query(int pageNo, int pageSize,
			Map<String, Object> param) {
		Page<Comments> page = new Page<Comments>();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setParam(param);
		return (List<Comments>) commentsDao.findPage(page,"t_da_comments_Custom.pageByCondition").getResult();
	}

	public Long count(int supplierId) {
		CommentsCriteria criteria = new CommentsCriteria();
		criteria.createCriteria().andSupplierIdEqualTo(supplierId);
		int total = commentsDao.countByExample(criteria);
		return new Long(total);
	}

}
