package by.vadarod.homework.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "schema_hw", name = "premises")
@Data
public class Premises {
    @Id
    @SequenceGenerator(name = "sequencePremises", schema = "schema_hw", sequenceName = "sequence_premises", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencePremises")
    private Long id;

    private String name;

    @Column(unique = true)
    private short idNumber;

    private short maxPeople;

    @Enumerated(EnumType.STRING)
    private PremisesStatus status;

    private double price;
}
