package bobinator.bobinados.Controller;

import bobinator.bobinados.Entity.Usuario;
import bobinator.bobinados.Enum.Rol;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author groxa
 */
@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping("")
    public String index(HttpSession sesion){
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        if (usuario != null) {
            if (usuario.getRol().equals(Rol.TALLER)) {
                return "redirect:/taller";
            } else if (usuario.getRol().equals(Rol.USUARIO)) {
                 return "redirect:/cliente";
            } else if (usuario.getRol().equals(Rol.ADMIN)) {
                 return "redirect:/administrador";
            }
        }
    return "index";
    }
}


