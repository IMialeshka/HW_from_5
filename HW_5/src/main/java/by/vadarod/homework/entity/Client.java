package by.vadarod.homework.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(schema = "schema_hw", name = "clients")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private long id;

    private String name;

    private String surname;

    private int age;

    private String phone;

    @Column(name = "last_visit_date")
    private Date lastVisitDate;

    @Enumerated(EnumType.STRING)
    private Status  status;

    private double amount;

}
