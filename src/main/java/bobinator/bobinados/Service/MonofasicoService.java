/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobinator.bobinados.Service;

import bobinator.bobinados.Entity.Empleado;
import bobinator.bobinados.Entity.Monofasico;
import bobinator.bobinados.Entity.Motor;
import bobinator.bobinados.Enum.Rol;
import bobinator.bobinados.Repository.MonofasicoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

/**
 *
 * @author groxa
 */
@Service
public class MonofasicoService {

    @Autowired
    private MonofasicoRepository motorRepositorio;
    
   
    public List<Monofasico> findAll() {
	return motorRepositorio.findAll();
    }
    public Monofasico CargarMotor(Monofasico mono){
   
	return motorRepositorio.save(mono);
    }  

     
        
  
}

