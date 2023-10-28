package com.presstwo.input.controller;


import com.presstwo.input.dto.InputDto;
import com.presstwo.input.service.InputService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

/**
 * This file was created by aantonica on 20/05/2020
 */
@RestController
@RequestMapping("/input")
public class InputController {

    @Autowired
    InputService inputService;


    //- create his own inputs
    @PostMapping("/create")
    public InputDto createInput(@RequestBody InputDto inputDto) {

        inputService.createInput(inputDto);

        return inputDto;
    }


    //    - fetch his own inputuments
    @GetMapping("/all/{userId}")

    public List<InputDto> fetchUserInputs(@PathVariable String userId) {



        return inputService.fetchInputsForUserId(userId);
    }

    //- fetch a public inputument
    @GetMapping("/fetch/{inputId}")
    public InputDto fetchInput(@PathVariable String inputId, HttpServletRequest httpServletRequest) {

//        String jwtToken = getJwtTokenFromHeader(httpServletRequest);
//        String userId = tokenService.getUserId(jwtToken);

        return inputService.fetchInput(inputId);
    }

    //- fetch 10 most recents inputs that are public
    @GetMapping("/recent")
  //  @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'ANONYMOUS')")
    public List<InputDto> fetRecentInputs() {

        return inputService.fetchTopRecentInputs();
    }

    //- modify his own inputs
    @PutMapping("/update")
   // @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public InputDto updateInput(@RequestBody InputDto inputDto, HttpServletRequest httpServletRequest) throws RuntimeException {

       // String jwtToken = getJwtTokenFromHeader(httpServletRequest);

       // String userId = tokenService.getUserId(jwtToken); //userId -> issuer on jwtToken

        inputService.updateInput(inputDto);

        return inputDto;
    }

    private String getJwtTokenFromHeader(HttpServletRequest httpServletRequest) {

        try {
            String tokenHeader = httpServletRequest.getHeader(AUTHORIZATION);
            return StringUtils.removeStart(tokenHeader, "Bearer ").trim();
        } catch (NullPointerException e) {
            return StringUtils.EMPTY;
        }
    }

    //- delete his own inputs
    // TODO: homework
}

