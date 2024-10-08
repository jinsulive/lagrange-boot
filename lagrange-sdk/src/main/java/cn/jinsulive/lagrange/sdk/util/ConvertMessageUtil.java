package cn.jinsulive.lagrange.sdk.util;

import cn.jinsulive.lagrange.core.constant.message.MessageType;
import cn.jinsulive.lagrange.core.entity.message.Message;
import cn.jinsulive.lagrange.core.entity.message.data.Image;

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
        if (Objects.isNull(file)) {
            return;
        }
        String path;
        String imageToBase64 = null;
        // 如果不是文件系统开头直接返回
        if (file.startsWith("file://")) {
            path = file.replaceFirst("file://", "");
            imageToBase64 = ImageUtil.imageToBase64(path);
        } else if (PatternUtil.isUrl(file)) {
            imageToBase64 = ImageUtil.netImageToBase64(file);
        }
        if (Objects.isNull(imageToBase64)) {
            return;
        }
        image.setFile("base64://" + imageToBase64);
    }

}
