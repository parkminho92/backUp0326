package com.kh.common.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper {

	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String key) {
		// getParamenter 재정의 : 전달받은 key값이 userPwd일 경우 암호문 리턴
		//									 그게 아닐 경우 원래값 리턴
		
		String value = "";
		
		if(key.equals("userPwd") || key.equals("newPwd")) { // key값이 userPwd일 경우 value값 암호문
			
			// 암호화된 value값
			String realPwd = super.getParameter(key); // 사용자가 입력한 평문그대로의 비밀번호
			
			try {
				// sha-512방식의 암호화 객체
				MessageDigest md = MessageDigest.getInstance("SHA-512");
				
				// 전달받은 평문그대로의 비밀번호를 바이트배열로 변환
				byte[] bytes = realPwd.getBytes(Charset.forName("UTF-8"));
				
				// md객체에 변환한 배열을 전달해서 갱신하기
				md.update(bytes);
				
				// java.util.Base64 인코더를 이용해서 암호화된 바이트 배열을 문자열로 인코딩 과정
				value = Base64.getEncoder().encodeToString(md.digest());
				
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			
			
		}else { // 그게 아닐 경우 그냥 해당 value값
			value = super.getParameter(key);
		}
		
		
		return value;
	}

}





