package com.diatoz.visitor.management.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="acesscontrol")
public class AccessControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long acessId;
    @Column(name="date_time")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity =Badges.class)
    @JoinColumn(name="fk_badges_id")
    private Badges badges;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity =Premises.class)
    @JoinColumn(name="fk_premise_id")
    private Premises premises;




}
