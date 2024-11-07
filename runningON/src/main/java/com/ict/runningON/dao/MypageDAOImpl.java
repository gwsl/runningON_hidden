package com.ict.runningON.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.runningON.vo.MessagesVO;
import com.ict.runningON.vo.PostsVO;
import com.ict.runningON.vo.UsersVO;

@Repository
public class MypageDAOImpl implements MypageDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<MessagesVO> getSendMsgList(String user_id) {
		return sqlSessionTemplate.selectList("msg.sendlist", user_id);
	}
	
	@Override
	public List<MessagesVO> getReceiveMsgList(String user_id) {
		return sqlSessionTemplate.selectList("msg.receivelist", user_id);
	}

	@Override
	public int getSendMsg(MessagesVO mvo) {
		return sqlSessionTemplate.insert("msg.sendmsg", mvo);
	}

	@Override
	public MessagesVO getOneMsg(String msg_idx) {
		return sqlSessionTemplate.selectOne("msg.one", msg_idx);
	}

	@Override
	public UsersVO getMyInfo(String user_id) {
		return sqlSessionTemplate.selectOne("msg.info", user_id);
	}

	@Override
	public int updateInfo(UsersVO uvo) {
		//System.out.println("dao:" + uvo.getUser_profileImg());
		return sqlSessionTemplate.update("msg.info_update", uvo);
	}

	@Override
	public List<PostsVO> getPostList(String user_id) {
		return sqlSessionTemplate.selectList("msg.write_list", user_id);
	}

	@Override
	public List<Integer> getMyComments(String user_id) {
		return sqlSessionTemplate.selectList("msg.get_comments", user_id);
	}

	@Override
	public List<PostsVO> getPostList(List<Integer> post_idx) {
		return sqlSessionTemplate.selectList("msg.get_com_posts", post_idx);
	}

	@Override
	public List<Integer> getMyScraps(String user_id) {
		return sqlSessionTemplate.selectList("msg.get_scraps", user_id);
	}
}
