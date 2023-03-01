package com.diatoz.visitor.management.model;

import com.diatoz.visitor.management.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private String errorMessage;
    private User user;



}
