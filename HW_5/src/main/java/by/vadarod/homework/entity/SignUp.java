package by.vadarod.homework.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "sign_up", schema = "schema_hw")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class SignUp {
    @Id
    @SequenceGenerator(name = "sequenceSign", schema = "schema_hw", sequenceName = "sequence_sign", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceSign")
    private Long id;

    @Column(name = "data_signed")
    private Date dataSigned;

    @Column(name = "time_signed")
    private LocalTime timeSigned;

    @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "user_id")
    private User user;


    @ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "premises_id")
    private Premises premises;

}
