package bobinator.bobinados.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicioBobinado")
public class InicioController {

    @GetMapping("")
    public String bobinadoInicio() {
    return "inicioBobinado";
    }
}
