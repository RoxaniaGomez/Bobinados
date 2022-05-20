/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobinator.bobinados.Service;

import bobinator.bobinados.Entity.Calculos;
import bobinator.bobinados.Entity.Trifasico;
import bobinator.bobinados.Repository.CalculosRepository;
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author groxa
 */
@Service
public class CalculoService {

    @Autowired
    private TrifasicoServicio trifasicoService;
    @Autowired
    private CalculosRepository calculoRepository;
    
    public Calculos resolver(Trifasico trifasico) {
        
        Calculos calculo = new Calculos();
        calculo.setRanuraPorPoloPorFase((trifasico.getNumeroDeRanuras() / (trifasico.getNumeroDePolos() * 3)));
        if ((trifasico.getNumeroDeRanuras() / (trifasico.getNumeroDePolos() * 3)) % 2 == 0) {
            //sera concentrico
            if (trifasico.getPolo().equals("POLO")) {
                //por polo
                calculo.setGrupos(trifasico.getNumeroDePolos() * 3);
                calculo.setNumeroDeBobinaPorGrupo((trifasico.getNumeroDeRanuras() / (2 * trifasico.getNumeroDePolos() * 3)));
                calculo.setAmplitudDeGrupo(4 * calculo.getNumeroDeBobinaPorGrupo());
                // lista  
                Integer y = (trifasico.getNumeroDeRanuras() / (3 * (trifasico.getNumeroDePolos() / 2)));
                calculo.setPaso1(1);
                calculo.setPaso2(1+y);
                calculo.setPaso3(1+y+y);
 
                
            } else {
                //por polo consecuente
                calculo.setGrupos((2 / trifasico.getNumeroDePolos()) * 3);
                calculo.setNumeroDeBobinaPorGrupo((trifasico.getNumeroDeRanuras() / (trifasico.getNumeroDePolos() * 3)));
                calculo.setAmplitudDeGrupo(4 * calculo.getNumeroDeBobinaPorGrupo());
                // lista
                Integer y = (trifasico.getNumeroDeRanuras() / (3 * (trifasico.getNumeroDePolos() / 2)));
                calculo.setPaso1(1);
                calculo.setPaso2(1+y);
                calculo.setPaso3(1+y+y);
                
            }
         calculo.setVueltasPorBobinas((1.44 * trifasico.getNumeroDePolos() * 220) / (2 * 50 * (trifasico.getApilamientoDChapa() / 1000)
                        * (trifasico.getDInternoDEstator() / 1000) * trifasico.getNumeroDeRanuras() * 0.8));
                if (trifasico.getConexion().equals("ESTRELLA")) {
                    if (trifasico.getPotenciaEnHP() <= 10) {
                        calculo.setSeccionDelAlambre((trifasico.getCorrienteEnAmp() * 1.73) / 7 * 1.73);
                    } else {
                        calculo.setSeccionDelAlambre((trifasico.getCorrienteEnAmp() * 1.73) / 5 * 1.73);
                    }

                } else {
                    //triangulo
                    if (trifasico.getPotenciaEnHP() <= 10) {
                        calculo.setSeccionDelAlambre((trifasico.getCorrienteEnAmp()) / 7 * 1.73);
                    } else {
                        calculo.setSeccionDelAlambre((trifasico.getCorrienteEnAmp()) / 5 * 1.73);
                    }
                }
                calculo.setDiametroDelAlmbreMM(sqrt(4 * calculo.getSeccionDelAlambre() / PI));
                calculo.setPesoDelAlambreKG((0.00000896*PI*(calculo.getDiametroDelAlmbreMM()*calculo.getDiametroDelAlmbreMM())/4*((((trifasico.getDInternoDEstator() * PI) / trifasico.getNumeroDePolos()) * 2 + (2 * trifasico.getApilamientoDChapa())) * calculo.getVueltasPorBobinas() * calculo.getGrupos() * calculo.getNumeroDeBobinaPorGrupo()))*1.5);
                 
        } else {
            //sera por exentrico fraccionario
           //falta Exentrico Fraccionario;
           if (trifasico.getPolo().equals("POLO")) {
                //por polo
                calculo.setGrupos(trifasico.getNumeroDePolos() * 3);
                calculo.setNumeroDeBobinaPorGrupo((trifasico.getNumeroDeRanuras() / (2 * trifasico.getNumeroDePolos() * 3)));
                calculo.setAmplitudDeGrupo(4 * calculo.getNumeroDeBobinaPorGrupo());
                // lista  
                Integer y = (trifasico.getNumeroDeRanuras() / (3 * (trifasico.getNumeroDePolos() / 2)));
                calculo.setPaso1(1);
                calculo.setPaso2(1+y);
                calculo.setPaso3(1+y+y);
 
                
            } else {
                //por polo consecuente
                calculo.setGrupos((2 / trifasico.getNumeroDePolos()) * 3);
                calculo.setNumeroDeBobinaPorGrupo((trifasico.getNumeroDeRanuras() / (trifasico.getNumeroDePolos() * 3)));
                calculo.setAmplitudDeGrupo(4 * calculo.getNumeroDeBobinaPorGrupo());
                // lista
                Integer y = (trifasico.getNumeroDeRanuras() / (3 * (trifasico.getNumeroDePolos() / 2)));
                calculo.setPaso1(1);
                calculo.setPaso2(1+y);
                calculo.setPaso3(1+y+y);
                
            }
         calculo.setVueltasPorBobinas((1.44 * trifasico.getNumeroDePolos() * 220) / (2 * 50 * (trifasico.getApilamientoDChapa() / 1000)
                        * (trifasico.getDInternoDEstator() / 1000) * trifasico.getNumeroDeRanuras() * 0.8));
                if (trifasico.getConexion().equals("ESTRELLA")) {
                    if (trifasico.getPotenciaEnHP() <= 10) {
                        calculo.setSeccionDelAlambre((trifasico.getCorrienteEnAmp() * 1.73) / 7 * 1.73);
                    } else {
                        calculo.setSeccionDelAlambre((trifasico.getCorrienteEnAmp() * 1.73) / 5 * 1.73);
                    }

                } else {
                    //triangulo
                    if (trifasico.getPotenciaEnHP() <= 10) {
                        calculo.setSeccionDelAlambre((trifasico.getCorrienteEnAmp()) / 7 * 1.73);
                    } else {
                        calculo.setSeccionDelAlambre((trifasico.getCorrienteEnAmp()) / 5 * 1.73);
                    }
                }
                calculo.setDiametroDelAlmbreMM(sqrt(4 * calculo.getSeccionDelAlambre() / PI));
                calculo.setPesoDelAlambreKG((0.00000896*PI*(calculo.getDiametroDelAlmbreMM()*calculo.getDiametroDelAlmbreMM())/4*((((trifasico.getDInternoDEstator() * PI) / trifasico.getNumeroDePolos()) * 2 + (2 * trifasico.getApilamientoDChapa())) * calculo.getVueltasPorBobinas() * calculo.getGrupos() * calculo.getNumeroDeBobinaPorGrupo()))*1.5);
        }
        return calculoRepository.save(calculo);
    }
}
