//package com.presstwo.stata.service;
//
//import com.presstwo.stata.entity.OutputMessage;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Service;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@Service
//public class PushMessage {
//
//    private final SimpMessagingTemplate simpMessagingTemplate;
//
//
//    public PushMessage(SimpMessagingTemplate simpMessagingTemplate) {
//        this.simpMessagingTemplate = simpMessagingTemplate;
//
//    }
//
//    public void sendMessage() {
//        final String time = new SimpleDateFormat("HH:mm").format(new Date());
//        simpMessagingTemplate.convertAndSend("/topic/pushmessage",
//                new OutputMessage("Chuck Norris", "ghg", time));
//    }
//
//}
