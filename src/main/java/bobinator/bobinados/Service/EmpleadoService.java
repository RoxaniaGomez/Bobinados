package bobinator.bobinados.Service;

import bobinator.bobinados.Entity.Empleado;
import bobinator.bobinados.Enum.Rol;
import bobinator.bobinados.Repository.EmpleadoRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    
public Empleado registrarUsuario(String name,String username,String usuario, String password, String password2) throws Exception {
	Empleado empleado = empleadoRepository.findByUsername(username);

	if (username.isEmpty()) {
	    throw new Exception("El username no puede estar vacio");
	}
	if (empleado != null) {
	    throw new Exception("El usuario ya existe, pruebe otro nombre");
	}
	if (password.isEmpty()) {
	    throw new Exception("La contraseña no puede estar vacia");
	}
	if (password2.isEmpty()) {
	    throw new Exception("La contraseña no puede estar vacia");
	}
	if (!password.equals(password2)) {
	    throw new Exception("Las contraseñas ingresadas deben ser iguales");

	}
	empleado = new Empleado();
	empleado.setName(name);
        empleado.setUsername(username);
        empleado.setNameTaller(usuario);
        
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	empleado.setPassword(encoder.encode(password));
	empleado.setRol(Rol.TALLER);
        empleado=empleadoRepository.save(empleado);
//        if(isCliente){
//        clienteServicio.crearCliente();
//        }else{
//        
//        }
	return empleado;
    }  
  public Empleado buscarPorId(String id) {
	return empleadoRepository.getById(id);
    }
      public Empleado buscarPorUsername(String username) {
	return empleadoRepository.findByUsername(username);
    } 
}

//    public MotorTrifasico guardarDatos(MotorTrifasico motor) throws Exception {
//	if (motor.getNumeroPolo()==null) {
//	    throw new Exception("El campo no puede estar vacio");
//	}
//	return empleadoRepository.save(motor);
//    }
//    
//       public MotorTrifasico guardarDatos1(MotorTrifasico motor) throws Exception {
//	if (motor.getAlambre()==null) {
//	    throw new Exception("El campo no puede estar vacio");
//	}
//	return empleadoRepository.save(motor);
//    }
//
//    public MotorTrifasico modificarDatos(MotorTrifasico datos, Integer nombre) throws Exception {
//	if (nombre == null) {
//	    throw new Exception("El campo no puede estar vacio");
//	}
//	datos.setNumeroPolo(nombre);
//	return empleadoRepository.save(datos);
//    }
//
//    public MotorTrifasico darBaja(MotorTrifasico autor) {
//	autor.setAlta(false);
//	return empleadoRepository.save(autor);
//    }
//
//    public List<MotorTrifasico> listarDatosl() {
//	return empleadoRepository.findAll();
//    }
//
////    public MotorTrifasico buscarPorNombre(String nombre) {
////	return empleadoRepository.buscarDatosPorNombre(nombre);
////    }
//
//
//    public void borrarDatos(String id) throws Error {
//	Optional<MotorTrifasico> respuesta = empleadoRepository.findById(id);
//	if (respuesta.isPresent()) {
//	    MotorTrifasico motor = respuesta.get();
//	    motor.setAlta(false); //Boolean alta = isAlta, no getAlta
//	    empleadoRepository.save(motor);
//	} else {
//	    throw new Error("No se encontraron datos con ese nombre");
//	}
//    }
//
//    public void altaDatos(String id) throws Error {
//	Optional<MotorTrifasico> respuesta = empleadoRepository.findById(id);
//	if (respuesta.isPresent()) {
//	    MotorTrifasico datos = respuesta.get();
//	    datos.setAlta(true);
//	    empleadoRepository.save(datos);
//	} else {
//	    throw new Error("No se encontraron datos con ese nombre");
//	}
//    }
//
//    public void eliminarDatos(String id) throws Error {
//	MotorTrifasico datos = empleadoRepository.getById(id);
//	if (datos == null) {
//	    throw new Error("Los datos no existen en la base de datos");
//	} else {
//	    empleadoRepository.delete(datos);
//	}
//    }
