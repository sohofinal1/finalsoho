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
	
		//	@RequestParam ������̼��� �̿��� �Ķ���� ����
		// �Ķ���� fileload�� �������� ������ null������ ����
		logger.info("ShPdsController pdsupload " + new Date());
		
		//filename�� ���
		String filename = fileload.getOriginalFilename();
		pdsdto.setFilename(filename);
		
		//upload ���
		//tomcat
		String fupload = req.getServletContext().getRealPath("/upload");
		
		//file(d����̺� tmp ������ �ۼ���
		//String fuplad = "d:\\tmp";
		
		//���ϸ�.xxx -> 12232132.xxx
		String f = pdsdto.getFilename();	//���� ���� ������ set�� ���ְ� get�� ��������
		String newfilename = FUpUtil.getNewFile(f);		//������ newfilename�� �־��
		
		pdsdto.setFilename(newfilename);
		

		File file = new File(fupload + "/" + newfilename);
		System.out.println("upload ���ϰ��:" + fupload + "/" + newfilename);
		
		try {
			//���� ���� ���ε� �κ�
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());	//����Ʈ ������ �����ҰŶ�
				
			//db ����
			ShPdsService.uploadPds(pdsdto);
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/pdslist.do";			
			
	}
	
}
