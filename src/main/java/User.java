import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
//@EqualsAndHashCode
@Table(name = "user_table")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ElementCollection
    private List<String> skills;
    private String name;
    @Column(
            name = "secondName",
            unique = false,
            nullable = true,
            insertable = true,
            updatable = true,
            length = 250
    )
    private String surname;

    @Enumerated(EnumType.STRING)
    private Gender gender;



    public User(String name, String surname,Gender gender,List<String> skills) {
        this.name = name;
        this.surname = surname;
        this.gender=gender;
        this.skills=skills;
    }

    public User(String name) {
        this.name = name;
    }
}