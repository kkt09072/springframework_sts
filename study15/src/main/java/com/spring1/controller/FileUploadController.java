package com.spring1.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.spring1.dto.Product;
import com.spring1.vo.UploadData;

@Controller
@RequestMapping("/fileupload/")
public class FileUploadController {
	
	private static final Logger log = LoggerFactory.getLogger(FileUploadController.class); 
	
	@GetMapping("main")
	public String home(Model model) {
		return "fileupload/home";
	}
	
	//업로드로 가는 메소드
	@GetMapping("upload")
	public String uploadForm(Model model) {
		return "fileupload/fileUpload";
	}
	
	@PostMapping("uploadPro")
	public String upload(@RequestParam("file") MultipartFile file, Model model) {
		String fileRealName = file.getOriginalFilename(); //파일명을 얻어낼 수 있는 메서드!
		long size = file.getSize(); //파일 사이즈
		
		log.info("파일명 : {}", fileRealName);
		log.info("용량크기(byte) : {}", size);
		
		model.addAttribute("fileRealName", "파일명 : " + fileRealName);
		model.addAttribute("size", "용량크기(byte) : "+size);
		
		//서버에 저장할 파일이름 fileextension으로 .jsp이런식의  확장자 명을 구함
		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
		String uploadFolder = "D:\\test\\upload";
		
		
		/*
		  파일 업로드시 파일명이 동일한 파일이 이미 존재할 수도 있고 사용자가 
		  업로드 하는 파일명이 언어 이외의 언어로 되어있을 수 있습니다. 
		  타인어를 지원하지 않는 환경에서는 정산 동작이 되지 않습니다.(리눅스가 대표적인 예시)
		  고유한 랜던 문자를 통해 db와 서버에 저장할 파일명을 새롭게 만들어 준다.
		 */
		
		UUID uuid = UUID.randomUUID();
		log.info("UUID : {}", uuid.toString());
		String[] uuids = uuid.toString().split("-");
		
		String uniqueName = uuids[0];
		
		log.info("생성된 고유문자열 : {}", uniqueName);
		log.info("확장자명 : {}", fileExtension);
		
		model.addAttribute("uuid", "uuid : "+uuid.toString());
		
		String uuidName = uploadFolder+"\\"+uniqueName + fileExtension;
		
		model.addAttribute("uuidName", "uuidName : "+uuidName);
		
		// File saveFile = new File(uploadFolder+"\\"+fileRealName); uuid 적용 전
		
		File saveFile = new File(uuidName);  // 적용 후
		try {
			file.transferTo(saveFile); // 실제 파일 저장메서드(filewriter 작업을 손쉽게 한방에 처리해준다.)
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "fileupload/fileUploadOk";
	}
	
	@GetMapping("upload2")
	public String uploadForm2(Model model) {
		return "fileupload/fileUpload2";
	}
	
    @PostMapping("uploadPro2")
    public String upload2(MultipartHttpServletRequest files, Model model) {
        String uploadFolder = "D:\\test\\upload";
        List<MultipartFile> list = files.getFiles("files");
        
        List<UploadData> datas = new ArrayList<>();
        
        for (MultipartFile file : list) {
            String fileRealName = file.getOriginalFilename();
            long size = file.getSize();
            
            log.info("파일명: {}", fileRealName);
            log.info("파일 크기(byte): {}", size);
            
            datas.add(new UploadData(fileRealName, size));
            
            File saveFile = new File(uploadFolder + "\\" + fileRealName);
            try {
                file.transferTo(saveFile);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }
        
        model.addAttribute("datas", datas);
        return "fileupload/fileUploadOk2";
    }
    
    @GetMapping("upload3")
    public String uploadForm3(Model model) {
        return "fileupload/fileUpload3"; // HTML 폼이 있는 JSP 파일의 이름
    }
    
    @PostMapping("uploadPro3")
    public String upload3(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("file") MultipartFile file,
            Model model) {
        
        String fileRealName = file.getOriginalFilename();
        long size = file.getSize();
        
        log.info("제목: {}", title);
        log.info("내용: {}", content);
        log.info("파일명: {}", fileRealName);
        log.info("파일 크기(byte): {}", size);
        
        // 서버에 저장할 파일 이름 생성
        String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."));
        String uploadFolder = "D:\\test\\upload";
        
        UUID uuid = UUID.randomUUID();
        String uniqueName = uuid.toString().split("-")[0];
        String uuidName = uploadFolder + "\\" + uniqueName + fileExtension;
        
        // 파일 저장
        File saveFile = new File(uuidName);
        try {
            file.transferTo(saveFile);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        
        // 데이터 모델에 추가
        model.addAttribute("title", title);
        model.addAttribute("content", content);
        model.addAttribute("fileRealName", fileRealName);
        model.addAttribute("size", size);
        model.addAttribute("uuidName", uuidName);
        
        return "fileupload/fileUploadOk3"; // 업로드 성공 페이지
    }
    
    @GetMapping("upload4")
    public String uploadForm4(Model model) {
        return "fileupload/fileUpload4"; // HTML 폼이 있는 JSP 파일의 이름
    }
    
    @PostMapping("uploadPro4")
    public String uploadProduct(
            @RequestParam("productName") String productName,
            @RequestParam("description") String description,
            @RequestParam("price") double price,
            MultipartHttpServletRequest files,
            Model model) {

        String uploadFolder = "D:\\test\\upload";
        List<MultipartFile> fileList = files.getFiles("files");
        List<UploadData> uploadDatas = new ArrayList<>();

        for (MultipartFile file : fileList) {
            String fileRealName = file.getOriginalFilename();
            long size = file.getSize();

            log.info("파일명: {}", fileRealName);
            log.info("파일 크기(byte): {}", size);

            String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."));
            UUID uuid = UUID.randomUUID();
            String uniqueName = uuid.toString().split("-")[0];
            String uuidName = uploadFolder + "\\" + uniqueName + fileExtension;

            uploadDatas.add(new UploadData(fileRealName, size));

            File saveFile = new File(uuidName);
            try {
                file.transferTo(saveFile);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }

        Product product = new Product(productName, description, price, uploadDatas);
        model.addAttribute("product", product);

        return "fileupload/fileUploadOk4"; // 업로드 성공 페이지
    }
    
    /* 여기까지는 로컬에 업로드하는 경우임 */
    
    
    /* 여기부터는 서버에 업로드하는 경우임 */
    
    @Autowired
    private ServletContext servletContext;
    
	@GetMapping("upload5")
	public String uploadForm5(Model model) {
		return "fileupload/fileUpload5";
	}
	
	@PostMapping("uploadPro5")
	public String upload5(@RequestParam("file") MultipartFile file, Model model) {
		String fileRealName = file.getOriginalFilename(); //파일명을 얻어낼 수 있는 메서드!
		long size = file.getSize(); //파일 사이즈
		String uploadFolder = servletContext.getRealPath("/resources/upload");
		
		log.info("파일명 : {}", fileRealName);
		log.info("용량크기(byte) : {}", size);
		
		model.addAttribute("fileRealName", "파일명 : " + fileRealName);
		model.addAttribute("size", "용량크기(byte) : "+size);
		
		//서버에 저장할 파일이름 fileextension으로 .jsp이런식의  확장자 명을 구함
		String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
		
		/*
		  파일 업로드시 파일명이 동일한 파일이 이미 존재할 수도 있고 사용자가 
		  업로드 하는 파일명이 언어 이외의 언어로 되어있을 수 있습니다. 
		  타인어를 지원하지 않는 환경에서는 정산 동작이 되지 않습니다.(리눅스가 대표적인 예시)
		  고유한 랜던 문자를 통해 db와 서버에 저장할 파일명을 새롭게 만들어 준다.
		 */
		
		UUID uuid = UUID.randomUUID();
		log.info("UUID : {}", uuid.toString());
		String[] uuids = uuid.toString().split("-");
		
		String uniqueName = uuids[0];
		
		log.info("생성된 고유문자열 : {}", uniqueName);
		log.info("확장자명 : {}", fileExtension);
		
		model.addAttribute("uuid", "uuid : "+uuid.toString());
		
		String uuidName = uploadFolder+"\\"+uniqueName + fileExtension;
		
		model.addAttribute("uuidName", "uuidName : "+uuidName);
		
		// File saveFile = new File(uploadFolder+"\\"+fileRealName); uuid 적용 전
		
		File saveFile = new File(uuidName);  // 적용 후
		try {
			file.transferTo(saveFile); // 실제 파일 저장메서드(filewriter 작업을 손쉽게 한방에 처리해준다.)
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        /* 서비스 호출 영역 시작 */
        
        
        /* 서비스 호출 영역 끝 */
		
		return "fileupload/fileUploadOk5";
	}
	
	@GetMapping("upload6")
	public String uploadForm6(Model model) {
		return "fileupload/fileUpload6";
	}
	
    @PostMapping("uploadPro6")
    public String upload6(MultipartHttpServletRequest files, Model model) {
        String uploadFolder = servletContext.getRealPath("/resources/upload");
        List<MultipartFile> list = files.getFiles("files");
        
        List<UploadData> datas = new ArrayList<>();
        
        for (MultipartFile file : list) {
            String fileRealName = file.getOriginalFilename();
            long size = file.getSize();
            
            log.info("파일명: {}", fileRealName);
            log.info("파일 크기(byte): {}", size);
            
            datas.add(new UploadData(fileRealName, size));
            
            File saveFile = new File(uploadFolder + "\\" + fileRealName);
            try {
                file.transferTo(saveFile);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }
        
        /* 서비스 호출 영역 시작 */
        
        
        /* 서비스 호출 영역 끝 */
        
        model.addAttribute("datas", datas);
        return "fileupload/fileUploadOk6";
    }
    
    @GetMapping("upload7")
    public String uploadForm7(Model model) {
        return "fileupload/fileUpload7"; // HTML 폼이 있는 JSP 파일의 이름
    }
    
    @PostMapping("uploadPro7")
    public String upload7(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("file") MultipartFile file,
            Model model) {
        
        String fileRealName = file.getOriginalFilename();
        long size = file.getSize();
        
        log.info("제목: {}", title);
        log.info("내용: {}", content);
        log.info("파일명: {}", fileRealName);
        log.info("파일 크기(byte): {}", size);
        
        // 서버에 저장할 파일 이름 생성
        String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."));
        String uploadFolder = servletContext.getRealPath("/resources/upload");
        
        UUID uuid = UUID.randomUUID();
        String uniqueName = uuid.toString().split("-")[0];
        String uuidName = uploadFolder + "\\" + uniqueName + fileExtension;
        
        // 파일 저장
        File saveFile = new File(uuidName);
        try {
            file.transferTo(saveFile);
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
        
        // 데이터 모델에 추가
        model.addAttribute("title", title);
        model.addAttribute("content", content);
        model.addAttribute("fileRealName", fileRealName);
        model.addAttribute("size", size);
        model.addAttribute("uuidName", uuidName);
        
        /* 서비스 호출 영역 시작 */
        
        
        /* 서비스 호출 영역 끝 */
        
        return "fileupload/fileUploadOk7"; // 업로드 성공 페이지
    }
    
    @GetMapping("upload8")
    public String uploadForm8(Model model) {
        return "fileupload/fileUpload8"; // HTML 폼이 있는 JSP 파일의 이름
    }
    
    @PostMapping("uploadPro8")
    public String upload8(
            @RequestParam("productName") String productName,
            @RequestParam("description") String description,
            @RequestParam("price") double price,
            MultipartHttpServletRequest files,
            Model model) {

        String uploadFolder = servletContext.getRealPath("/resources/upload");
        List<MultipartFile> fileList = files.getFiles("files");
        List<UploadData> uploadDatas = new ArrayList<>();

        for (MultipartFile file : fileList) {
            String fileRealName = file.getOriginalFilename();
            long size = file.getSize();

            log.info("파일명: {}", fileRealName);
            log.info("파일 크기(byte): {}", size);

            String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."));
            UUID uuid = UUID.randomUUID();
            String uniqueName = uuid.toString().split("-")[0];
            String uuidName = uploadFolder + "\\" + uniqueName + fileExtension;

            uploadDatas.add(new UploadData(fileRealName, size));

            File saveFile = new File(uuidName);
            try {
                file.transferTo(saveFile);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }

        Product product = new Product(productName, description, price, uploadDatas);
        model.addAttribute("product", product);
        
        /* 서비스 호출 영역 시작 */
        
        
        /* 서비스 호출 영역 끝 */
        return "fileupload/fileUploadOk8"; // 업로드 성공 페이지
    }
    
    
    //상품 정보 변경
    @GetMapping("update")
    public String updateForm9(@RequestParam("id") Long id, Model model) {
        // DB나 다른 저장소에서 기존 상품 정보를 불러옵니다.
        // 여기서는 예시로 더미 데이터를 사용합니다.
        List<UploadData> existingImages = List.of(
                new UploadData("image1.jpg", 12345L, "uuid1.jpg"),
                new UploadData("image2.jpg", 67890L, "uuid2.jpg")
        );
        Product product = new Product("Existing Product", "This is an existing product.", 999, existingImages);
        model.addAttribute("product", product);
        return "fileupload/fileUploadUpdate"; // 업데이트 폼이 있는 JSP 파일의 이름
    }
    
    //상품 정보 변경
    @PostMapping("updatePro")
    public String updateProduct(
            @RequestParam("productId") Long productId,
            @RequestParam("productName") String productName,
            @RequestParam("description") String description,
            @RequestParam("price") double price,
            @RequestParam(value = "deleteFiles", required = false) String[] deleteFiles,
            MultipartHttpServletRequest files,
            Model model) {

        String uploadFolder = servletContext.getRealPath("/resources/upload");
        
        // 삭제할 파일 처리
        if (deleteFiles != null) {
            for (String fileName : deleteFiles) {
                File file = new File(uploadFolder + File.separator + fileName);
                if (file.exists()) {
                    file.delete();
                }
            }
        }

        // 새로 업로드할 파일 처리
        List<MultipartFile> fileList = files.getFiles("files");
        List<UploadData> uploadDatas = new ArrayList<>();

        for (MultipartFile file : fileList) {
            String fileRealName = file.getOriginalFilename();
            long size = file.getSize();

            log.info("파일명: {}", fileRealName);
            log.info("파일 크기(byte): {}", size);

            String fileExtension = file.getOriginalFilename().substring(fileRealName.lastIndexOf("."));
            UUID uuid = UUID.randomUUID();
            String uniqueName = uuid.toString().split("-")[0];
            String uuidName = uniqueName + fileExtension;

            uploadDatas.add(new UploadData(fileRealName, size, uuidName));

            File saveFile = new File(uploadFolder + File.separator + uuidName);
            try {
                file.transferTo(saveFile);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }

        Product product = new Product(productName, description, price, uploadDatas);
        model.addAttribute("product", product);

        /* 서비스 호출 영역 시작 */
        
        
        /* 서비스 호출 영역 끝 */
        
        return "fileupload/updateSuccess"; // 업데이트 성공 페이지
    }
    
    @GetMapping("delete")
    public String delete(Model model) {
    	//아래는 더미 이미지입니다. 실제는 서비스 클래스의 메소드를 호출하여 데이터를 불러와야 합니다.
    	List<UploadData> existingImages = List.of(
                new UploadData("image1.jpg", 12345L, "uuid1.jpg"),
                new UploadData("image2.jpg", 67890L, "uuid2.jpg")
        );
        Product product = new Product("Existing Product", "This is an existing product.", 999, existingImages);
        model.addAttribute("product", product);
    	return "fileupload/deleteFile";
    }
    
    
    @GetMapping("deleteFile")
    public String deleteFile(@RequestParam("fileName") String fileName) {
        String uploadFolder = servletContext.getRealPath("/resources/upload");
        File file = new File(uploadFolder + File.separator + fileName);
        if (file.exists()) {
            file.delete(); // 파일 삭제
        }
        
        /* 서비스 호출 영역 시작 */
        
        
        /* 서비스 호출 영역 끝 */
        
        return "redirect:/"; // 삭제 후 다시 메인으로 이동
    }
    
    
}
