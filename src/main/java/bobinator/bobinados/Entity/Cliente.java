package bobinator.bobinados.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//import javax.persistence.OneToOne;
import lombok.Data;


//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value="cliente")
@Entity
@Data
public class Cliente extends Usuario{
//
//    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
//    private String id;

    private String telefono;

}
