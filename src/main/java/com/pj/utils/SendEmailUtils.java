package com.pj.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

/**
 * @author GFF
 * @date 2017年2月16日下午5:39:59
 * @version 1.0.0
 * @parameter
 * @since 1.8
 */
public class SendEmailUtils {
	private static final String[] HOST = new String[] {"pj-l.com","medilink.com.cn"};
	public static void sendMessage(String sendEmail, String sendPassword, String recipientEmail, String title,
		String content, String[] ccEmail) throws AddressException, MessagingException , RuntimeException{
		// 配置信息
		Properties pro = new Properties();
		pro.put("mail.host", "smtp."+HOST[0]);
		pro.put("mail.transport.protocol", "smtp");
		pro.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(pro);
		Transport ts = null;
		try {
			ts = session.getTransport();
		} catch (NoSuchProviderException e1) {
			e1.printStackTrace();
		}
		try {
			ts.connect(sendEmail, sendPassword);
		} catch (MessagingException e) {
			throw new RuntimeException("账号或密码错误");
		}
		Message message = new MimeMessage(session);
//		message.
		try {
			message.setFrom(new InternetAddress(sendEmail));
		} catch (AddressException e) {
			throw new RuntimeException("发送人邮箱有误");
		} catch (MessagingException e) {	
			throw new RuntimeException("账号或密码错误");
		}
		try {
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
		} catch (AddressException e) {
			throw new RuntimeException("收件人邮箱格式有误");
		} catch (MessagingException e) {
			throw new RuntimeException("账号或密码错误");
		}
		// 设置抄送人z
		try {
			if (ccEmail != null && ccEmail.length != 0) {
				InternetAddress[] addresss = new InternetAddress[ccEmail.length];
				for (int i = 0; i < ccEmail.length; i++) {
					addresss[i] = new InternetAddress(ccEmail[i]);
				}
				message.setRecipients(Message.RecipientType.CC, addresss);
			}
		} catch (MessagingException e) {
			throw new RuntimeException("抄送人邮箱或邮箱格式有误");
		}
		try {
			try {
				message.setSubject((MimeUtility.encodeText(title,MimeUtility.mimeCharset("gb2312"), null)));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			message.setContent(content, "text/plain;charset=utf-8");
			ts.sendMessage(message, message.getAllRecipients());
		} catch (MessagingException e) {
			throw new RuntimeException("抄送人邮箱格式不正确");
		}
	}

	public static String getResourceTemp(String path) {
		InputStream is = SendEmailUtils.class.getResourceAsStream(path);
		InputStreamReader iReader;
		try {
			iReader = new InputStreamReader(is, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(iReader);
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				for (int i = 0; i < line.length(); i++) {
					char charAt = line.charAt(i);
				/*	if (charAt == ' ') {
						sb.append("&nbsp;");
					} else {*/
						sb.append(charAt);
					//}
				}
//				sb.append("</br>");
				sb.append("\r\n");
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws AddressException, MessagingException {
		sendMessage("gaofeifan@pj-l.com", "PJ.1223456", "1315697146@qq.com", "中亚宝丰offer",
				getResourceTemp("/temp/offer2"), new String[] { "xxx", "xxxx" });
	}
}
