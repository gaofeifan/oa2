package com.pj.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

public class FtpUtils {
	private static Logger logger = Logger.getLogger(FtpUtils.class);

	/**
	 * 
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param path
	 *            FTP服务器保存目录
	 * @param filename
	 *            上传到FTP服务器上的文件名
	 * @param input
	 *            输入流
	 * @return 成功返回true，否则返回false
	 */
	public static String uploadFile(String url, int port, String username, String password, String path,
			String filename, InputStream input) throws Exception {
		boolean success = false;
		try {
			FTPClient ftp = new FTPClient();
			ftp.setControlEncoding("UTF-8");
			ftp.connect(url, port);// 连接FTP服务器
			int reply;
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(username, password);// 登录
			// 设置PassiveMode传输
			ftp.enterLocalPassiveMode();
			// 设置以二进制流的方式传输
			ftp.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			reply = ftp.getReplyCode();

			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				logger.error("----------->>>连接ftp服务器失败");
				throw new Exception("----------->>>连接ftp服务器失败");
			}
			logger.info("-----连接ftp服务器成功");
			boolean isChangeWork = ftp.changeWorkingDirectory(path);
			if (!isChangeWork) {
				boolean isMade = ftp.makeDirectory(path);
				if (!isMade) {
					throw new IOException("ftp 上传文件穿件目录失败");
				}
				isChangeWork = ftp.changeWorkingDirectory(path);
			}
			ftp.storeFile(filename, input);
			ftp.logout();
			success = true;
			logger.info("----------->>>文件上传成功");
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
					logger.error("----------->>>ftp连接关闭失败 " + ioe.getMessage());
				}
			}
			if (success) {
				return /*
						 * "http://10.0.0.18:8084/tupian/"
						 * +MyApplyUtils.PARTITION+
						 */ path + "-------" + filename;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
			}
		}
		return null;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param path
	 *            FTP服务器保存目录
	 * @param filename
	 *            FTP服务器下载上的文件名
	 * @param input
	 *            输入流
	 * @return 成功返回true，否则返回false
	 */
	public static void downloadFile(String downloadName, BufferedOutputStream bos, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		String path = null;
		String fileName = null;
		BufferedInputStream bytesRead = null;
		try {
			String[] strings = downloadName.split("-------");
			path = strings[0];
			fileName = strings[1];
			String url = "139.129.236.180";
			String username = "ftp";
			String password = "pj!@#123oa";
			int port = 2221;
			@SuppressWarnings("unused")
			boolean success = false;
			FTPClient ftp = new FTPClient();
			ftp.setControlEncoding("UTF-8");
			ftp.connect(url, port);// 连接FTP服务器
			int reply;
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(username, password);// 登录
			// 设置PassiveMode传输
			ftp.enterLocalPassiveMode();
			// 设置以二进制流的方式传输
			ftp.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				logger.error("----------->>>连接ftp服务器失败");
				// throw new Exception("----------->>>连接ftp服务器失败");
			}
			logger.info("-----连接ftp服务器成功");
			boolean isChangeWork = ftp.changeWorkingDirectory(path);
			if (!isChangeWork) {
				throw new IOException("ftp 目录不存在");
			}
			bytesRead = new BufferedInputStream(ftp.retrieveFileStream(fileName));
			int buf;
			byte[] buff = new byte[2048];
			while (-1 != (buf = bytesRead.read(buff, 0, buff.length))) {
				bos.write(buff, 0, buf);
			}
			bos.flush();
			ftp.logout();
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
					logger.error("----------->>>ftp连接关闭失败 " + ioe.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				bos.close();
			}
			if (bytesRead != null) {
				bytesRead.close();
			}
		}
		// fileName = StringUtils.toUtf8String(request, fileName, response);
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		response.setContentType("application/x-msdownload;");
		response.setHeader("Content-disposition",
				"attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
		response.setHeader("Content-Length", String.valueOf(path));
		logger.info("----------->>>文件下载成功");
	}

	public static boolean downloadFile(String url, int port, String username, String password, String path,
			String filename, OutputStream out) throws Exception {
		boolean success = false;
		InputStream input = null;
		try {
			FTPClient ftp = new FTPClient();
			ftp.setControlEncoding("UTF-8");
			ftp.connect(url, port);// 连接FTP服务器
			int reply;
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(username, password);// 登录
			// 设置PassiveMode传输
			ftp.enterLocalPassiveMode();
			// 设置以二进制流的方式传输
			ftp.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				logger.error("----------->>>连接ftp服务器失败");
				// throw new Exception("----------->>>连接ftp服务器失败");
			}
			logger.info("-----连接ftp服务器成功");
			boolean isChangeWork = ftp.changeWorkingDirectory(path);
			if (!isChangeWork) {
				throw new IOException("ftp 目录不存在");
			}
			input = ftp.retrieveFileStream(filename);
			int buf = -1;
			while ((buf = input.read()) != -1) {
				out.write(buf);
			}
			out.flush();
			ftp.logout();
			logger.info("----------->>>文件下载成功");
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
					logger.error("----------->>>ftp连接关闭失败 " + ioe.getMessage());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				input.close();
			}

			if (out != null) {
				out.close();
			}

		}
		return success;
	}

}
