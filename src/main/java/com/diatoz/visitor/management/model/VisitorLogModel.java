package com.diatoz.visitor.management.model;

import com.diatoz.visitor.management.entity.VisitorLog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorLogModel {

    private String errorMessage;
    private VisitorLog vl;



}
