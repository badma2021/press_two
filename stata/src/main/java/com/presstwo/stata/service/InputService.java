package com.presstwo.stata.service;

import com.presstwo.stata.dto.InputDto;

import java.util.List;

/**
 *
 */

public interface InputService {
    void createInput(InputDto inputDto);

    List<InputDto> fetchInputsForUserId(String userID);

    InputDto fetchInput(String inputId);

    List<InputDto> fetchTopRecentInputs();

    void updateInput(InputDto inputDto) throws RuntimeException;

    List<InputDto> fetchInputsByCategory(String category);
}

