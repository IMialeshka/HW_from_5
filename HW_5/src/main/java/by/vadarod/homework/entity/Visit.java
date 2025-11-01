package by.vadarod.homework.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "visits", schema = "schema_hw")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Visit {
    @Id
    @SequenceGenerator(name = "sequenceVisit", schema = "schema_hw", sequenceName = "sequence_visit", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceVisit")
    private long id;

    @Column(name = "visit_date")
    private Date visitDate;

    @Column(name = "total_sum")
    private BigDecimal totalSum;

}
