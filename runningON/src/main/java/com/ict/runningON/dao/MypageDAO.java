package com.ict.runningON.dao;

import java.util.List;

import com.ict.runningON.vo.MessagesVO;
import com.ict.runningON.vo.PostsVO;
import com.ict.runningON.vo.RunGroupsVO;
import com.ict.runningON.vo.UsersVO;

public interface MypageDAO {
	
	public UsersVO getMyInfo(String user_id);
	public List<PostsVO> getPostList(String user_id);
	public List<PostsVO> getPostList(List<Integer> post_idx);
	public List<MessagesVO> getSendMsgList(String user_id);
	public List<MessagesVO> getReceiveMsgList(String user_id);
	public int getSendMsg(MessagesVO mvo);
	public MessagesVO getOneMsg(String msg_idx);
	public int updateInfo(UsersVO uvo);
	public List<Integer> getMyComments(String user_id);
	public List<Integer> getMyScraps(String user_id);
	public List<PostsVO> getCreateGroup(String user_id);
	public List<Integer> getJoinGroups(String user_id);
	public List<Integer> getMyScrapsGroups(String user_id);
}
