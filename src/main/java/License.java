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
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String series;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "license")
    private Drivers drivers;
}
