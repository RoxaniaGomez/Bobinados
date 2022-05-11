package bobinator.bobinados.Entity;

import bobinator.bobinados.Enum.Estado;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

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
    @OneToOne
    private Calculos calculo;
    
    private Double presupuesto;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "yyyy-mm-dd")
    private Date fecha;
    private boolean alta;
   

    
    
}
