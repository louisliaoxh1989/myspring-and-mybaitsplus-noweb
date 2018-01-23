package com.springmybatis.noweb;
import cn.hutool.crypto.SecureUtil;

public class MySecureUtil {
	private static final String KEY="123&*(765";
	
	public static String getSecureKey() {
		return KEY;
	}
	
	/**
	 * 使用DES加密，使用UTF-8编码,返回加密后的Hex
	 * 
	 * @param data 被加密的字符串
	 * @return 加密后的Hex
	 */
	public static String encryptHexStr(String origin) {
		return SecureUtil.des(KEY.getBytes()).encryptHex(origin);
	}
	
	/**
	 * 使用DES解密Hex表示的字符串，默认UTF-8编码
	 * @param origin
	 * @return
	 */
	public static String decryptHexStr(String origin) {
		return SecureUtil.des(KEY.getBytes()).decryptStr(origin);
	}
	
}
