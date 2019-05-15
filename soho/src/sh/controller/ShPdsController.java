package sh.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import sh.model.ShPdsDto;
import sh.service.ShPdsService;
import sh.util.FUpUtil;

@Controller
public class ShPdsController {

	private static final Logger logger
	 = LoggerFactory.getLogger(ShPdsController.class);
	
	@Autowired
	ShPdsService ShPdsService;
	
	@RequestMapping(value="pdslist.do", method={RequestMethod.GET, RequestMethod.POST})
	public String pdslist(Model model) {
		
		logger.info("ShPdsController pdslist " + new Date());
		
		List<ShPdsDto> list = ShPdsService.getShPdsList();
		model.addAttribute("pdslist", list);
		
		return "pdslist.tiles";
		
	}
	
	@RequestMapping(value="pdswrite.do", method={RequestMethod.GET, RequestMethod.POST})
	public String pdswrite(Model model) {
		logger.info("ShPdsController pdswrite " + new Date());
		
		return "pdswrite.tiles";
	}
	
	@RequestMapping(value="pdsupload.do", method={RequestMethod.GET, RequestMethod.POST})
	public String pdsupload(ShPdsDto pdsdto,
							@RequestParam(value="fileload", required=false)MultipartFile fileload,
							HttpServletRequest req) {
	
		//	@RequestParam 어노테이션을 이용한 파라미터 매핑
		// 파라미터 fileload가 존재하지 않음녀 null값으로 적용
		logger.info("ShPdsController pdsupload " + new Date());
		
		//filename을 취득
		String filename = fileload.getOriginalFilename();
		pdsdto.setFilename(filename);
		
		//upload 경로
		//tomcat
		String fupload = req.getServletContext().getRealPath("/upload");
		
		//file(d드라이브 tmp 폴더에 작성함
		//String fuplad = "d:\\tmp";
		
		//파일명.xxx -> 12232132.xxx
		String f = pdsdto.getFilename();	//위에 파일 네임을 set로 해주고 get을 가져오기
		String newfilename = FUpUtil.getNewFile(f);		//변경을 newfilename에 넣어놈
		
		pdsdto.setFilename(newfilename);
		

		File file = new File(fupload + "/" + newfilename);
		System.out.println("upload 파일경로:" + fupload + "/" + newfilename);
		
		try {
			//실제 파일 업로드 부분
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());	//바이트 단위로 저장할거라서
				
			//db 저장
			ShPdsService.uploadPds(pdsdto);
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/pdslist.do";			
			
	}
	
}
