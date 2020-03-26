package com.kh.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File originFile) { // 이 메소드가 실행되면서 원본파일이 전달됨
		
		String originName = originFile.getName(); //원본 파일명 ("aaa.jpg")
		
		//수정명 : 파일업로드한 시간(년월일시분초)+10000~99999랜덤값(5자리 랜덤값)+확장자
		
		//원본명 		---> 		수정명
		//aaa.jpg	---> 2020031112371223456.jpg
		
		
		//1) 파일 업로드된 시간(String currentTime)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		
		String currentTime = sdf.format(new Date()); //20200311123712
		
		//2) 5자리 랜덤값 (10000~99999)(int ranNum)
		int ranNum = (int)(Math.random() * 90000 + 10000);//23456
		
		//3) 확장자 (String ext)
		String ext = originName.substring(originName.lastIndexOf("."));
		
		//각각 추출한 값들 다 조합해서 수정명으로!!
		
		String fileName = currentTime + ranNum + ext; // 2020031112371223456.jpg
		
		// 전달받은 파일(originFile)을 변경된 파일명으로 파일 객체 생성해서 리턴
		
		File renameFile = new File(originFile.getParent(), fileName);
		
		
		return renameFile;
	}

}
