package com.diatoz.visitor.management.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="visitor")
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="visitor_id")
    private Long visitorId;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="phone_num")
    private Long phoneNum;
    @Column(name="address")
    private String address;






}
