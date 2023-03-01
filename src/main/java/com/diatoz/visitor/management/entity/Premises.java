package com.diatoz.visitor.management.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="premise")
public class Premises {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="building_name")
    private String buildingName;
    @Column(name="room_num")
    private Long roomNum;
    @Column(name="floor")
    private int floor;




   }


