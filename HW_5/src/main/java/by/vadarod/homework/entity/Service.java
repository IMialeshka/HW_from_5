package by.vadarod.homework.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(schema = "schema_hw", name = "services")
@Data
public class Service {
    @Id
    @SequenceGenerator(name = "sequenceService", schema = "schema_hw", sequenceName = "sequence_service", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceService")
    private long id;

    private String name;

    private double price;

}
