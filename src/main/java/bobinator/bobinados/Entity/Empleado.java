package bobinator.bobinados.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import lombok.Data;


//
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue(value="empleado")
@Entity
@Data
public class Empleado extends Usuario{
//    @Id
//    @GeneratedValue(generator = "uuid")
//    @GenericGenerator(name = "uuid", strategy = "uuid2")
//    private String id;

    private String nameTaller;
    
    
}
