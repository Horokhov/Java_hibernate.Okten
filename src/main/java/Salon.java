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
    @JoinTable(name = "salon_cars", joinColumns = @JoinColumn(name = "salon_id"),
                                    inverseJoinColumns = @JoinColumn(name = "cars_id"))
    private List<Cars> cars;

    public Salon(String address, List<Cars> cars) {
        this.address = address;
        this.cars = cars;
    }
}
