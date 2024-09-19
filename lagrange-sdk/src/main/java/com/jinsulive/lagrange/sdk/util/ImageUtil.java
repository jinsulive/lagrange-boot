package com.jinsulive.lagrange.sdk.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

/**
 * @author lxy
 * @since 2024年08月31日 11:02:29
 */
public class ImageUtil {

    private static final Logger log = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * 图片转Base64字符串
     *
     * @param imageFileName 图片地址
     * @return 图片base64字符串
     */
    public static String imageToBase64(String imageFileName) {
        ByteArrayOutputStream baos = null;
        try {
            //获取图片类型
            String suffix = imageFileName.substring(imageFileName.lastIndexOf(".") + 1);
            //构建文件
            File imageFile = new File(imageFileName);
            //通过ImageIO把文件读取成BufferedImage对象
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            //构建字节数组输出流
            baos = new ByteArrayOutputStream();
            //写入流
            ImageIO.write(bufferedImage, suffix, baos);
            //通过字节数组流获取字节数组
            byte[] bytes = baos.toByteArray();
            //获取JDK8里的编码器Base64.Encoder转为base64字符
            return Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            log.error("图片转Base64字符串失败 imageFileName: {}, e: {}", imageFileName, e.getMessage(), e);
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException ignore) {
            }
        }
        return null;
    }

    /**
     * Base64字符串转图片
     *
     * @param base64String  图片base64字符串
     * @param imageFileName 图片地址
     */
    public static void base64ToImage(String base64String, String imageFileName) {
        ByteArrayInputStream bais = null;
        try {
            //获取图片类型
            String suffix = imageFileName.substring(imageFileName.lastIndexOf(".") + 1);
            //获取JDK8里的解码器Base64.Decoder,将base64字符串转为字节数组
            byte[] bytes = Base64.getDecoder().decode(base64String);
            //构建字节数组输入流
            bais = new ByteArrayInputStream(bytes);
            //通过ImageIO把字节数组输入流转为BufferedImage
            BufferedImage bufferedImage = ImageIO.read(bais);
            //构建文件
            File imageFile = new File(imageFileName);
            //写入生成文件
            ImageIO.write(bufferedImage, suffix, imageFile);
        } catch (Exception e) {
            log.error("Base64字符串转图片失败 base64String: {}, imageFileName: {}, e: {}", base64String, imageFileName, e.getMessage(), e);
        } finally {
            try {
                if (bais != null) {
                    bais.close();
                }
            } catch (IOException ignore) {
            }
        }
    }

    /**
     * 将一张网络图片转化成Base64字符串
     *
     * @param imageUrl 图片网络地址
     * @return 图片base64字符串
     */
    public static String netImageToBase64(String imageUrl) {
        InputStream is = null;
        try (ByteArrayOutputStream data = new ByteArrayOutputStream()) {
            // 创建URL
            URL url = new URL(imageUrl);
            byte[] by = new byte[1024];
            // 创建链接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(10000);
            is = conn.getInputStream();
            // 将内容读取内存中
            int len;
            while ((len = is.read(by)) != -1) {
                data.write(by, 0, len);
            }
            return Base64.getEncoder().encodeToString(data.toByteArray());
        } catch (IOException e) {
            log.error("网络图片转Base64字符串失败 imageUrl: {}, e: {}", imageUrl, e.getMessage(), e);
            return null;
        } finally {
            try {
                if (is != null) {
                    // 关闭流
                    is.close();
                }
            } catch (IOException ignore) {
            }
        }
    }

}
