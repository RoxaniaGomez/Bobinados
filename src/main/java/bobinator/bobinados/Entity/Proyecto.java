package bobinator.bobinados.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Proyecto {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Empleado empleado;
    @OneToOne(cascade = CascadeType.ALL)
    private Trifasico motorTrifasico;
    @OneToOne(cascade = CascadeType.ALL)
    private Monofasico motorMonofasico;
    private boolean alta;

    
    
}
