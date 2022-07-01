package lesson3.hw1.company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Setter

public class Employers implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "deputyDir_employers",
            joinColumns = @JoinColumn(name = "empl"),
            inverseJoinColumns = @JoinColumn(name = "depDir")
    )
    @ToString.Exclude
    private List<DeputyDirector> deputyDirectors;

    public Employers(String name, List<DeputyDirector> deputyDirectors) {
        this.name = name;
        this.deputyDirectors = deputyDirectors;
    }
}
