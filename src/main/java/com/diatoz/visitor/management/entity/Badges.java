package com.diatoz.visitor.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="badges")
public class Badges {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="badges_num")
    private Long badgesNum;
    @Column(name="expiration_date")
    private LocalDate expirationDate;
    @Column(name="expiration_time")
    private LocalTime expirationTime;






}
