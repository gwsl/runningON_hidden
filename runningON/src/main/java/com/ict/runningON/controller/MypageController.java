package com.ict.runningON.controller;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ict.runningON.service.MypageService;
import com.ict.runningON.vo.MessagesVO;
import com.ict.runningON.vo.PostsVO;
import com.ict.runningON.vo.UsersVO;

@Controller
public class MypageController {
	
	@Autowired
	private MypageService mypageService;
	
	
	// ����������(index)
//	@GetMapping("/home")
//	public ModelAndView homePage() {
//		return new ModelAndView("index");
//	}

	@GetMapping("/mypage")
	public ModelAndView mypage(HttpSession session) {
		session.setAttribute("user_id", "test2");
		return new ModelAndView("mypage/mypage");
	}
	
	@GetMapping("/my_info")
	public ModelAndView my_info(HttpSession session) {
		String user_id = (String) session.getAttribute("user_id");
		ModelAndView mv = new ModelAndView("mypage/my_info");
		UsersVO uservo = mypageService.getMyInfo(user_id);
		mv.addObject("k", uservo);
		return mv;
	}
	@GetMapping("/my_act")
	public ModelAndView myAct(HttpSession session) {
		ModelAndView mv = new ModelAndView("mypage/my_act");
		String user_id = (String) session.getAttribute("user_id");
		List<PostsVO> list = mypageService.getPostList(user_id);
		mv.addObject("list", list);
		UsersVO uservo = mypageService.getMyInfo(user_id);
		mv.addObject("my", uservo);
		return mv;
	}
	
	@GetMapping("/my_comment")
	public ModelAndView my_comment(HttpSession session) {
		ModelAndView mv = new ModelAndView("mypage/my_comment");
		String user_id = (String) session.getAttribute("user_id");
		List<Integer> post_idx = mypageService.getMyComments(user_id);
		// System.out.println(post_idx);
		List<PostsVO> list = mypageService.getPostList(post_idx);
		mv.addObject("list", list);
		UsersVO uservo = mypageService.getMyInfo(user_id);
		mv.addObject("my", uservo);
		return mv; 
	}
	@GetMapping("/my_scrap")
	public ModelAndView scrap(HttpSession session) {
		ModelAndView mv = new ModelAndView("mypage/my_scrap");
		String user_id = (String) session.getAttribute("user_id");
		List<Integer> post_idx = mypageService.getMyScraps(user_id);
		List<PostsVO> list = mypageService.getPostList(post_idx);
		mv.addObject("list", list);
		UsersVO uservo = mypageService.getMyInfo(user_id);
		mv.addObject("my", uservo);
		return mv;
	}
	@GetMapping("/my_create_group")
	public ModelAndView view5() {
		ModelAndView mv = new ModelAndView("mypage/my_create_group");
		return mv;
	}
	@GetMapping("/my_join_group")
	public ModelAndView view6() {
		ModelAndView mv = new ModelAndView("mypage/my_join_group");
		return mv;
	}
	@GetMapping("/my_interest_group")
	public ModelAndView view7() {
		ModelAndView mv = new ModelAndView("mypage/my_interest_group");
		return mv;
	}
	@GetMapping("/my_msg_write")
	public ModelAndView my_msg_write(String msg_receiver_id) {
		ModelAndView mv = new ModelAndView("mypage/my_msg_write");
		mv.addObject("rewrite", msg_receiver_id);
		
		return mv;
	}
	@GetMapping("/my_msg_receive")
	public ModelAndView my_msg_recive(HttpSession session) {
		String user_id = (String) session.getAttribute("user_id");
		ModelAndView mv = new ModelAndView("mypage/my_msg_receive");
		List<MessagesVO> list = mypageService.getReceiveMsgList(user_id);
		if (list != null) {
			mv.addObject("list", list);
			return mv;
		}
		return null;
	}
	@GetMapping("/my_msg_send")
	public ModelAndView my_msg_send(HttpSession session) {
		String user_id = (String) session.getAttribute("user_id");
		ModelAndView mv = new ModelAndView("mypage/my_msg_send");
		List<MessagesVO> list = mypageService.getSendMsgList(user_id);
		if (list != null) {
			mv.addObject("list", list);
			return mv;
		}
		return null;
	}
	@RequestMapping("/msg_write_ok")
	public ModelAndView msg_send_ok(MessagesVO mvo, HttpSession session) {
		String msg_sender_id = (String) session.getAttribute("user_id");
		ModelAndView mv = new ModelAndView("redirect:/my_msg_send");
		mvo.setMsg_sender_id(msg_sender_id);
		
		int result = mypageService.getSendMsg(mvo);
		if (result>0) {
			return mv;
		}
		return null;
	}
	
	@GetMapping("/my_msg_detail")
	public ModelAndView my_msg_detail(String msg_idx) {
		ModelAndView mv = new ModelAndView("mypage/my_msg_detail");
		MessagesVO list = mypageService.getOneMsg(msg_idx);
		
		mv.addObject("list", list);
		return mv;
		
	}
	
	@PostMapping("/my_info_update")
	public ModelAndView updateProfile(
		    @RequestParam(value = "profileImage", required = false) MultipartFile profileImage,
		    @RequestParam("nickname") String nickname, Boolean deleteimage,
		    HttpServletRequest request, HttpSession session) {
		try {
			ModelAndView mv = new ModelAndView("redirect:/my_info");
			String user_id = (String) session.getAttribute("user_id");
		    UsersVO uvo = new UsersVO();
		    uvo.setUser_id(user_id);
		  
		    uvo.setUser_nickName(nickname);
		    String path = request.getSession().getServletContext().getRealPath("/resources/upload");
			
		    // �̹��� ���� ó��
	        if (profileImage == null && deleteimage == true) {
	        	uvo.setUser_profileImg("");
	        }else if(profileImage == null && deleteimage == false){
	        	uvo.setUser_profileImg("maintain");
	        }else {
	        	UUID uuid = UUID.randomUUID();
	        	String f_name = UUID.randomUUID().toString() + "_" + profileImage.getOriginalFilename();
	            uvo.setUser_profileImg(f_name);

	            profileImage.transferTo(new File(path, f_name));
	            // �ʿ��, �̹��� ���� ��� ���� ���� �߰�
	        }

	        // ���� ���� ó�� (�ʿ�� DB�� ���� ���� �߰�)
	        // ��: userService.updateNickname(userId, nickname);
	        int result = mypageService.updateInfo(uvo);
	        request.setAttribute("result", result);
	        
	        return mv;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	@RequestMapping("/cancel")
	public ModelAndView cancel() {
		return new ModelAndView("redirect:/my_info");
	}
	
	
}
