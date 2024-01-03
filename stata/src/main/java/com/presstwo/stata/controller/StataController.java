package com.presstwo.stata.controller;

import com.presstwo.stata.dto.InputDto;
import com.presstwo.stata.service.InputService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StataController {
    private static final Logger logger = LoggerFactory.getLogger(StataController.class);
    @Autowired
    InputService inputService;


    //    - fetch his own inputuments
    @GetMapping("/all/{category}")

    public List<InputDto> fetchByCategory(@PathVariable String category) {
        logger.info("/all/{category} starts");
        return inputService.fetchInputsByCategory(category);
    }

    @GetMapping("/all/helloworld")

    public String helloWorld() {
        logger.info("hello world starts");
        return "Hello World";
    }

}