/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobinator.bobinados.Service;

import bobinator.bobinados.Entity.Monofasico;
import bobinator.bobinados.Entity.Motor;
import bobinator.bobinados.Repository.MonofasicoRepository;
import bobinator.bobinados.Repository.MotorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    
   
    public List<Motor> findAll() {
	return motorRepositorio.findAll();
    }
    
     
}

