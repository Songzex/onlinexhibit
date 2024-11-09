package com.example.service;

import cn.hutool.json.JSONObject;
import com.example.config.ThreadLocalToken;
import com.example.pojo.MessageEntity;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * 单聊节点
 * 服务器端 WebSocket消息推送处理类
 * @author 24022*/
@ServerEndpoint(value = "/websockets/{username}")
@Component
@Slf4j
public class ChatEndpoint {

    private static final Map<String, Session> sessions = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        sessions.put(username, session);
        log.info("webSocket连接");
        log.info("单聊WebSocket 连接 opened for 用户: {}", username);
        sessions.forEach(
                (key,value)->
                        System.out.println(key+"::::"+value)

        );
    }

    @OnMessage
    public void onMessage(String message, Session session, @PathParam("username") String senderUsername) {
        sessions.forEach(
                (key,value)->
                        System.out.println(key+" 当前::"+value)

        );
        //log.info("收到的信息显示"+message);
        //ObjectMapper objectMapper = new ObjectMapper();
        try {
            Gson gson = new Gson();
            // 假设你有一个特定的对象类型 YourObject
            ObjectMapper objMapper = new ObjectMapper();
            Map<String, String> emailData = objMapper.readValue(message, HashMap.class);
            // 根据接收者用户名获取接收者的 WebSocket 连接
            Session receiverSession = sessions.get(emailData.get("tousrid"));
            if (receiverSession != null && receiverSession.isOpen()) {
                try {
                    // 将消息发送给接收者
                    receiverSession.getBasicRemote().sendText(message);
                    //threadLocalToken.getUserService().cunchu(message);
                    new UserServiceImpl().cunchu(message);
                    System.out.println("gggg"+message);
                } catch (IOException e) {
                    log.error("Error sending message to user: {}", emailData.get("tousrid"), e);
                }
            } else {
                log.warn("User {} is not connected or session is closed",emailData.get("tousrid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @OnClose
    public void onClose(Session session, @PathParam("username") String username) {
        sessions.remove(username);
        log.info("WebSocket connection closed for user: {}", username);
    }
}
