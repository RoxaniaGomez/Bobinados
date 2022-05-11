package bobinator.bobinados.Controller;

import bobinator.bobinados.Entity.Calculos;
import bobinator.bobinados.Entity.Cliente;
import bobinator.bobinados.Entity.Monofasico;
import bobinator.bobinados.Entity.Proyecto;
import bobinator.bobinados.Entity.Trifasico;
import bobinator.bobinados.Entity.Usuario;
import bobinator.bobinados.Service.CalculoService;
import bobinator.bobinados.Service.ClienteService;
import bobinator.bobinados.Service.EmpleadoService;
import bobinator.bobinados.Service.MonofasicoService;
import bobinator.bobinados.Service.ProyectoService;
import bobinator.bobinados.Service.TrifasicoServicio;
import java.text.SimpleDateFormat;


import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/taller")
public class TallerController {

    @Autowired
    private ProyectoService proyectoService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private MonofasicoService monofasicoService;
    @Autowired
    private TrifasicoServicio trifasicoService;
    
    @Autowired
    private CalculoService calculoService;
    @Autowired
    private EmpleadoService empleadoService;

    @PreAuthorize("hasAnyRole('ROLE_TALLER')")
    @GetMapping("")
    public String postLogueo(Model modelo) {

        List<Proyecto> proyectos = proyectoService.listarProyectos();
        modelo.addAttribute("lista", proyectos);
        
        Calculos calculo = new Calculos();
        modelo.addAttribute("calculo",calculo);
        Proyecto proyectoTrifasico = new Proyecto();
        proyectoTrifasico.setCliente(new Cliente());
        

        proyectoTrifasico.setMotorTrifasico(new Trifasico());
        modelo.addAttribute("proyectoTrifasico", proyectoTrifasico);

        Proyecto proyectoMonofasico = new Proyecto();
        proyectoMonofasico.setCliente(new Cliente());
        
        proyectoMonofasico.setMotorMonofasico(new Monofasico());
        
        modelo.addAttribute("proyectoMonofasico", proyectoMonofasico);

        return "taller";
    }

    @GetMapping("/form")
    public String registro(Model modelo) {
        modelo.addAttribute("cliente", new Cliente());
        return "taller";
    }

    @PostMapping("/crearProyecto")
    public String CrearProyecto(@ModelAttribute("proyecto") Proyecto proyecto, HttpSession httpSession  ) throws Exception {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
        proyecto.setEmpleado(empleadoService.buscarPorId(usuario.getId()));
        proyecto = proyectoService.crearProyecto(proyecto);
        return "redirect:/taller";
    }

    @GetMapping("/alta")
    public String alta(@RequestParam("id") String id) {
        try {
            proyectoService.darAlta(id);
            return "redirect:/taller";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/taller";
        }
    }

    @GetMapping("/baja")
    public String baja(@RequestParam("id") String id) {
        try {
            proyectoService.darBaja(id);
            return "redirect:/taller";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/taller";
        }
    }
   
    @GetMapping("/calcular")
    public ResponseEntity<Calculos> calcular(@RequestParam("id") String id) {
        try {
          Calculos calculo = proyectoService.calcularProyecto(id);
            return new ResponseEntity<>(calculo,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
     @PostMapping("/presupuesto")
    public String presupuesto(@RequestParam("id") String id,@RequestParam("fecha") String fecha,@RequestParam("presupuesto") Double presupuesto) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
          proyectoService.calcularPresupuestoProyecto(id, format.parse(fecha), presupuesto);
             return "redirect:/taller";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/taller";
            
        }
    }
        
        
    @GetMapping("/ver")
    public String ver(@RequestParam("id") String id) {
        try {
            proyectoService.buscarPorId(id);
            return "redirect:/taller";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/taller";
        }
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") String id) {
        try {
            proyectoService.borrarProyecto(id);
            return "redirect:/taller";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/taller";
        }

}}