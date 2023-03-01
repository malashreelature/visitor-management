package com.diatoz.visitor.management.model;

import com.diatoz.visitor.management.entity.AcessControl;
import com.diatoz.visitor.management.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcessModel {

    private String errorMessage;
    private AcessControl acessControl;



}
