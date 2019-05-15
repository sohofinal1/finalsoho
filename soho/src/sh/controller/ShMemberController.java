package sh.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sh.model.ShMemberDto;
import sh.service.ShMemberService;

@Controller
public class ShMemberController {

	
		
		private static final Logger logger 
			= LoggerFactory.getLogger(ShMemberController.class);
			
		@Autowired
		ShMemberService ShMemberService;
		
		@RequestMapping(value = "login.do", method = RequestMethod.GET)
		public String login() {
			logger.info("ShMemberController login " + new Date());		
			return "login.tiles";
		}
		
		@RequestMapping(value = "regiAf.do", method = RequestMethod.POST)
		public String regiAf(ShMemberDto dto)throws Exception {		
			logger.info("ShMemberController regiAf " + new Date());
			// logger.info(dto.toString());	
			
			boolean b = ShMemberService.addmember(dto);		
			if(b) {
				return "redirect:/login.do";
			}else {
				return "redirect:/regi.do";
			}		
		}
		
		@RequestMapping(value = "loginAf.do", method = RequestMethod.POST)
		public String loginAf(ShMemberDto dto, HttpServletRequest req) {	
			logger.info("ShMemberController loginAf " + new Date());
			
			ShMemberDto login = ShMemberService.login(dto);
			
			if(login != null && !login.getId().equals("")) {
				logger.info("ShMemberController loginAf SUC " + new Date());
				// session 저장
				req.getSession().setAttribute("login", login);			
				// 이동
				return "main.tiles";
				// return "forward:/bbslist.do";
			}else {	
				logger.info("ShMemberController loginAf Fail " + new Date());
				
				return "login.tiles";
			}		
		}
		
		@ResponseBody
		@RequestMapping(value="getId.do", method=RequestMethod.POST)
		public String getId(ShMemberDto mem) {
			logger.info("ShMemberController getId " + new Date());
			
			int count = ShMemberService.getId(mem);
			
			String msg = "";
			if(count > 0) {
				msg = "YES";
			}else {
				msg = "NO";
			}
			return msg;
		}

		@RequestMapping(value="logout.do", method=RequestMethod.GET)
		public String logout(HttpServletRequest req) {
			req.getSession().invalidate();
			return "login.tiles";		
		}
	}

