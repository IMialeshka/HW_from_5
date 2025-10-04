package by.vadarod.homework.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Embeddable
public class Address {
    private String city;
    private String street;
    @Column(name = "house_number")
    private int houseNumber;
    @Column(name = "post_code")
    private String postCode;
}
