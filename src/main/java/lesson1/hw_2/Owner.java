package lesson1.hw_2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString(exclude = "car")
public class Owner implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @OneToOne(fetch = FetchType.EAGER)
    private Car car;


}
