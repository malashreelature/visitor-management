package com.diatoz.visitor.management.model;

import com.diatoz.visitor.management.entity.AcessControl;
import com.diatoz.visitor.management.entity.Badges;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BadgesModel {

    private String errorMessage;
    private Badges badges;



}
