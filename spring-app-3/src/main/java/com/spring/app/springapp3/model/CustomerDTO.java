package com.spring.app.springapp3.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class CustomerDTO {
    private UUID id;
    private String name;
    private Integer version;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}

