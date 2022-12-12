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
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;

    private String model;

    @Enumerated(EnumType.STRING)
    private Availability availability;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "car_driver", joinColumns = @JoinColumn(name = "car_id"),
                                      inverseJoinColumns = @JoinColumn(name = "driver_id"))
    private List<Driver> driver;

    public Car(String number, String model, Availability availability, List<Driver> driver) {
        this.number = number;
        this.model = model;
        this.availability = availability;
        this.driver = driver;
    }
}
