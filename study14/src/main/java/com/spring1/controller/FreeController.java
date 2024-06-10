package com.spring1.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.maven.shared.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;
import com.spring1.dto.Free;
import com.spring1.service.CustomService;
import com.spring1.service.FreeService;

@Controller
@RequestMapping("/free/")
public class FreeController {
	private static final Logger log = LoggerFactory.getLogger(FreeController.class);
	
	@Autowired
	private FreeService freeService;
	
	@Autowired
	private CustomService memberService;
	
	@Autowired
	private HttpSession session;
	
    @RequestMapping("list.do")
    public String getFreeList(Model model, @RequestParam(value="page", defaultValue="1") int page) {
        int limit = 10; // 한 페이지당 게시물 수
        int offset = (page - 1) * limit;

        int totalCount = freeService.getTotalCount();
        List<Free> list = freeService.getFreeList(offset, limit);

        int totalPage = (int)Math.ceil((double)totalCount / limit);

        model.addAttribute("list", list);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPage", totalPage);

        return "free/list";
    }
	
	@RequestMapping("detail.do")
	public String getFree(@RequestParam("no") int no, HttpServletRequest req, HttpServletResponse res, Model model) {
		
		String id = (String) session.getAttribute("sid");
		
		Cookie viewCookie = null;
		Cookie[] cookies = req.getCookies();
		
		if(cookies !=null) {
			for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("|"+id+"free"+no+"|")) {
					log.info("쿠키 이름 : "+cookies[i].getName());
					viewCookie=cookies[i];
				}	
			}
		} else {
			log.info("아직 방문한 적이 없습니다.");
		}
		
		if(viewCookie==null) {
            try {
            	//쿠키 생성
				Cookie newCookie=new Cookie("|"+id+"free"+no+"|","readCount");
				res.addCookie(newCookie);
                //쿠키가 없으니 증가 로직 진행
				model.addAttribute("free", freeService.getFree(no));	
			} catch (Exception e) {
				log.info("쿠키 확인 불가 : "+e.getMessage());
				e.getStackTrace();
			}
        //만들어진 쿠키가 있으면 증가로직 진행하지 않음
		} else {
			model.addAttribute("free", freeService.getNoCountFree(no));
			log.info("viewCookie 확인 로직 : 쿠키 있음");
			String value=viewCookie.getValue();
			log.info("viewCookie 확인 로직 : 쿠키 value : "+value);
		}
		
		return "free/get";
	}

	@GetMapping("insert.do")
	public String insFree(Free Free, Model model) {
		return "free/insert";
	}
	
	@PostMapping("insertPro.do")
	public String insFreePro(Free free, HttpSession session, Model model) {
		String id = (String) session.getAttribute("sid");
		String name = (String) session.getAttribute("sname");
		free.setId(id);
		free.setName(name);
		freeService.insFree(free);
		return "redirect:list.do";
	}

	@GetMapping("update.do")
	public String upFree(@RequestParam("no") int no, HttpServletRequest req, HttpServletResponse res,Model model) {
		
		String id = (String) session.getAttribute("sid");
		
		Cookie viewCookie = null;
		Cookie[] cookies = req.getCookies();
		
		if(cookies !=null) {
			for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("|"+id+"free"+no+"|")) {
					log.info("쿠키 이름 : "+cookies[i].getName());
					viewCookie=cookies[i];
				}	
			}
		} else {
			log.info("아직 방문한 적이 없습니다.");
		}
		
		if(viewCookie==null) {
            try {
            	//쿠키 생성
				Cookie newCookie=new Cookie("|"+id+"free"+no+"|","readCount");
				res.addCookie(newCookie);
                //쿠키가 없으니 증가 로직 진행
				model.addAttribute("free", freeService.getFree(no));	
			} catch (Exception e) {
				log.info("쿠키 확인 불가 : "+e.getMessage());
				e.getStackTrace();
			}
        //만들어진 쿠키가 있으면 증가로직 진행하지 않음
		} else {
			model.addAttribute("free", freeService.getNoCountFree(no));
			log.info("viewCookie 확인 로직 : 쿠키 있음");
			String value=viewCookie.getValue();
			log.info("viewCookie 확인 로직 : 쿠키 value : "+value);
		}
		
		return "free/edit";
	}
	
	@PostMapping("updatePro.do")
	public String upFreePro(Free free, Model model) {
		freeService.upFree(free);
		return "redirect:list.do";
	}
	
	@GetMapping("delFree.do")
	public String delFree(@RequestParam("no") int no, Model model) {
		freeService.delFree(no);
		return "redirect:list.do";
	}
	
	@PostMapping("fileupload.do") 
	@ResponseBody
	public String fileUpload(HttpServletRequest req, HttpServletResponse resp, 
            MultipartHttpServletRequest multiFile) throws Exception {
		JsonObject json = new JsonObject();
		PrintWriter printWriter = null;
		OutputStream out = null;
		MultipartFile file = multiFile.getFile("upload");
		if(file != null){
			if(file.getSize() > 0 && StringUtils.isNotBlank(file.getName())){
				if(file.getContentType().toLowerCase().startsWith("images/")){
					try{
						String fileName = file.getName();
						byte[] bytes = file.getBytes();
						String uploadPath = req.getServletContext().getRealPath("/img");
						File uploadFile = new File(uploadPath);
						if(!uploadFile.exists()){
							uploadFile.mkdirs();
						}
						fileName = UUID.randomUUID().toString();
						uploadPath = uploadPath + "/" + fileName;
						out = new FileOutputStream(new File(uploadPath));
	                   out.write(bytes);
	                   
	                   printWriter = resp.getWriter();
	                   resp.setContentType("text/html");
	                   String fileUrl = req.getContextPath() + "/images/" + fileName;
	                   
	                   // json 데이터로 등록
	                   // {"uploaded" : 1, "fileName" : "test.jpg", "url" : "/images/test.jpg"}
	                   // 이런 형태로 리턴이 나가야함.
	                   json.addProperty("uploaded", 1);
	                   json.addProperty("fileName", fileName);
	                   json.addProperty("url", fileUrl);
	                   
	                   printWriter.println(json);
	               }catch(IOException e){
	                   e.printStackTrace();
	               }finally{
	                   if(out != null){
	                       out.close();
	                   }
	                   if(printWriter != null){
	                       printWriter.close();
	                   }		
					}
				}
			}
		}
		return null;
	}
}
