package com.example.demo06.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo06.model.FileBoard;
import com.example.demo06.repository.FileRepository;

@Service
public class FileService {
	
	@Autowired
	private FileRepository fileRepository;
	
public void fileInsert(FileBoard fboard, String uploadFolder) {
	UUID uuid = UUID.randomUUID();//이름 랜덤 생성 UUID
	MultipartFile f= fboard.getUpload();//FileBoard에서 실질적으로 들어갈 파일이 multipart임 그래서 멀티파트형으로 받아옴
	String uploadFileName="";
	if(!f.isEmpty()) {
		uploadFileName=uuid.toString()+"_"+f.getOriginalFilename();//랜덤이름_원래이미지이름
		File saveFile=new File(uploadFolder,uploadFileName);
		try {
			f.transferTo(saveFile);////파일 업로드 됨, 예외처리하기
			fboard.setFileimage(uploadFileName);//파일이름넣기
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}
	fileRepository.save(fboard);//파일이 없어도 save가 되어야하니 if 안에 안걸리도록 위치 조심
}
public List<FileBoard> list() {
	return fileRepository.findAll();
}
///////// file2, properties에 경로 지정했기때문에 uploadFolder는 지워줌
public void fileInsert(FileBoard fboard) {
	UUID uuid = UUID.randomUUID();//이름 랜덤 생성 UUID
	MultipartFile f= fboard.getUpload();//FileBoard에서 실질적으로 들어갈 파일이 multipart임 그래서 멀티파트형으로 받아옴
	String uploadFileName="";
	if(!f.isEmpty()) {
		uploadFileName=uuid.toString()+"_"+f.getOriginalFilename();//랜덤이름_원래이미지이름
		File saveFile=new File(uploadFileName);
		try {
			f.transferTo(saveFile);////파일 업로드 됨, 예외처리하기
			fboard.setFileimage(uploadFileName);//파일이름넣기
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}
	fileRepository.save(fboard);//파일이 없어도 save가 되어야하니 if 안에 안걸리도록 위치 조심
}
}