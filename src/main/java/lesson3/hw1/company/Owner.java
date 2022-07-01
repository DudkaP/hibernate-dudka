package lesson3.hw1.company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Owner implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    private String companyName;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Director director;

    public Owner(String companyName, String name, Director director) {
        this.companyName = companyName;
        this.name = name;
        this.director = director;
    }
}
