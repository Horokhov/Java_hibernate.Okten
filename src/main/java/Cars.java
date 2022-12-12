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
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String number;

    private String model;

    @Enumerated(EnumType.STRING)
    private Availability availability;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "cars_drivers", joinColumns = @JoinColumn(name = "cars_id"),
                                      inverseJoinColumns = @JoinColumn(name = "drivers_id"))
    private List<Drivers> drivers;

}
