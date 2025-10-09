package by.vadarod.homework.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Where;

import java.util.Date;

//@Entity
//@Table(schema = "schema_hw", name = "clients")
@NoArgsConstructor
@Getter
@Setter
@ToString
@Immutable
@Where(clause = "status = 'PREMIUM'")
public class ClientPremium {
    @Id

    private long id;

    private String name;

    private String surname;

    @Enumerated(EnumType.STRING)
    private Status  status;


}
