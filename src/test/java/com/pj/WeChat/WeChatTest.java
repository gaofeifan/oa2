//package com.pj.WeChat;
//
//import java.awt.Color;
//import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.imageio.ImageIO;
//import javax.swing.plaf.synth.SynthSpinnerUI;
//
//import com.pj.pojo.weixin.AccessToken;
//import com.pj.utils.QRCodeUtil2;
//import com.pj.utils.WeiXinUtils;
//import com.swetake.util.Qrcode;
//
//import net.sf.json.JSONObject;
//
//public class WeChatTest {
//
//    public static void main(String args[]) {
//	    	AccessToken token = WeiXinUtils.getAccessToken();
////	    	System.out.println(token.getAccess_token());
//    		    	Map<String, Object> map = new HashMap<>();
//			map.put("expire_seconds", 60*60);
//			map.put("action_name", "QR_SCENE");
//			map.put("action_info", new HashMap<>().put("scene", new HashMap<>().put("scene_id", 123)));
//			JSONObject fromObject = JSONObject.fromObject(map);
//	    	QRCode qrCode = WeiXinUtils.getQRCodeToken(fromObject.toString(),token.getAccess_token());
//	    	System.out.println(qrCode.getTicket());
//	    	System.out.println(qrCode.getUrl());
//	    	WeiXinUtils.getQRCode_Pic(qrCode.getTicket());
//    	
////	    	System.out.println(qrCode.getTicket());
////	    	System.out.println(qrCode.getUrl());
////	    	System.out.println(qrCode.getExpire_seconds());
//    	
////	    	System.out.println(token.getAccess_token());
////	    	System.out.println(token.getExpires_in());
////	    	WeChatTest chatTest = new WeChatTest();
////	    	try {
////				chatTest.creatTxm("123");
////			} catch (Exception e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////    	
////    	try {
////    		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx17f788165832cdc9&redirect_uri=http%3A%2F%2Fpjhighurl3.tunnel.qydev.com%2Foa%2FweiXin%2Fauthorization&response_type=code&scope=snsapi_userinfo&state=state#wechat_redirect";
////    		
////			QRCodeUtil2.encode(url, "f://", false);
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//    }
//	        
//    public void creatTxm(String param) throws Exception {
//        Qrcode qrcode = new Qrcode();
//        qrcode.setQrcodeErrorCorrect('M');
//        qrcode.setQrcodeEncodeMode('B');
//        qrcode.setQrcodeVersion(7);
//
//        byte[] bstr = param.getBytes("UTF-8");//返回用指定名字命名的字节数组值
//        BufferedImage bi = new BufferedImage(139, 139,
//                BufferedImage.TYPE_INT_RGB);//实例化指定参数的BufferedImage
//        Graphics2D g = bi.createGraphics();//返回一个呈现指定 BufferedImage 的 Graphics2D 对象
//        g.setBackground(Color.WHITE); // 设置该Graphics2D 对象的背景颜色
//        g.clearRect(0, 0, 139, 139); //擦除指定的矩形，并且用一个透明的颜色填充它
//        g.setColor(Color.BLACK); // 条码颜色
//        if (bstr.length > 0 && bstr.length < 123) {
//            boolean[][] b = qrcode.calQrcode(bstr); //通过calQrcode函数将byte数组转换成boolean数组 ,然后依据编码后的boolean数组绘图 
//            for (int i = 0; i < b.length; i++) {
//                for (int j = 0; j < b.length; j++) {
//                    if (b[j][i]) {
//                        g.fillRect(j * 3 + 2, i * 3 + 2, 3, 3); //填充指定的矩形
//                    }
//                    
//                }
//
//            }
//        }
//        g.dispose(); //处理图形上下文，并释放系统资源
//        bi.flush();//将生成的BufferedImage序列化到磁盘
//        String FilePath = "F:/" + param + ".jpg";//生成的二维码要存放的文件路径
//        File f = new File(FilePath);
//        ImageIO.write(bi, "jpg", f);//将生成的二维码以图片的形式写入相应的文件
//    }
//
//	   
//}
