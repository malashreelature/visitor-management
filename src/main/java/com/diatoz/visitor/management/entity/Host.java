package com.diatoz.visitor.management.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="host")
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="host_id")
    private Long hostId;
    @Column(name="emp_name")
    private String empName;
    @Column(name="department")
    private String department;
    @Column(name="phone_num")
    private Long phoneNum;





}
