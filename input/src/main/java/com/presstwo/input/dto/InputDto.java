package com.presstwo.input.dto;

import lombok.Data;

import java.util.Date;

/**
 * This file was created by aantonica on 20/05/2020
 */
@Data
public class InputDto {

    private String id;
    private String content;
    private String userId;
    private String title;
    private Boolean available;
    private Date createdAt;
    private Date updatedAt;

}
