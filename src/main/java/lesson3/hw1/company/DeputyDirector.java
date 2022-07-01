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
@Getter
@Setter
@ToString

public class DeputyDirector implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "dir_deputyDir",
            inverseJoinColumns = @JoinColumn(name = "dir"),
            joinColumns = @JoinColumn(name = "deputyDir")
    )
    @ToString.Exclude
    private Director director;

    @ManyToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    @JoinTable(
            name = "deputyDir_employers",
            joinColumns = @JoinColumn(name = "depDir"),
            inverseJoinColumns = @JoinColumn(name = "empl")
    )
    private List<Employers>employers;

    public DeputyDirector(String name, Director director, List<Employers> employers) {
        this.name = name;
        this.director = director;
        this.employers = employers;
    }
}
