/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobinator.bobinados.Entity;

import bobinator.bobinados.Enum.TipoDeMotor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author groxa
 */

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Data
abstract public class Motor{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private String fabricante;
    private String Nacionalidad;
    private String numDeMotor;
    private String modelo;
    private String regimenDeServicio;
    private String tipoDeAislacion;
    private String notas;
   
    private TipoDeMotor  tipo;
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
    
}
