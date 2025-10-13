package by.vadarod.homework.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "employees", schema = "schema_hw")
@NoArgsConstructor
@Getter
@Setter
@ToString
@PrimaryKeyJoinColumn(name = "user_id")
public class Employee extends User{

    @Column(name = "hiring_date")
    private Date hiringDate;

    @Column(name = "termination_date")
    private Date terminationDate;

    private String position;
    private double salary;
}
