package bobinator.bobinados.Controller;

import bobinator.bobinados.Entity.Proyecto;
import bobinator.bobinados.Entity.Usuario;
import bobinator.bobinados.Service.ClienteService;
import bobinator.bobinados.Service.ProyectoService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ProyectoService proyectoService;

    @Autowired
    ClienteService clienteService;

    @PreAuthorize("hasAnyRole('ROLE_USUARIO')")
    @GetMapping("")
    public String index(Model modelo, @ModelAttribute("proyecto") Proyecto proyecto, HttpSession httpSession) {
        
        Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
        proyecto.setCliente(clienteService.buscarPorId(usuario.getId()));
         List<Proyecto> presupuesto = proyectoService.listarProyectos();
        return "cliente";
    }

}
