package com.spring1.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring1.dto.Custom;
import com.spring1.service.CustomService;

@Controller
@RequestMapping("/email/")
public class EmailController {
	
	private static final Logger log = LoggerFactory.getLogger(EmailController.class);
	
	@Autowired
	private JavaMailSenderImpl mailSender; //네이버 메일
	
	@Autowired
	private JavaMailSenderImpl mailSender2; //지메일
	
	@Autowired
	private JavaMailSenderImpl mailSender3; //다음 메일

	@Autowired
	private String uploadPath;
	
	@Autowired
	private CustomService customService;
	
	@GetMapping("main")
	public String home(Model model) {
		return "email/home";
	}
	
	@GetMapping("email1")
	public String email1(Model model) {
		return "email/sendEmail1";
	}
	
	@GetMapping("email2")
	public String email2(Model model) {
		return "email/sendEmail2";
	}
	
	@GetMapping("email3")
	public String email3(Model model) {
		return "email/sendEmail3";
	}

	@GetMapping("email4")
	public String email4(Model model) {
		return "email/sendEmail4";
	}
	
	@GetMapping("email5")
	public String email5(Model model) {
		return "email/sendEmail5";
	}

	@GetMapping("email11")
	public String email11(Model model) {
		return "email/sendEmail11";
	}
	
	@GetMapping("email12")
	public String email12(Model model) {
		return "email/sendEmail12";
	}
	
	@GetMapping("email13")
	public String email13(Model model) {
		return "email/sendEmail13";
	}

	@GetMapping("email14")
	public String email14(Model model) {
		return "email/sendEmail14";
	}
	
	@GetMapping("email15")
	public String email15(Model model) {
		return "email/sendEmail15";
	}
	
	@GetMapping("email21")
	public String email21(Model model) {
		return "email/sendEmail21";
	}
	
	@GetMapping("email22")
	public String email22(Model model) {
		return "email/sendEmail22";
	}
	
	@GetMapping("email23")
	public String email23(Model model) {
		return "email/sendEmail23";
	}

	@GetMapping("email24")
	public String email24(Model model) {
		return "email/sendEmail24";
	}
	
	@GetMapping("email25")
	public String email25(Model model) {
		return "email/sendEmail25";
	}
	
	//여기부터는 네이버 이메일 보내기입니다.
	//1. MimeMessage 객체를 직접 생성하여 메일을 발송하는 방법
	@RequestMapping(value = "sendMail1", method = RequestMethod.POST)
    public String sendMailTest(HttpServletRequest req, Model model) throws Exception{
		String author = req.getParameter("author");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");
        String from = req.getParameter("from");
        String to = req.getParameter("to");
        boolean ps = false;
        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail,true,"UTF-8");
            // true는 멀티파트 메세지를 사용하겠다는 의미
            /*
             * 단순한 텍스트 메세지만 사용시엔 아래의 코드도 사용 가능 
             * MimeMessageHelper mailHelper = new MimeMessageHelper(mail,"UTF-8");
             */
            mailHelper.setFrom(from);
            // 빈에 아이디 설정한 것은 단순히 smtp 인증을 받기 위해 사용 따라서 보내는이(setFrom())반드시 필요
            // 보내는이와 메일주소를 수신하는이가 볼때 모두 표기 되게 원하신다면 아래의 코드를 사용하시면 됩니다.
            //mailHelper.setFrom("보내는이 이름 <보내는이 아이디@도메인주소>");
            mailHelper.setTo(to);
            mailHelper.setSubject(subject);
            mailHelper.setText(content, true);
            // true는 html을 사용하겠다는 의미입니다.            
            /*
             * 단순한 텍스트만 사용하신다면 다음의 코드를 사용하셔도 됩니다. mailHelper.setText(content);
             */
            mailSender.send(mail);
            ps = true;
        } catch(Exception e) {
        	ps= false;
            e.printStackTrace();
        } 

        model.addAttribute("ps", ps);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("name", author+"/"+name+"/"+tel);
        model.addAttribute("subject", subject);
        model.addAttribute("content", content);
        
        return "email/sendEmailOk1";
    }

	
	//2. MimeMessagePreparator를 사용해서 메일을 전송하는 방법
    @RequestMapping(value = "sendMail2", method = RequestMethod.GET)
    public String sendMail2(HttpServletRequest req, Model model) throws Exception{
		String author = req.getParameter("author");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");
        String from = req.getParameter("from");
        String to = req.getParameter("to"); 
        boolean ps = false;
        final MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception{
                final MimeMessageHelper mailHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");                
                mailHelper.setFrom(from);
                mailHelper.setTo(to);
                mailHelper.setSubject(subject);
                mailHelper.setText(content, true);
            }            
        };
        try {    
            mailSender.send(preparator);
            ps = true;
        } catch(Exception e) {
        	ps = false;
            e.printStackTrace();
        }
        
        model.addAttribute("ps", ps);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("name", author+"/"+name+"/"+tel);
        model.addAttribute("subject", subject);
        model.addAttribute("content", content);
        
        return "email/sendEmailOk2";
    }
    
    
    //3. 이미지를 내장하여 이메일 발송
    @RequestMapping(value = "sendMail3", method = RequestMethod.GET)
    public String sendMail3(MultipartHttpServletRequest multi, Model model) throws Exception{
    	
    	String root = multi.getSession().getServletContext().getRealPath("/");
    	String path = root + "resources/upload/";
    	boolean ps = false;
    	
    	File dir = new File(path);
    	
    	if(!dir.isDirectory()) {	//해당 디렉토리가 없는 경우 디렉토리 생성
    		dir.mkdir();
    	}
    	
    	Iterator<String> files = multi.getFileNames();
    	
    	String fileName_original = "";
    	String uploadFile = "";
    	MultipartFile mFile;
    	long size = 0L;
    	if(files.hasNext()) {
    		uploadFile = files.next();
    		mFile = multi.getFile(uploadFile);
    		fileName_original = mFile.getOriginalFilename();
    		try {
    			mFile.transferTo(new File(uploadPath+fileName_original));
    			size = mFile.getSize();
    			log.info("전송된 파일 이름 : "+fileName_original);
    			log.info("전송된 파일 크기 : "+mFile.getSize());
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
		String author = multi.getParameter("author");
		String name = multi.getParameter("name");
		String tel = multi.getParameter("tel");
        String subject = multi.getParameter("subject");
        String content = multi.getParameter("content") + "<img src='"+fileName_original+"'>";
        String from = multi.getParameter("from");
        String to = multi.getParameter("to");
        
        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail,true,"UTF-8");
            mailHelper.setFrom(from);
            mailHelper.setTo(to);
            mailHelper.setSubject(subject);
            mailHelper.setText(content, true);
            mailSender.send(mail);
            ps = true;
        } catch(Exception e) {
        	ps = false;
            e.printStackTrace();
        }
        
        model.addAttribute("ps", ps);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("name", author+"/"+name+"/"+tel);
        model.addAttribute("subject", subject);
        model.addAttribute("content", content);
        model.addAttribute("filename", fileName_original);
        model.addAttribute("size", size);
        
        return "email/sendEmailOk3";
    }

    
    //4. 파일을 첨부하여 이메일 발송
    @RequestMapping(value = "sendMail4", method = RequestMethod.GET)
    public String sendMail4(MultipartHttpServletRequest multi, Model model) throws Exception{
    	String root = multi.getSession().getServletContext().getRealPath("/");
    	String path = root + "resources/upload/";  
    	boolean ps = false;
    	
    	File dir = new File(path);
    	
    	if(!dir.isDirectory()) {	//해당 디렉토리가 없는 경우 디렉토리 생성
    		dir.mkdir();
    	}
    	
    	Iterator<String> files = multi.getFileNames();
    	String fileName_original = "";
    	String uploadFile = "";
    	MultipartFile mFile;
    	long size = 0L;
    	
    	if(files.hasNext()) {
    		uploadFile = files.next();
    		mFile = multi.getFile(uploadFile);
    		fileName_original = mFile.getOriginalFilename();
    		try {
    			mFile.transferTo(new File(uploadPath+fileName_original));
    			size = mFile.getSize();
    			log.info("전송된 파일 이름 : "+fileName_original);
    			log.info("전송된 파일 크기 : "+mFile.getSize());
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
		String author = multi.getParameter("author");
		String name = multi.getParameter("name");
		String tel = multi.getParameter("tel");
        String subject = multi.getParameter("subject");
        String content = multi.getParameter("content");
        String from = multi.getParameter("from");
        String to = multi.getParameter("to");
        
        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail,true,"UTF-8");
            mailHelper.setFrom(from);
            mailHelper.setTo(to);
            mailHelper.setSubject(subject);
            mailHelper.setText(content, true);
            FileSystemResource file = new FileSystemResource(new File(uploadPath+fileName_original)); 
            mailHelper.addAttachment(fileName_original, file);
            mailSender.send(mail);
            ps = true;
        } catch(Exception e) {
        	ps = false;
            e.printStackTrace();
        }
        
        model.addAttribute("ps", ps);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("name", author+"/"+name+"/"+tel);
        model.addAttribute("subject", subject);
        model.addAttribute("content", content);
        model.addAttribute("filename", fileName_original);
        model.addAttribute("size", size);
        
        return "email/sendEmailOk4";
    }
    
    
    //5. 이메일 인증번호 보내기 
    @RequestMapping("findAuth")
    @ResponseBody
    public Map findAuth(@ModelAttribute("vo") Custom vo, Model model) {
        
        Map map = new HashMap();
        
        //사용자가 작성한 아이디를 기준으로 존재하는 사용자인지 확인한다.(id는 회원가입시 중복 체크를 했기 때문에 유니크하다.)
        Custom isUser = customService.getCustom(vo.getId());
        
        if(isUser != null) {//회원가입이 되어있는, 존재하는 사용자라면
            Random r = new Random();
            int num = r.nextInt(999999); //랜덤 난수 
            
            StringBuilder sb = new StringBuilder();
            
            // DB에 저장된 email            입력받은 email
            if(isUser.getEmail().equals(vo.getEmail())) {//이메일 정보 또한 동일하다면 
        
                String setFrom = "kkt09072@naver.com";//발신자 이메일
                String tomail = isUser.getEmail();//수신자 이메일
                String title = "비밀번호 변경 인증 이메일입니다.";
                sb.append(String.format("안녕하세요 %s님\n", isUser.getName()));
                sb.append(String.format("비밀번호 찾기(변경) 인증번호는 %d입니다.", num));
                String content = sb.toString();
                
                try {
                    MimeMessage msg = mailSender.createMimeMessage();
                    MimeMessageHelper msgHelper = new MimeMessageHelper(msg, true, "utf-8");
                    msgHelper.setFrom(setFrom);
                    msgHelper.setTo(tomail);
                    msgHelper.setSubject(title);
                    msgHelper.setText(content);
                    mailSender.send(msg);                    //메일 전송                    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                
                //성공적으로 메일을 보낸 경우
                map.put("status", true);
                map.put("num", num);
                map.put("m_idx", isUser.getId());                
            }
        }
		return map;
    }    
    

    
    
    
    /* 여기 부터는 Gmail 입니다. */
	//1. MimeMessage 객체를 직접 생성하여 메일을 발송하는 방법
	@RequestMapping(value = "sendMail11", method = RequestMethod.POST)
    public String sendMailTest11(HttpServletRequest req, Model model) throws Exception{
		String author = req.getParameter("author");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");
        String from = req.getParameter("from");
        String to = req.getParameter("to");
        boolean ps = false;
        try {
            MimeMessage mail = mailSender2.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail,true,"UTF-8");
            // true는 멀티파트 메세지를 사용하겠다는 의미
            /*
             * 단순한 텍스트 메세지만 사용시엔 아래의 코드도 사용 가능 
             * MimeMessageHelper mailHelper = new MimeMessageHelper(mail,"UTF-8");
             */
            mailHelper.setFrom(from);
            // 빈에 아이디 설정한 것은 단순히 smtp 인증을 받기 위해 사용 따라서 보내는이(setFrom())반드시 필요
            // 보내는이와 메일주소를 수신하는이가 볼때 모두 표기 되게 원하신다면 아래의 코드를 사용하시면 됩니다.
            //mailHelper.setFrom("보내는이 이름 <보내는이 아이디@도메인주소>");
            mailHelper.setTo(to);
            mailHelper.setSubject(subject);
            mailHelper.setText(content, true);
            // true는 html을 사용하겠다는 의미입니다.            
            /*
             * 단순한 텍스트만 사용하신다면 다음의 코드를 사용하셔도 됩니다. mailHelper.setText(content);
             */
            mailSender2.send(mail);
            ps = true;
        } catch(Exception e) {
        	ps= false;
            e.printStackTrace();
        } 

        model.addAttribute("ps", ps);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("name", author+"/"+name+"/"+tel);
        model.addAttribute("subject", subject);
        model.addAttribute("content", content);
        
        return "email/sendEmailOk11";
    }

	
	//2. MimeMessagePreparator를 사용해서 메일을 전송하는 방법
    @RequestMapping(value = "sendMail12", method = RequestMethod.GET)
    public String sendMail12(HttpServletRequest req, Model model) throws Exception{
		String author = req.getParameter("author");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");
        String from = req.getParameter("from");
        String to = req.getParameter("to"); 
        boolean ps = false;
        final MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception{
                final MimeMessageHelper mailHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");                
                mailHelper.setFrom(from);
                mailHelper.setTo(to);
                mailHelper.setSubject(subject);
                mailHelper.setText(content, true);
            }            
        };
        try {    
            mailSender2.send(preparator);
            ps = true;
        } catch(Exception e) {
        	ps = false;
            e.printStackTrace();
        }
        
        model.addAttribute("ps", ps);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("name", author+"/"+name+"/"+tel);
        model.addAttribute("subject", subject);
        model.addAttribute("content", content);
        
        return "email/sendEmailOk12";
    }
    
    
    //3. 이미지를 내장하여 이메일 발송
    @RequestMapping(value = "sendMail13", method = RequestMethod.GET)
    public String sendMail13(MultipartHttpServletRequest multi, Model model) throws Exception{
    	
    	String root = multi.getSession().getServletContext().getRealPath("/");
    	String path = root + "resources/upload/";
    	boolean ps = false;
    	
    	File dir = new File(path);
    	
    	if(!dir.isDirectory()) {	//해당 디렉토리가 없는 경우 디렉토리 생성
    		dir.mkdir();
    	}
    	
    	Iterator<String> files = multi.getFileNames();
    	
    	String fileName_original = "";
    	String uploadFile = "";
    	MultipartFile mFile;
    	long size = 0L;
    	if(files.hasNext()) {
    		uploadFile = files.next();
    		mFile = multi.getFile(uploadFile);
    		fileName_original = mFile.getOriginalFilename();
    		try {
    			mFile.transferTo(new File(uploadPath+fileName_original));
    			size = mFile.getSize();
    			log.info("전송된 파일 이름 : "+fileName_original);
    			log.info("전송된 파일 크기 : "+mFile.getSize());
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
		String author = multi.getParameter("author");
		String name = multi.getParameter("name");
		String tel = multi.getParameter("tel");
        String subject = multi.getParameter("subject");
        String content = multi.getParameter("content") + "<img src='"+fileName_original+"'>";
        String from = multi.getParameter("from");
        String to = multi.getParameter("to");
        
        try {
            MimeMessage mail = mailSender2.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail,true,"UTF-8");
            mailHelper.setFrom(from);
            mailHelper.setTo(to);
            mailHelper.setSubject(subject);
            mailHelper.setText(content, true);
            mailSender2.send(mail);
            ps = true;
        } catch(Exception e) {
        	ps = false;
            e.printStackTrace();
        }
        
        model.addAttribute("ps", ps);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("name", author+"/"+name+"/"+tel);
        model.addAttribute("subject", subject);
        model.addAttribute("content", content);
        model.addAttribute("filename", fileName_original);
        model.addAttribute("size", size);
        
        return "email/sendEmailOk13";
    }

    
    //4. 파일을 첨부하여 이메일 발송
    @RequestMapping(value = "sendMail14", method = RequestMethod.GET)
    public String sendMail14(MultipartHttpServletRequest multi, Model model) throws Exception{
    	String root = multi.getSession().getServletContext().getRealPath("/");
    	String path = root + "resources/upload/";  
    	boolean ps = false;
    	
    	File dir = new File(path);
    	
    	if(!dir.isDirectory()) {	//해당 디렉토리가 없는 경우 디렉토리 생성
    		dir.mkdir();
    	}
    	
    	Iterator<String> files = multi.getFileNames();
    	String fileName_original = "";
    	String uploadFile = "";
    	MultipartFile mFile;
    	long size = 0L;
    	
    	if(files.hasNext()) {
    		uploadFile = files.next();
    		mFile = multi.getFile(uploadFile);
    		fileName_original = mFile.getOriginalFilename();
    		try {
    			mFile.transferTo(new File(uploadPath+fileName_original));
    			size = mFile.getSize();
    			log.info("전송된 파일 이름 : "+fileName_original);
    			log.info("전송된 파일 크기 : "+mFile.getSize());
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
		String author = multi.getParameter("author");
		String name = multi.getParameter("name");
		String tel = multi.getParameter("tel");
        String subject = multi.getParameter("subject");
        String content = multi.getParameter("content");
        String from = multi.getParameter("from");
        String to = multi.getParameter("to");
        
        try {
            MimeMessage mail = mailSender2.createMimeMessage();
            MimeMessageHelper mailHelper = new MimeMessageHelper(mail,true,"UTF-8");
            mailHelper.setFrom(from);
            mailHelper.setTo(to);
            mailHelper.setSubject(subject);
            mailHelper.setText(content, true);
            FileSystemResource file = new FileSystemResource(new File(uploadPath+fileName_original)); 
            mailHelper.addAttachment(fileName_original, file);
            mailSender2.send(mail);
            ps = true;
        } catch(Exception e) {
        	ps = false;
            e.printStackTrace();
        }
        
        model.addAttribute("ps", ps);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        model.addAttribute("name", author+"/"+name+"/"+tel);
        model.addAttribute("subject", subject);
        model.addAttribute("content", content);
        model.addAttribute("filename", fileName_original);
        model.addAttribute("size", size);
        
        return "email/sendEmailOk14";
    }
    
    
    //5. 이메일 인증번호 보내기 
    @RequestMapping("findAuth2")
    @ResponseBody
    public Map findAuth2(@ModelAttribute("vo") Custom vo, Model model) {
        
        Map map = new HashMap();
        
        //사용자가 작성한 아이디를 기준으로 존재하는 사용자인지 확인한다.(id는 회원가입시 중복 체크를 했기 때문에 유니크하다.)
        Custom isUser = customService.getCustom(vo.getId());
        
        if(isUser != null) {//회원가입이 되어있는, 존재하는 사용자라면
            Random r = new Random();
            int num = r.nextInt(999999); //랜덤 난수 
            
            StringBuilder sb = new StringBuilder();
            
            // DB에 저장된 email            입력받은 email
            if(isUser.getEmail().equals(vo.getEmail())) {//이메일 정보 또한 동일하다면 
        
                String setFrom = "kkt09072@gmail.com";//발신자 이메일
                String tomail = isUser.getEmail();//수신자 이메일
                String title = "비밀번호 변경 인증 이메일입니다.";
                sb.append(String.format("안녕하세요 %s님\n", isUser.getName()));
                sb.append(String.format("비밀번호 찾기(변경) 인증번호는 %d입니다.", num));
                String content = sb.toString();
                
                try {
                    MimeMessage msg = mailSender2.createMimeMessage();
                    MimeMessageHelper msgHelper = new MimeMessageHelper(msg, true, "utf-8");
                    msgHelper.setFrom(setFrom);
                    msgHelper.setTo(tomail);
                    msgHelper.setSubject(title);
                    msgHelper.setText(content);
                    mailSender2.send(msg);                    //메일 전송                    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                
                //성공적으로 메일을 보낸 경우
                map.put("status", true);
                map.put("num", num);
                map.put("m_idx", isUser.getId());                
            }
        }
		return map;
    }    
    

    
    
    
    
    /* 여기 부터는 Daum Email 입니다. */
    //1. MimeMessage 객체를 직접 생성하여 메일을 발송하는 방법
  	@RequestMapping(value = "sendMail21", method = RequestMethod.POST)
      public String sendMailTest21(HttpServletRequest req, Model model) throws Exception{
  		String author = req.getParameter("author");
  		String name = req.getParameter("name");
  		String tel = req.getParameter("tel");
          String subject = req.getParameter("subject");
          String content = req.getParameter("content");
          String from = req.getParameter("from");
          String to = req.getParameter("to");
          boolean ps = false;
          try {
              MimeMessage mail = mailSender3.createMimeMessage();
              MimeMessageHelper mailHelper = new MimeMessageHelper(mail,true,"UTF-8");
              // true는 멀티파트 메세지를 사용하겠다는 의미
              /*
               * 단순한 텍스트 메세지만 사용시엔 아래의 코드도 사용 가능 
               * MimeMessageHelper mailHelper = new MimeMessageHelper(mail,"UTF-8");
               */
              mailHelper.setFrom(from);
              // 빈에 아이디 설정한 것은 단순히 smtp 인증을 받기 위해 사용 따라서 보내는이(setFrom())반드시 필요
              // 보내는이와 메일주소를 수신하는이가 볼때 모두 표기 되게 원하신다면 아래의 코드를 사용하시면 됩니다.
              //mailHelper.setFrom("보내는이 이름 <보내는이 아이디@도메인주소>");
              mailHelper.setTo(to);
              mailHelper.setSubject(subject);
              mailHelper.setText(content, true);
              // true는 html을 사용하겠다는 의미입니다.            
              /*
               * 단순한 텍스트만 사용하신다면 다음의 코드를 사용하셔도 됩니다. mailHelper.setText(content);
               */
              mailSender3.send(mail);
              ps = true;
          } catch(Exception e) {
          	ps= false;
              e.printStackTrace();
          } 

          model.addAttribute("ps", ps);
          model.addAttribute("from", from);
          model.addAttribute("to", to);
          model.addAttribute("name", author+"/"+name+"/"+tel);
          model.addAttribute("subject", subject);
          model.addAttribute("content", content);
          
          return "email/sendEmailOk21";
      }

  	
  	//2. MimeMessagePreparator를 사용해서 메일을 전송하는 방법
      @RequestMapping(value = "sendMail22", method = RequestMethod.GET)
      public String sendMail22(HttpServletRequest req, Model model) throws Exception{
  		String author = req.getParameter("author");
  		String name = req.getParameter("name");
  		String tel = req.getParameter("tel");
          String subject = req.getParameter("subject");
          String content = req.getParameter("content");
          String from = req.getParameter("from");
          String to = req.getParameter("to"); 
          boolean ps = false;
          final MimeMessagePreparator preparator = new MimeMessagePreparator() {
              public void prepare(MimeMessage mimeMessage) throws Exception{
                  final MimeMessageHelper mailHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");                
                  mailHelper.setFrom(from);
                  mailHelper.setTo(to);
                  mailHelper.setSubject(subject);
                  mailHelper.setText(content, true);
              }            
          };
          try {    
              mailSender3.send(preparator);
              ps = true;
          } catch(Exception e) {
          	ps = false;
              e.printStackTrace();
          }
          
          model.addAttribute("ps", ps);
          model.addAttribute("from", from);
          model.addAttribute("to", to);
          model.addAttribute("name", author+"/"+name+"/"+tel);
          model.addAttribute("subject", subject);
          model.addAttribute("content", content);
          
          return "email/sendEmailOk22";
      }
      
      
      //3. 이미지를 내장하여 이메일 발송
      @RequestMapping(value = "sendMail23", method = RequestMethod.GET)
      public String sendMail23(MultipartHttpServletRequest multi, Model model) throws Exception{
      	
      	String root = multi.getSession().getServletContext().getRealPath("/");
      	String path = root + "resources/upload/";
      	boolean ps = false;
      	
      	File dir = new File(path);
      	
      	if(!dir.isDirectory()) {	//해당 디렉토리가 없는 경우 디렉토리 생성
      		dir.mkdir();
      	}
      	
      	Iterator<String> files = multi.getFileNames();
      	
      	String fileName_original = "";
      	String uploadFile = "";
      	MultipartFile mFile;
      	long size = 0L;
      	if(files.hasNext()) {
      		uploadFile = files.next();
      		mFile = multi.getFile(uploadFile);
      		fileName_original = mFile.getOriginalFilename();
      		try {
      			mFile.transferTo(new File(uploadPath+fileName_original));
      			size = mFile.getSize();
      			log.info("전송된 파일 이름 : "+fileName_original);
      			log.info("전송된 파일 크기 : "+mFile.getSize());
      		} catch (Exception e) {
      			e.printStackTrace();
      		}
      	}
  		String author = multi.getParameter("author");
  		String name = multi.getParameter("name");
  		String tel = multi.getParameter("tel");
          String subject = multi.getParameter("subject");
          String content = multi.getParameter("content") + "<img src='"+fileName_original+"'>";
          String from = multi.getParameter("from");
          String to = multi.getParameter("to");
          
          try {
              MimeMessage mail = mailSender3.createMimeMessage();
              MimeMessageHelper mailHelper = new MimeMessageHelper(mail,true,"UTF-8");
              mailHelper.setFrom(from);
              mailHelper.setTo(to);
              mailHelper.setSubject(subject);
              mailHelper.setText(content, true);
              mailSender3.send(mail);
              ps = true;
          } catch(Exception e) {
          	ps = false;
              e.printStackTrace();
          }
          
          model.addAttribute("ps", ps);
          model.addAttribute("from", from);
          model.addAttribute("to", to);
          model.addAttribute("name", author+"/"+name+"/"+tel);
          model.addAttribute("subject", subject);
          model.addAttribute("content", content);
          model.addAttribute("filename", fileName_original);
          model.addAttribute("size", size);
          
          return "email/sendEmailOk23";
      }

      
      //4. 파일을 첨부하여 이메일 발송
      @RequestMapping(value = "sendMail24", method = RequestMethod.GET)
      public String sendMail24(MultipartHttpServletRequest multi, Model model) throws Exception{
      	String root = multi.getSession().getServletContext().getRealPath("/");
      	String path = root + "resources/upload/";  
      	boolean ps = false;
      	
      	File dir = new File(path);
      	
      	if(!dir.isDirectory()) {	//해당 디렉토리가 없는 경우 디렉토리 생성
      		dir.mkdir();
      	}
      	
      	Iterator<String> files = multi.getFileNames();
      	String fileName_original = "";
      	String uploadFile = "";
      	MultipartFile mFile;
      	long size = 0L;
      	
      	if(files.hasNext()) {
      		uploadFile = files.next();
      		mFile = multi.getFile(uploadFile);
      		fileName_original = mFile.getOriginalFilename();
      		try {
      			mFile.transferTo(new File(uploadPath+fileName_original));
      			size = mFile.getSize();
      			log.info("전송된 파일 이름 : "+fileName_original);
      			log.info("전송된 파일 크기 : "+mFile.getSize());
      		} catch (Exception e) {
      			e.printStackTrace();
      		}
      	}
  		String author = multi.getParameter("author");
  		String name = multi.getParameter("name");
  		String tel = multi.getParameter("tel");
          String subject = multi.getParameter("subject");
          String content = multi.getParameter("content");
          String from = multi.getParameter("from");
          String to = multi.getParameter("to");
          
          try {
              MimeMessage mail = mailSender3.createMimeMessage();
              MimeMessageHelper mailHelper = new MimeMessageHelper(mail,true,"UTF-8");
              mailHelper.setFrom(from);
              mailHelper.setTo(to);
              mailHelper.setSubject(subject);
              mailHelper.setText(content, true);
              FileSystemResource file = new FileSystemResource(new File(uploadPath+fileName_original)); 
              mailHelper.addAttachment(fileName_original, file);
              mailSender3.send(mail);
              ps = true;
          } catch(Exception e) {
          	ps = false;
              e.printStackTrace();
          }
          
          model.addAttribute("ps", ps);
          model.addAttribute("from", from);
          model.addAttribute("to", to);
          model.addAttribute("name", author+"/"+name+"/"+tel);
          model.addAttribute("subject", subject);
          model.addAttribute("content", content);
          model.addAttribute("filename", fileName_original);
          model.addAttribute("size", size);
          
          return "email/sendEmailOk24";
      }
      
      
      //5. 이메일 인증번호 보내기 
      @RequestMapping("findAuth3")
      @ResponseBody
      public Map findAuth3(@ModelAttribute("vo") Custom vo, Model model) {
          
          Map map = new HashMap();
          
          //사용자가 작성한 아이디를 기준으로 존재하는 사용자인지 확인한다.(id는 회원가입시 중복 체크를 했기 때문에 유니크하다.)
          Custom isUser = customService.getCustom(vo.getId());
          
          if(isUser != null) {//회원가입이 되어있는, 존재하는 사용자라면
              Random r = new Random();
              int num = r.nextInt(999999); //랜덤 난수 
              
              StringBuilder sb = new StringBuilder();
              
              // DB에 저장된 email            입력받은 email
              if(isUser.getEmail().equals(vo.getEmail())) {//이메일 정보 또한 동일하다면 
          
                  String setFrom = "kkt090724@daum.net";//발신자 이메일
                  String tomail = isUser.getEmail();//수신자 이메일
                  String title = "비밀번호 변경 인증 이메일입니다.";
                  sb.append(String.format("안녕하세요 %s님\n", isUser.getName()));
                  sb.append(String.format("비밀번호 찾기(변경) 인증번호는 %d입니다.", num));
                  String content = sb.toString();
                  
                  try {
                      MimeMessage msg = mailSender3.createMimeMessage();
                      MimeMessageHelper msgHelper = new MimeMessageHelper(msg, true, "utf-8");
                      msgHelper.setFrom(setFrom);
                      msgHelper.setTo(tomail);
                      msgHelper.setSubject(title);
                      msgHelper.setText(content);
                      mailSender3.send(msg);                    //메일 전송                    
                  } catch (Exception e) {
                      System.out.println(e.getMessage());
                  }
                  
                  //성공적으로 메일을 보낸 경우
                  map.put("status", true);
                  map.put("num", num);
                  map.put("m_idx", isUser.getId());                
              }
          }
  		return map;
      }    
}