package lesson3.hw1.company;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Director implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @OneToOne (cascade = CascadeType.ALL)
    @ToString.Exclude
    private Owner owner;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "dir_deputyDir",
            joinColumns = @JoinColumn(name = "dir"),
            inverseJoinColumns = @JoinColumn(name = "deputyDir")
    )
    @ToString.Exclude
    private List<DeputyDirector> deputyDirectors;


    public Director(String name, Owner owner, ArrayList<DeputyDirector> deputyDirectors) {
        this.name = name;
        this.owner = owner;
        this.deputyDirectors = deputyDirectors;
    }
}
