package com.springmybatis.test;

import java.io.UnsupportedEncodingException;

import com.springmybatis.noweb.MySecureUtil;

import cn.hutool.crypto.SecureUtil;

public class TestSecure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			String name = "22222";
			String pwd ="3434343434343";
			//String encryptStr = new String(SecureUtil.generateDESKey("DES", "2222222".getBytes()).getEncoded());
			String encryptUserStr = SecureUtil.des(MySecureUtil.getSecureKey().getBytes()).encryptHex(name);
			String encryptPWDStr = SecureUtil.des(MySecureUtil.getSecureKey().getBytes()).encryptHex(pwd);
//			String decryptStr = SecureUtil.des("goodixdb".getBytes()).decryptStr(encryptStr);
			System.out.println("加密后的数据库用户名:"+encryptUserStr);
			System.out.println("加密后的数据库用户密码:"+encryptPWDStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
