/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobinator.bobinados.Service;
import bobinator.bobinados.Entity.Motor;
import bobinator.bobinados.Repository.MotorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author groxa
 */
@Service
public class MotorService {

    @Autowired
    private MotorRepository motorRepositorio;

     
}


