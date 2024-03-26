package com.jinsulive.lagrange.spring.autoconfigure.service.message.impl;

import cn.hutool.core.util.StrUtil;
import com.jinsulive.lagrange.core.annotation.message.MessageListenerInfo;
import com.jinsulive.lagrange.core.constant.core.MatchType;
import com.jinsulive.lagrange.core.constant.message.MessageType;
import com.jinsulive.lagrange.core.entity.message.Message;
import com.jinsulive.lagrange.core.entity.message.data.At;
import com.jinsulive.lagrange.core.entity.message.data.Text;
import com.jinsulive.lagrange.core.event.message.MessageEvent;
import com.jinsulive.lagrange.core.service.Matcher;
import com.jinsulive.lagrange.core.util.ConvertUtil;
import com.jinsulive.lagrange.spring.autoconfigure.service.message.MessageEventMatcherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lxy
 * @since 2024年03月11日 17:11:40
 */
public class MessageEventMatcherServiceImpl implements MessageEventMatcherService {

    private static final Logger log = LoggerFactory.getLogger(MessageEventMatcherServiceImpl.class);

    @Override
    public boolean match(MessageEvent messageEvent, MessageListenerInfo messageListenerInfo) {
        return this.checkAssignment(messageEvent.getSelfId(), messageListenerInfo.getBots()) &&
                this.checkAssignment(messageEvent.getGroupId(), messageListenerInfo.getGroups()) &&
                this.checkAssignment(messageEvent.getUserId(), messageListenerInfo.getAuthors()) &&
                this.isAtBot(messageEvent, messageListenerInfo) &&
                this.matchMessage(messageEvent, messageListenerInfo);
    }

    private boolean checkAssignment(Long id, List<String> list) {
        return list != null && (list.isEmpty() || list.contains(id.toString()));
    }

    private boolean isAtBot(MessageEvent messageEvent, MessageListenerInfo messageListenerInfo) {
        boolean atBot = messageListenerInfo.isAtBot();
        List<Message> messages = messageEvent.getMessage();
        Long selfId = messageEvent.getSelfId();
        return !atBot || messages.stream().anyMatch(message -> {
            boolean isAt = message.getType().equals(MessageType.AT);
            if (isAt) {
                try {
                    At at = ConvertUtil.convertMessageData(message.getData(), At.class);
                    return at != null && at.getQq().equals(selfId.toString());
                } catch (Exception e) {
                    log.error("MessageEventMatcher 转换At消息失败 e: {}", e.getMessage(), e);
                    return false;
                }
            }
            return false;
        });
    }

    private boolean matchMessage(MessageEvent messageEvent, MessageListenerInfo messageListenerInfo) {
        String plainText = parseMessageEventPlainText(messageEvent);
        String matchPlainText = messageListenerInfo.isContentTrim() ? plainText.trim() : plainText;
        if (messageListenerInfo.isContentTrim()) {
            messageEvent.setPlainText(matchPlainText);
        }
        String matchValue = messageListenerInfo.getMatchValue();
        MatchType matchType = messageListenerInfo.getMatchType();
        Matcher<String, String> matcher = matchType.getMatcher();
        return matcher.match(matchPlainText, matchValue);
    }

    private String parseMessageEventPlainText(MessageEvent messageEvent) {
        String plainText = messageEvent.getPlainText();
        List<Message> messages = messageEvent.getMessage();
        if (StrUtil.isBlank(plainText)) {
            String joinPlainText = messages.stream().filter(e -> Objects.equals(e.getType(), MessageType.TEXT))
                    .map(e -> {
                        Text text = ConvertUtil.convertMessageData(e.getData(), Text.class);
                        return text.getText();
                    }).collect(Collectors.joining());
            if (StrUtil.isNotBlank(joinPlainText)) {
                messageEvent.setPlainText(joinPlainText);
            }
            return joinPlainText;
        }
        return plainText;
    }

}
