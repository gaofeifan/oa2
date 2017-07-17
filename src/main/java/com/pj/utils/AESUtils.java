package com.pj.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AESUtils {

	public static final String ENCRYPTHEX = "encryptHex";	//	加密
	public static final String DECRYPTHEX = "decryptHex";	//	解密
	public static final String ALGORITHM = "AES";
	private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
	private static final String CHARSET = "utf-8";

	private static final Log _log = LogFactory.getLog(AESUtils.class);

	/**
	 * 获取key 填充密匙 获取加密的密匙数据
	 * 
	 * @paramString key
	 * @return byte[] enCodeFormat;
	 * @author panjianghong 2016-8-29
	 */
	private static byte[] getEnCodeFormat(String key) {

		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );
	        secureRandom.setSeed(key.getBytes());
			kgen.init(128, secureRandom);
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			return enCodeFormat;
		} catch (NoSuchAlgorithmException e) {
			_log.error("获取密匙数据失败！");
		}
		return null;
	}

	/**
	 * 获取加密数据的二进制字符串数据
	 * 
	 * @param content
	 * @param enCodeFormat
	 * @return String
	 * @author panjianghong 2016-8-29
	 */
	public static String encryptBin(String content, String key) {

		try {
			byte[] byteConten = encrypt(content, key);
			return byte2BinString(byteConten);
		} catch (Exception e) {
			_log.error("获取二进制加密数据失败！");
		}
		return null;
	}

	/**
	 * 获取加密数据的十六进制字符串数据
	 * 
	 * @param content
	 * @param enCodeFormat
	 * @return String
	 * @author panjianghong 2016-8-29
	 */
	public static String encryptHex(String content, String key) {
		try {
			byte[] byteConten = encrypt(content, key);
			return byte2HexString(byteConten);
		} catch (Exception e) {
			_log.error("获取十六进制加密数据失败！");
		}
		return null;
	}

	/**
	 * 获取文件的加密数据 返回加密数据的字节数组 byte[]
	 * 
	 * @param content
	 * @param enCodeFormat
	 * @return byte[] byteResoult
	 * @author panjianghong 2016-8-29
	 */
	private static byte[] encrypt(String content, String key) {

		try {
			SecretKeySpec secretyKey = new SecretKeySpec(getEnCodeFormat(key), ALGORITHM);
			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			byte[] byteContent = content.getBytes(CHARSET);
			cipher.init(Cipher.ENCRYPT_MODE, secretyKey);
			byte[] byteResoult = cipher.doFinal(byteContent);
			return byteResoult;
		} catch (InvalidKeyException e) {
			_log.error("获取加密数据的字节数组失败！");
		} catch (NoSuchAlgorithmException e) {
			_log.error("获取加密数据的字节数组失败！");
		} catch (NoSuchPaddingException e) {
			_log.error("获取加密数据的字节数组失败！");
		} catch (UnsupportedEncodingException e) {
			_log.error("获取加密数据的字节数组失败！");
		} catch (IllegalBlockSizeException e) {
			_log.error("获取加密数据的字节数组失败！");
		} catch (BadPaddingException e) {
			_log.error("获取加密数据的字节数组失败！");
		}
		return null;
	}

	/**
	 * 以二进制字符串数据进行解密
	 * 
	 * @param content
	 * @param enCodeFormat
	 * @return String
	 * @author panjianghong 2016-8-29
	 */

	public static String decryptBin(String binContent, String key) {

		try {
			SecretKeySpec secretyKey = new SecretKeySpec(getEnCodeFormat(key), ALGORITHM);
			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			cipher.init(Cipher.DECRYPT_MODE, secretyKey);
			byte[] byteResoult = cipher.doFinal(binString2Byte(binContent));
			try {
				return new String(byteResoult, "utf-8");
			} catch (UnsupportedEncodingException e) {
				_log.error("解密二进制数据失败！");
				return null;
			}
		} catch (InvalidKeyException e) {
			_log.error("解密二进制数据失败！");
		} catch (NoSuchAlgorithmException e) {
			_log.error("解密二进制数据失败！");
		} catch (NoSuchPaddingException e) {
			_log.error("解密二进制数据失败！");
		} catch (IllegalBlockSizeException e) {
			_log.error("解密二进制数据失败！");
		} catch (BadPaddingException e) {
			_log.error("解密二进制数据失败！");
		}

		return null;
	}

	/**
	 * 以十六进制字符串数据进行解密
	 * 
	 * @param content
	 * @param enCodeFormat
	 * @return String
	 * @author panjianghong 2016-8-29
	 */
	public static String decryptHex(String binContent, String key) {

		try {
			SecretKeySpec secretyKey = new SecretKeySpec(getEnCodeFormat(key), ALGORITHM);
			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			cipher.init(Cipher.DECRYPT_MODE, secretyKey);
			byte[] byteResoult = cipher.doFinal(hexString2Byte(binContent));
			try {
				return new String(byteResoult, "utf-8");
			} catch (UnsupportedEncodingException e) {
				_log.error("解密十六进制数据失败！");
				return null;
			}
		} catch (InvalidKeyException e) {
			_log.error("解密十六进制数据失败！");
		} catch (NoSuchAlgorithmException e) {
			_log.error("解密十六进制数据失败！");
		} catch (NoSuchPaddingException e) {
			_log.error("解密十六进制数据失败！");
		} catch (IllegalBlockSizeException e) {
			_log.error("解密十六进制数据失败！");
		} catch (BadPaddingException e) {
			_log.error("解密十六进制数据失败！");
		}

		return null;
	}

	/**
	 * 字节数组转化成二进制数
	 * 
	 * @param content
	 * @return string
	 * @author panjianghong 2016-8-29
	 */
	private static String byte2BinString(byte[] content) {
		if (null == content) {
			_log.error("需要转换的参数为空！");
			return null;
		}

		return hexString2BinString(byte2HexString(content));
	}

	/**
	 * 字节数组转化成十六进制数的小写形式
	 * 
	 * @param content
	 * @return string
	 * @author panjianghong 2016-8-29
	 */
	private static String byte2HexString(byte[] content) {
		if (null == content) {
			_log.error("需要转换的参数为空！");
			return null;
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < content.length; i++) {
			String hex = Integer.toHexString(content[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toLowerCase());
		}

		return sb.toString();
	}

	/**
	 * 十六进制数转化成二进制数
	 * 
	 * @param content
	 * @return string
	 * @author panjianghong 2016-8-29
	 */
	private static String hexString2BinString(String content) {

		if (null == content || content.length() % 2 != 0) {
			_log.error("需要转换的参数为空或者参数长度不是2的倍数！");
			return null;
		}

		StringBuffer bString = new StringBuffer();
		StringBuffer tmp = new StringBuffer();
		for (int i = 0; i < content.length(); i++) {
			tmp.append("0000").append(Integer.toBinaryString(Integer.parseInt(content.substring(i, i + 1), 16)));
			bString.append(tmp.toString().substring(tmp.toString().length() - 4));
			tmp.delete(0, tmp.toString().length());
		}
		return bString.toString();
	}

	/**
	 * 二进制数转化成十六进制数
	 * 
	 * @param content
	 * @return string
	 * @author panjianghong 2016-8-29
	 */
	private static String BinString2hexString(String content) {

		if (null == content || content.equals("") || content.length() % 8 != 0) {
			_log.error("需要转换的参数为空或者参数长度不是8的倍数！");
			return null;
		}

		StringBuffer tmp = new StringBuffer();
		int iTmp = 0;
		for (int i = 0; i < content.length(); i += 4) {
			iTmp = 0;
			for (int j = 0; j < 4; j++) {
				iTmp += Integer.parseInt(content.substring(i + j, i + j + 1)) << (4 - j - 1);
			}
			tmp.append(Integer.toHexString(iTmp));
		}
		return tmp.toString();
	}

	/**
	 * 16进制数转化成字节数组
	 * 
	 * @param content
	 * @return string
	 * @author panjianghong 2016-8-29
	 */
	private static byte[] hexString2Byte(String content) {
		if (content.length() < 1) {
			_log.error("需要转换的参数为空或者参数长度<1！");
			return null;
		}

		byte[] byteRresult = new byte[content.length() / 2];
		for (int i = 0; i < content.length() / 2; i++) {
			int high = Integer.parseInt(content.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(content.substring(i * 2 + 1, i * 2 + 2), 16);
			byteRresult[i] = (byte) (high * 16 + low);
		}
		return byteRresult;
	}

	/**
	 * 二进制数转化成字节数组
	 * 
	 * @param content
	 * @return string
	 * @author panjianghong 2016-8-29
	 */
	private static byte[] binString2Byte(String content) {
		if (content.length() < 1) {
			_log.error("需要转换的参数为空或者参数长度<1！");
			return null;
		}

		return hexString2Byte(BinString2hexString(content));
	}
	
	/**
	 *  AES 加解密
	 *	@author 	GFF
	 *	@date		2017年3月9日上午11:07:57	
	 * 	@param obj	对象
	 * 	@param key	加密或解密
	 * 	@return
	 */
	public static Object aesEncryptionOrDecryption(Object obj, String key) {
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				boolean present = field.isAnnotationPresent(com.pj.utils.annotation.AES.class);
				if (present) {
					Object object = field.get(obj);
					if (object != null) {
						if (ENCRYPTHEX.equals(key)) {
							field.set(obj, encryptHex(object.toString(), ALGORITHM));
						} else {
							if(!isNum(object.toString())){
								field.set(obj, decryptHex(object.toString(), ALGORITHM));
							}
						}
					}
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public static Boolean isNum(String str){
		 Pattern pattern = Pattern.compile("^-?[0-9]+");
	     if(pattern.matcher(str).matches()){
	         return true;
	     } else {
	         return false;
	     }
	}
	
	public static void main(String[] args) {
		String hex = decryptHex("cb882a39dab8bee8f05cc33184b66a1b", ALGORITHM);
		System.out.println(hex);
	}
}
