package bobinator.bobinados.Service;


import bobinator.bobinados.Entity.Monofasico;
import bobinator.bobinados.Repository.MonofasicoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MonofasicoService {

    @Autowired
    private MonofasicoRepository monofasicoRepository;
    
    public List<Monofasico> findAll() {
	return monofasicoRepository.findAll();
    }
    public Monofasico CargarMotor(Monofasico mono){
   
	return monofasicoRepository.save(mono);
    } 
}

