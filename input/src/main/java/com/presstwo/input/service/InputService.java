package com.presstwo.input.service;

import com.presstwo.input.dto.InputDto;

import java.util.List;

/**
 *
 */

public interface InputService {
    void createInput(InputDto inputDto);

    List<InputDto> fetchInputsForUserId(String userID);

    InputDto fetchInput(String docId);

    List<InputDto> fetchTopRecentInputs();

    void updateInput(InputDto inputDto) throws RuntimeException;

}

