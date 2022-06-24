package lesson1.hw_2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.security.acl.Owner;

@Entity
@Getter
@Setter
@ToString
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String model;
    private Type type;
    private int power;
    private double price;
    private int year;


}
