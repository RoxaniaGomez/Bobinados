package bobinator.bobinados.Controller;

import bobinator.bobinados.Entity.Empleado;
import bobinator.bobinados.Service.ClienteService;
import bobinator.bobinados.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("")
    public String registro(Model modelo) {
        modelo.addAttribute("name", "");
	modelo.addAttribute("username", "");
        modelo.addAttribute("telefono", "");
        modelo.addAttribute("Usuario", "");
	modelo.addAttribute("password", "");
	modelo.addAttribute("password2", "");
	return "usuario-formulario";
    }

//    @PostMapping("/registroCliente")
//    public String registroUsuario(
//            @RequestParam("name") String name,
//            @RequestParam("username") String username,
//            @RequestParam("telefono") String telefono,
//	    @RequestParam("password") String password,
//	    @RequestParam("password2") String password2,
//	    Model modelo) {
//	try {
//	    Cliente cliente = clienteService.registrarUsuario(name,username,telefono, password, password2);
//	    modelo.addAttribute("success", "Usuario registrado con exito");
//	    return "usuario-formulario";
//	} catch (Exception ex) {
//	    ex.printStackTrace();
//	    modelo.addAttribute("username", username);
//	    modelo.addAttribute("password", password);
//	    modelo.addAttribute("password2", password2);
//	    modelo.addAttribute("error", ex.getMessage());
//	    return "usuario-formulario";
//	}
//    }
     @PostMapping("/registroTaller")
    public String registroTaller(
            @RequestParam("name") String name,
            @RequestParam("username") String username,
            @RequestParam("usuario") String usuario,
	    @RequestParam("password") String password,
	    @RequestParam("password2") String password2,
	    Model modelo) {
	try {
	    Empleado empleado = empleadoService.registrarUsuario(name, username,usuario, password, password2);
	    modelo.addAttribute("success", "Usuario registrado con exito");
	    return "usuario-formulario";
	} catch (Exception ex) {
	    ex.printStackTrace();
            modelo.addAttribute("name", name);
	    modelo.addAttribute("username", username);
            modelo.addAttribute("usuario", usuario);
	    modelo.addAttribute("password", password);
	    modelo.addAttribute("password2", password2);
	    modelo.addAttribute("error", ex.getMessage());
	    return "usuario-formulario";
	}
    }

//    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRADOR')")
//    @GetMapping("/lista")
//    public String lista(Model modelo) {
//	List<Usuario> usuarios = usuarioService.findAll();
//	modelo.addAttribute("usuarios", usuarios);
//	return "usuario-lista";
//    }
}

