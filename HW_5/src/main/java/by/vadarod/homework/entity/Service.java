package by.vadarod.homework.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "schema_hw", name = "services")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Service {
    @Id
    @SequenceGenerator(name = "sequenceService", schema = "schema_hw", sequenceName = "sequence_service", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceService")
    private long id;

    private String name;

    private double price;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id")
    private List<Premises> premisesList;

}
