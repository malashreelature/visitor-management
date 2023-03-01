package com.diatoz.visitor.management.model;

import com.diatoz.visitor.management.entity.Host;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HostModel {

    private String errorMessage;
    private Host host;




}
