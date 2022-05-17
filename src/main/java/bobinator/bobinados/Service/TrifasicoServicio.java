package bobinator.bobinados.Service;

import bobinator.bobinados.Entity.Trifasico;
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
    private TrifasicoRepository trifasicoRepositorio;
    
    public List<Trifasico> findAll() {
	return trifasicoRepositorio.findAll();
    }
    public Trifasico CargarMotor(Trifasico mono){
   
	return trifasicoRepositorio.save(mono);
    }  
}
