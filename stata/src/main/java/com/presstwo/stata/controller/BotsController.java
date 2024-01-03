//package com.presstwo.stata.controller;
//
//import com.presstwo.stata.entity.Message;
//import com.presstwo.stata.entity.OutputMessage;
//
//import com.presstwo.stata.service.PushMessage;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//@Controller
//public class BotsController {
//    @Autowired
//    private PushMessage pushMessage;
//
//    @MessageMapping("/chatwithbots")
//    @SendTo("/topic/pushmessage")
//    public OutputMessage send(final Message message) throws Exception {
//
//        final String time = new SimpleDateFormat("HH:mm").format(new Date());
//        return new OutputMessage(message.getFrom(), message.getText(), time);
//    }
//
//    @GetMapping("api/triggerPolling")
//
//    public void triggerPolling() {
//
//
//     pushMessage.sendMessage();
//    }
//
//}