import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "salon_car", joinColumns = @JoinColumn(name = "salon_id"),
                                    inverseJoinColumns = @JoinColumn(name = "car_id"))
    private List<Car> car;

    public Salon(String address, List<Car> car) {
        this.address = address;
        this.car = car;
    }
}
