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
@Table(name="visitorlog")
public class VisitorLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="purpose")
    private String purpose;
    @Column(name="visitor_entry_date_time")
    private LocalDateTime visitorEntryDateTime;
    @Column(name="visitor_exit_date_time")
    private LocalDateTime visitorExitDateTime;

     @ManyToOne(fetch = FetchType.LAZY,targetEntity =Visitor.class)
     @JoinColumn(name="fk_visitor_id")
     private Visitor visitor;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity =Badges.class)
    @JoinColumn(name="fk_badges_id")
    private Badges badges;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity =Host.class)
    @JoinColumn(name="fk_host_id")
    private Host host;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity =User.class)
    @JoinColumn(name="fk_user_id")
    private User user;


}

