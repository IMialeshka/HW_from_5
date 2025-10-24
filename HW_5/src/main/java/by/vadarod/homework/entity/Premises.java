package by.vadarod.homework.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(schema = "schema_hw", name = "premises")
@NoArgsConstructor
@Getter
@Setter
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

    @OneToMany(mappedBy = "premises", fetch = FetchType.EAGER, cascade =  CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<SignUp> signUpList;

    @Override
    public String toString() {
        return this.getName() + " " + this.getIdNumber() + " " + this.getMaxPeople() + " " + this.getPrice();
    }
}
