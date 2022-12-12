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
public class Drivers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String surname;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "license_id", referencedColumnName = "id")
    private License license;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "cars_drivers", joinColumns = @JoinColumn(name = "drivers_id"),
            inverseJoinColumns = @JoinColumn(name = "cars_id"))
    private List<Cars> cars;

    public Drivers(String name, String surname, License license, List<Cars> cars) {
        this.name = name;
        this.surname = surname;
        this.license = license;
        this.cars = cars;
    }
}
