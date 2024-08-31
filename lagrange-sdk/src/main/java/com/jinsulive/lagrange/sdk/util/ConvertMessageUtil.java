package com.jinsulive.lagrange.sdk.util;

import com.jinsulive.lagrange.core.constant.message.MessageType;
import com.jinsulive.lagrange.core.entity.message.Message;
import com.jinsulive.lagrange.core.entity.message.data.Image;

import java.util.List;
import java.util.Objects;

/**
 * 转换消息
 *
 * @author lxy
 * @since 2024年08月31日 12:33:21
 */
public class ConvertMessageUtil {

    public static void convert(List<Message> messages) {
        for (Message message : messages) {
            image(message);
        }
    }

    public static void image(Message message) {
        if (!MessageType.IMAGE.equals(message.getType())) {
            return;
        }
        Image image = (Image) message.getData();
        String file = image.getFile();
        String path;
        // 如果不是文件系统开头直接返回
        if (!file.startsWith("file://")) {
            return;
        }
        path = file.replaceFirst("file://", "");
        String imageToBase64 = ImageUtil.imageToBase64(path);
        if (Objects.isNull(imageToBase64)) {
            return;
        }
        image.setFile("base64://" + imageToBase64);
    }

}
