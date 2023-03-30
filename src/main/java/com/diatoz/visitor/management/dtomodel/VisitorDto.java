package com.diatoz.visitor.management.dtomodel;

import lombok.Data;

@Data
public class VisitorDto {
    private Long visitorId;
    private String name;
    private String email;
    private Long phoneNum;
    private String address;
}
