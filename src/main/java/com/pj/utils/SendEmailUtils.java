package com.pj.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author GFF
 * @date 2017年2月16日下午5:39:59
 * @version 1.0.0
 * @parameter
 * @since 1.8
 */
public class SendEmailUtils {
	private static final String HOST = "smtp.pj-l.com";
	public static void sendMessage(String sendEmail, String sendPassword, String recipientEmail, String title,
			String content, String[] ccEmail) throws AddressException, MessagingException  {
		// 配置信息
		Properties pro = new Properties();
		pro.put("mail.host", HOST);
		pro.put("mail.transport.protocol", "smtp");
		pro.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(pro);
			Transport ts = session.getTransport();
			ts.connect(sendEmail, sendPassword);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sendEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
			// 设置抄送人z
			if (ccEmail != null && ccEmail.length != 0) {
				InternetAddress[] addresss = new InternetAddress[ccEmail.length];
				for (int i = 0; i < ccEmail.length; i++) {
					addresss[i] = new InternetAddress(ccEmail[i]);
				}
				message.setRecipients(Message.RecipientType.CC, addresss);
			}
			message.setSubject(title);
			message.setContent(content, "text/html;charset=utf-8");
			ts.sendMessage(message, message.getAllRecipients());
	
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
					if (charAt == ' ') {
						sb.append("&nbsp");
					} else {
						sb.append(charAt);
					}
				}
				sb.append("</br>");
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
