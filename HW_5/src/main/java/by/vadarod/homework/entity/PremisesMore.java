package by.vadarod.homework.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Immutable
@Subselect("select p.id as id, p.name as name, p.price as price FROM schema_hw.premises p where p.maxpeople <= 15")
public class PremisesMore {
    @Id
    private Long id;

    private String name;

    private double price;
}
