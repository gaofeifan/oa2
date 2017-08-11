package com.pj.service.impl.exe;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *	@author		GFF
 *	@date		2017年7月19日下午2:55:55
 *	@version	1.0.0
 *	@parameter	
 *  @since		1.8
 */
public class Log extends JFrame{
	 public static void main(String[] args) {
	        Log log = new Log();
	    }
	    private JButton btLog;
	    private JButton btJmLog;
	    private JTextField tfUser;
	    private JTextArea tfPwd;
	 
	    public Log() {
	        super("转换");
	        super.setSize(458, 512);
	        super.setVisible(true);
	        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	        super.setResizable(false);
	        centered(this);
	        btLog = new JButton("加　密");
	        btLog.setBounds(new Rectangle(73, 425, 80, 30));//参数分别是坐标x，y，宽，高
	        this.setLayout(null);//设置布局管理器为空
	        this.add(btLog);
	        
	        btLog.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println(tfUser.getText());
					tfPwd.setText("加密："+tfUser.getText());
				}
			});
	        
	        
	        btJmLog = new JButton("解　密");
	        btJmLog.setBounds(new Rectangle(160, 425, 80, 30));//参数分别是坐标x，y，宽，高
	        this.setLayout(null);//设置布局管理器为空
	        this.add(btJmLog);
	        
	        
	        btJmLog.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(tfUser.getText());
					tfPwd.setText("解密："+tfUser.getText());
					
				}
			});
	        
	        tfUser = new JTextField();
	        tfUser.setBounds(new Rectangle(73, 5, 200, 25));
	        this.add(tfUser);
	        tfPwd = new JTextArea(300,300);
//	        tfPwd.setEnabled(false);
	        tfPwd.setLineWrap(true);  
	        tfPwd.setWrapStyleWord(true);
	        tfPwd.setBounds(new Rectangle(73, 40, 200, 200));
	        this.add(tfPwd);
	 
	    }
	//布局居中方法
	    public void centered(Container container) {
	        Toolkit toolkit = Toolkit.getDefaultToolkit();
	        Dimension screenSize = toolkit.getScreenSize();
	        int w = container.getWidth();
	        int h = container.getHeight();
	        container.setBounds((screenSize.width - w) / 2,
	                (screenSize.height - h) / 2, w, h);
	    }
}
