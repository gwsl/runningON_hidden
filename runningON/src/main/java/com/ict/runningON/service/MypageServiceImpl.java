package com.ict.runningON.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.runningON.dao.MypageDAO;
import com.ict.runningON.vo.MessagesVO;
import com.ict.runningON.vo.PostsVO;
import com.ict.runningON.vo.RunGroupsVO;
import com.ict.runningON.vo.UsersVO;

@Service
public class MypageServiceImpl implements MypageService{
	
	@Autowired
	private MypageDAO mypageDAO;

	@Override
	public List<MessagesVO> getSendMsgList(String user_id) {
		return mypageDAO.getSendMsgList(user_id);
	}
	
	@Override
	public List<MessagesVO> getReceiveMsgList(String user_id) {
		return mypageDAO.getReceiveMsgList(user_id);
	}

	@Override
	public int getSendMsg(MessagesVO mvo) {
		return mypageDAO.getSendMsg(mvo);
	}

	@Override
	public MessagesVO getOneMsg(String msg_idx) {
		return mypageDAO.getOneMsg(msg_idx);
	}

	@Override
	public UsersVO getMyInfo(String user_id) {
		return mypageDAO.getMyInfo(user_id);
	}

	@Override
	public int updateInfo(UsersVO uvo) {
		return mypageDAO.updateInfo(uvo);
	}

	@Override
	public List<PostsVO> getPostList(String user_id) {
		return mypageDAO.getPostList(user_id);
	}

	@Override
	public List<Integer> getMyComments(String user_id) {
		return mypageDAO.getMyComments(user_id);
	}

	@Override
	public List<PostsVO> getPostList(List<Integer> post_idx) {
		return mypageDAO.getPostList(post_idx);
	}

	@Override
	public List<Integer> getMyScraps(String user_id) {
		return mypageDAO.getMyScraps(user_id);
	}

	@Override
	public List<PostsVO> getCreateGroup(String user_id) {
		return mypageDAO.getCreateGroup(user_id);
	}

	@Override
	public List<Integer> getJoinGroups(String user_id) {
		return null;
	}

	@Override
	public List<Integer> getMyScrapsGroups(String user_id) {
		return mypageDAO.getMyScrapsGroups(user_id);
	}

}
