/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobinator.bobinados.Entity;

import bobinator.bobinados.Enum.TipoDeMotor;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author groxa
 */
@DiscriminatorValue(value = "monofasico")
@Entity
@Data

public class Monofasico {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private TipoDeMotor tipo;
    private Integer numeroDePolos;
    private Integer numeroDeRanuras;
    private Double dInternoDEstator;
    private Double dExternoDEstator;
    private String alturaDeCabeza;
    private Double apilamientoDChapa;
    private Double potenciaEnHP;
    private Integer corrienteEnAmp;
    private Double tension;
    private Double frecuenciaEnHZ;
    private Integer capacitor;
    private Boolean esPermanente;
    private Boolean esPolo;
}
