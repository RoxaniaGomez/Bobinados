package bobinator.bobinados.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author anaoc
 */
@Controller
@RequestMapping("/editar")
public class EditarPerfilController {
    
    @PreAuthorize("hasAnyRole('ROLE_USUARIO')")
    @GetMapping("")
    public String index() {
        return "editar";
    }
  
}