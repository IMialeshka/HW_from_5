package by.vadarod.homework.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user", schema = "schema_hw")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @SequenceGenerator(name = "sequenceUser", schema = "schema_hw", sequenceName = "sequence_user", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceUser")
    private long id;

    private String name;

    private String surname;

    @Column(name = "year_birth")
    private int yearOfBirth;

    @Embedded
    private Address address;
}
