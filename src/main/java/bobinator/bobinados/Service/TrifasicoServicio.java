/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobinator.bobinados.Service;

import bobinator.bobinados.Entity.Monofasico;
import bobinator.bobinados.Entity.Motor;
import bobinator.bobinados.Entity.Trifasico;
import bobinator.bobinados.Repository.MonofasicoRepository;
import bobinator.bobinados.Repository.TrifasicoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author groxa
 */
@Service
public class TrifasicoServicio {
       @Autowired
    private TrifasicoRepository motorRepositorio;
    
   
    public List<Trifasico> findAll() {
	return motorRepositorio.findAll();
    }
    public Trifasico CargarMotor(Trifasico mono){
   
	return motorRepositorio.save(mono);
    }  
}
