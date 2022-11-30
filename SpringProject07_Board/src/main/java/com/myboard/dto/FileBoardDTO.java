package com.myboard.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FileBoardDTO {
private int num;
private String title;
private String writer;
private String content;
private MultipartFile upload;
private String fileimage;
}
