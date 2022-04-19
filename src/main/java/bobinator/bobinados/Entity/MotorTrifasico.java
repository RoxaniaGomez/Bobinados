package bobinator.bobinados.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data

public class MotorTrifasico {

    @Id
    private String id;
    private Integer numeroPolo;

    private Integer numeroRanura;

    private Double corrienteAMP;

    private Double tension;

    private Integer frecuenciaHz;

    private Double diametroExterno;

    private Double diametroInterno;

    private Integer potencia;

    private Integer apilamientoDeChapa;

    private Boolean esConcentrico;

    private Alambre alambre;

    private Polo polo;

    private Integer grupoDeBobina;

    private Integer ranuraPorFases;

    private Integer amplitudDelGrupo;

    private Integer bobinasPorGrupo;
}
