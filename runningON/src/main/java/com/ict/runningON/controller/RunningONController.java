package com.ict.runningON.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RunningONController {
	
	/* 최소희 */
	
	// 날씨 페이지
	@GetMapping("/weather")
	public ModelAndView ajaxTest() {
		return new ModelAndView("/weather");
	}
	
	// 로그인 페이지
	@GetMapping("/login1")
	public ModelAndView login1() {
		return new ModelAndView("/login");
	}
    
	// 회원가입 페이지
	@GetMapping("/login_join_form")
	public ModelAndView join() {
		return new ModelAndView("/join");
	}
	
	/* 심현보 */
	
	// 메인페이지(index)
	@GetMapping("/home")
	public ModelAndView homePage() {
		return new ModelAndView("index");
	}
	
	// 게시판 페이지
	@GetMapping("/free_board")
	public ModelAndView freeBoard() {
		return new ModelAndView("boards/board");
	}
	
	// 러닝모임 게시판
	@GetMapping("/group_board")
	public ModelAndView group() {
		return new ModelAndView("boards/groupboard");
	}
	
	/* 조성주 */
	
	// 게시글 작성 페이지
	@GetMapping("/write")
	public ModelAndView boardwrite() {
		ModelAndView mv = new ModelAndView("posts/write");		
		return mv;
	}
	
	// 게시글 내용 페이지
	@GetMapping("/detail")
	public ModelAndView boarddetail() {
		ModelAndView mv = new ModelAndView("posts/detail");		
		return mv;
	}
	
	// 게시글 이미지
	@GetMapping("/uploadImage")
	@ResponseBody
	public String uploadImage(@RequestParam("file") MultipartFile file) {
	    // 파일 저장 경로 지정
	    String uploadDir = "/resources/upload/";

	    // 파일 이름 설정 및 저장
	    String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
	    File saveFile = new File(uploadDir, fileName);
	    try {
	        file.transferTo(saveFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return "error";
	    }

	    // 저장된 파일의 URL 반환
	    return "/resources/upload/" + fileName;
	}
	
	/* 이하나 */
	
	// 모임 글쓰기
	@GetMapping("/groupstart")
	public ModelAndView groupstart() {
		return new ModelAndView("runninggroup/groupstart");
	}
	
	// 모임 가입 페이지
	@GetMapping("/join_main")
	public ModelAndView rungroup2() {
		return new ModelAndView("runninggroup/join_main");
	}
	
	// 모임 내부 페이지
	@GetMapping("/rungroup")
	public ModelAndView rungroup() {
		return new ModelAndView("runninggroup/onegroup");
	}
	
	/* 고건우 */
	
	@GetMapping("/view1")
	public ModelAndView view1() {
		return new ModelAndView("mypage/view1");
	}
	@GetMapping("/view2")
	public ModelAndView view2() {
		return new ModelAndView("mypage/view2");
	}
	@GetMapping("/view3")
	public ModelAndView view3() {
		ModelAndView mv = new ModelAndView("mypage/view3");
		return mv;
	}
	@GetMapping("/view4")
	public ModelAndView view4() {
		ModelAndView mv = new ModelAndView("mypage/view4");
		return mv;
	}
	@GetMapping("/view5")
	public ModelAndView view5() {
		ModelAndView mv = new ModelAndView("mypage/view5");
		return mv;
	}
	@GetMapping("/view6")
	public ModelAndView view6() {
		ModelAndView mv = new ModelAndView("mypage/view6");
		return mv;
	}
	@GetMapping("/view7")
	public ModelAndView view7() {
		ModelAndView mv = new ModelAndView("mypage/view7");
		return mv;
	}
	@GetMapping("/view8")
	public ModelAndView view8() {
		ModelAndView mv = new ModelAndView("mypage/view8");
		return mv;
	}
	@GetMapping("/view9")
	public ModelAndView view9() {
		ModelAndView mv = new ModelAndView("mypage/view9");
		return mv;
	}
	@GetMapping("/view10")
	public ModelAndView view10() {
		ModelAndView mv = new ModelAndView("mypage/view10");
		return mv;
	}
	@GetMapping("/view11")
	public ModelAndView view11() {
		ModelAndView mv = new ModelAndView("mypage/view11");
		return mv;
	}
	@GetMapping("/view12")
	public ModelAndView view12() {
		ModelAndView mv = new ModelAndView("mypage/view12");
		return mv;
	}
	@GetMapping("/view13")
	public ModelAndView view13() {
		ModelAndView mv = new ModelAndView("mypage/view13");
		return mv;
	}
	
	
}