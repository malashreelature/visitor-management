package com.diatoz.visitor.management.model;

import com.diatoz.visitor.management.entity.AcessControl;
import com.diatoz.visitor.management.entity.Premises;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PremisesModel {

    private String errorMessage;
    private Premises premises;



}

