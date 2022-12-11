import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long number;
    @Enumerated(EnumType.STRING)
    private Availability availability;

    private String model;

}
