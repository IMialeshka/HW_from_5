package by.vadarod.homework.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(schema = "schema_hw", name = "clients")
@Data
public class Client {
    @Id
    @SequenceGenerator(name = "sequenceClient", schema = "schema_hw", sequenceName = "sequence_client", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceClient")
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
