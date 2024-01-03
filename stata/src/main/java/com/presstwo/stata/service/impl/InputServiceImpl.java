package com.presstwo.stata.service.impl;

import com.presstwo.stata.dto.InputDto;
import com.presstwo.stata.entity.Input;
import com.presstwo.stata.repository.InputDao;
import com.presstwo.stata.service.InputService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Objects.isNull;

/**
 * This file was created by
 */
@Service
public class InputServiceImpl implements InputService {
    private static final Logger log = LoggerFactory.getLogger(InputServiceImpl.class);
    @Autowired
    InputDao inputDao;

    @Autowired
    ModelMapper modelMapper;

    private final StreamBridge streamBridge;

    public InputServiceImpl(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Override
    public void createInput(InputDto inputDto) {

        checkNotNull(inputDto.getContent());
        checkNotNull(inputDto.getTitle());
        checkNotNull(inputDto.getUserId());
        checkNotNull(inputDto.getCategory());

        Input input = modelMapper.map(inputDto, Input.class);

        if (isNull(input.getAvailable())) {
            input.setAvailable(false);
        }

        inputDao.save(input);

        modelMapper.map(input, inputDto);
    }

    @Override
    public List<InputDto> fetchInputsForUserId(String userID) {

        final List<Input> allByUserId = inputDao.findAllByUserIdOrderByUpdatedAtDesc(userID);


            return allByUserId.stream()
                    .map(input -> modelMapper.map(input, InputDto.class))
                    .collect(Collectors.toList());

    }

    @Override
    public InputDto fetchInput(String inputId) {

        final Optional<Input> optionalInput = inputDao.findById(inputId);
        if (optionalInput.isPresent()) {

            return modelMapper.map(optionalInput.get(), InputDto.class);
        }
        return null;
    }

    @Override
    public List<InputDto> fetchTopRecentInputs() {

        final Page<Input> recentInputs = inputDao.findByAvailable(true, PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "updatedAt")));

        return recentInputs.stream()
                .map(input -> modelMapper.map(input, InputDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void updateInput(InputDto inputDto) throws RuntimeException {

        checkNotNull(inputDto.getContent());
        checkNotNull(inputDto.getTitle());
        checkNotNull(inputDto.getUserId());
        checkNotNull(inputDto.getCategory());

        final Optional<Input> optionalInput = inputDao.findById(inputDto.getId());
        if (optionalInput.isPresent()) {

            final Input input = optionalInput.get();

                modelMapper.map(inputDto, input);

                inputDao.save(input);

                modelMapper.map(input, inputDto);
        }

        throw new NoSuchElementException("No input with id " + inputDto.getId() + " was found");
    }

    @Override
    public List<InputDto> fetchInputsByCategory(String category) {
        List<Input> inputList = inputDao.findByCategory(category);


            return inputList.stream()
                    .map(input -> modelMapper.map(input, InputDto.class))
                    .collect(Collectors.toList());


    }

}
