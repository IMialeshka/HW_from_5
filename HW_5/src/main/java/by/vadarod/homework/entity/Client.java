package by.vadarod.homework.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(schema = "schema_hw", name = "clients")
@NoArgsConstructor
@Getter
@Setter
@ToString
@PrimaryKeyJoinColumn(name = "user_id")
public class Client extends User{
    private String phone;

    @Column(name = "last_visit_date")
    private Date lastVisitDate;

    @Enumerated(EnumType.STRING)
    private Status  status;

    private double amount;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private List<Visit> visits;

}
