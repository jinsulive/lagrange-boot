package cn.jinsulive.lagrange.core.util;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.jinsulive.lagrange.core.event.BaseEvent;
import cn.jinsulive.lagrange.core.event.message.FriendMessageEvent;
import cn.jinsulive.lagrange.core.event.message.GroupMessageEvent;
import cn.jinsulive.lagrange.core.event.message.MessageEvent;
import cn.jinsulive.lagrange.core.event.meta.MataEvent;
import cn.jinsulive.lagrange.core.event.notice.NoticeEvent;
import cn.jinsulive.lagrange.core.event.request.RequestEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cn.jinsulive.lagrange.core.constant.message.MessageEventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @author lxy
 * @since 2024年03月06日 13:37:21
 */
public class ConvertUtil {

    private static final Logger log = LoggerFactory.getLogger(ConvertUtil.class);

    public static BaseEvent convertMessage(String message) {
        JSONObject messageJson = JsonUtil.toJsonObj(message);
        String postType = messageJson.getStr("post_type");
        if (Objects.isNull(postType)) {
            log.error("message转换BaseEvent错误 message: {}", message);
            return null;
        }
        return switch (postType) {
            case "message" -> JSONUtil.toBean(message, MessageEvent.class);
            case "meta_event" -> JSONUtil.toBean(message, MataEvent.class);
            case "notice" -> JSONUtil.toBean(message, NoticeEvent.class);
            case "request" -> JSONUtil.toBean(message, RequestEvent.class);
            default -> null;
        };
    }

    public static <T> T convertMessageData(Object data, Class<T> clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(JSONUtil.toJsonStr(data), clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static GroupMessageEvent convertGroupMessageEvent(MessageEvent messageEvent) {
        if (Objects.equals(MessageEventType.GROUP, messageEvent.getMessageType())) {
            return GroupMessageEvent.builder()
                    .time(messageEvent.getTime())
                    .selfId(messageEvent.getSelfId())
                    .postType(messageEvent.getPostType())
                    .nickname(messageEvent.getSender().getNickname())
                    .messageId(messageEvent.getMessageId())
                    .groupId(messageEvent.getGroupId())
                    .userId(messageEvent.getSender().getUserId())
                    .anonymous(messageEvent.getSender().getCard())
                    .role(messageEvent.getSender().getRole())
                    .title(messageEvent.getSender().getTitle())
                    .plainText(messageEvent.getPlainText())
                    .rawMessage(messageEvent.getRawMessage())
                    .sourceMessageChain(messageEvent.getMessage())
                    .matchType(messageEvent.getMatchType())
                    .matchValue(messageEvent.getMatchValue())
                    .build();
        }
        return null;
    }

    public static FriendMessageEvent convertFriendMessageEvent(MessageEvent messageEvent) {
        if (Objects.equals(MessageEventType.PRIVATE, messageEvent.getMessageType())) {
            return FriendMessageEvent.builder()
                    .time(messageEvent.getTime())
                    .selfId(messageEvent.getSelfId())
                    .postType(messageEvent.getPostType())
                    .nickname(messageEvent.getSender().getNickname())
                    .messageId(messageEvent.getMessageId())
                    .userId(messageEvent.getSender().getUserId())
                    .plainText(messageEvent.getPlainText())
                    .rawMessage(messageEvent.getRawMessage())
                    .sourceMessageChain(messageEvent.getMessage())
                    .matchType(messageEvent.getMatchType())
                    .matchValue(messageEvent.getMatchValue())
                    .build();
        }
        return null;
    }

    public static String convertMessageEventString(MessageEvent messageEvent) {
        FriendMessageEvent friendMessageEvent = convertFriendMessageEvent(messageEvent);
        if (friendMessageEvent != null) {
            return JSONUtil.toJsonStr(friendMessageEvent);
        }
        GroupMessageEvent groupMessageEvent = convertGroupMessageEvent(messageEvent);
        if (groupMessageEvent != null) {
            return JSONUtil.toJsonStr(groupMessageEvent);
        }
        return null;
    }

}
