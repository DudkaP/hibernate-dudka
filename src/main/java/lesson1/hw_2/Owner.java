package lesson1.hw_2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString(exclude = "car")
@NoArgsConstructor
public class Owner implements Serializable {
    @Id
//    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Car car;

    public Owner(String name) {
        this.name = name;
    }

    public Owner(String name, Car car) {
        this.name = name;
        this.car = car;
    }

}
