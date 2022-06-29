package lesson2.hw1;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString

public class DriveLicense implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private int series;

    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Owner owner;

    public DriveLicense(int series) {
        this.series = series;
    }
}
