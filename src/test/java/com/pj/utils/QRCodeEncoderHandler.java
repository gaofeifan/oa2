//package com.pj.utils;
//
//
//import java.io.File;
//import java.util.HashMap;
//import java.util.Map;
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.MultiFormatWriter;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
//
//   
//
//public class QRCodeEncoderHandler {  
//
//   
//
//    /** 
//
//     * @param args 
//
//     * @throws Exception  
//
//     */ 
//
//    public static void main(String[] args){  
//
//   
//
//try {
//
//        String content = "这是测试xing二维码生成"; 
//
////        String path = "D:/tt";
//
//        String path = "f://";
//
//        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
//
//        Map hints = new HashMap();  
//
//        //内容所使用编码  
//
//        hints.put(EncodeHintType.CHARACTER_SET, "gb2312");  
//
//        BitMatrix bitMatrix = multiFormatWriter.encode(content,BarcodeFormat.QR_CODE, 200, 200, hints);  
//
//        //生成二维码  
//
//        File outputFile = new File(path,"14.jpg"); 
//
//        MatrixToImageWriter.writeToFile(bitMatrix, "jpg", outputFile);  
//
//} catch (Exception e) {
//
//    e.printStackTrace();
//
//}
//
//    }  
//
//   
//
//}