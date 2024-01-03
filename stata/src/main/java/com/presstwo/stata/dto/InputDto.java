package com.presstwo.stata.dto;

import lombok.Data;

import java.util.Date;

/**
 * This file was created by
 */
@Data
public class InputDto {

    private String id;
    private String content;
    private String userId;
    private String title;
    private Boolean available;
    private String category;
    private Date createdAt;
    private Date updatedAt;

}
