package bobinator.bobinados.Controller;

import bobinator.bobinados.Entity.MotorTrifasico;
import bobinator.bobinados.Service.EmpleadoService;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("")
    public String formulario(Model modelo) {
	MotorTrifasico datos = new MotorTrifasico();
	modelo.addAttribute("datos", datos);
	return "empleadoBobinado"; //Html
    }

    @GetMapping("/modificar")
    public String formulario(@RequestParam(name = "id", required = true) String id, Model modelo, @RequestParam("archivo") MultipartFile archivo) {
	MotorTrifasico datos = empleadoService.buscarPorId(id);
	modelo.addAttribute("datos", datos);
	return "empleadoBobinado";
    }

    @PostMapping("/save")
    public String formularioData(@RequestParam("nombre") Integer nombre,@RequestParam("id") String id,
	    Model modelo, @RequestParam(name = "archivo", required = false) MultipartFile archivo, @RequestParam(name = "modificar", required = false) String modificar) {
	MotorTrifasico datos = new MotorTrifasico();
	try {
	    datos.setNumeroPolo(nombre);
	    try {
		byte[] bytes = archivo.getBytes();
		Files.write(Paths.get("C:\\Users\\54381\\Desktop\\Diseño Web\\Libreriaaa\\upload\\" + archivo.getOriginalFilename()), bytes, StandardOpenOption.CREATE);
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    datos.setId(id);
	    datos.setAlta(true);
	    empleadoService.guardarDatos(datos);
	    modelo.addAttribute("autor", datos);
	    if (modificar != null) {
		return "redirect:/empleadoBobinado/list";
	    }
	    return "empleadoBobinado";
	} catch (Exception ex) {
	    ex.printStackTrace();
	    modelo.addAttribute("datos", datos);
	    modelo.addAttribute("error", ex.getMessage());
	    return "empleadoBobinado";
	}
    }

    @GetMapping("/list")
    public String listAll(Model modelo) {
	List<MotorTrifasico> datos = empleadoService.listarDatosl();
	modelo.addAttribute("listaDeDatos", datos);
	return "datos-listar";
    }

    @GetMapping("/alta")
    public String alta(@RequestParam("id") String id) {
	try {
	    empleadoService.altaDatos(id);
	    return "redirect:/empleadoBobinado/list";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:/empleadoBobinado/list";
	}
    }

    @GetMapping("/delete") //Baja
    public String delete(@RequestParam("id") String id) {
	try {
	    empleadoService.borrarDatos(id);
	    return "redirect:/empleadoBobinado/list";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:/empleadoBobinado/list";
	}
    }

    @GetMapping("/eliminar")
    public String eliminarAutor(@RequestParam("id") String id) {
	try {
	    empleadoService.eliminarDatos(id);
	    return "redirect:/empleadoBobinado/list";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:/empleadoBobinado/list";
	}
    }
}
