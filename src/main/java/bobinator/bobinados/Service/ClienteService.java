/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bobinator.bobinados.Service;

import bobinator.bobinados.Entity.Cliente;
import bobinator.bobinados.Enum.Rol;
import bobinator.bobinados.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author groxa
 */
@Service
public class ClienteService{
 @Autowired
    private ClienteRepository clienteRepositorio;

    public Cliente registrarUsuario(String name,String username,Integer telefono, String password, String password2) throws Exception {
	Cliente cliente = clienteRepositorio.findByUsername(username);

	if (username.isEmpty()) {
	    throw new Exception("El username no puede estar vacio");
	}
	if (cliente != null) {
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
	cliente = new Cliente();
	cliente.setName(name);
        cliente.setUsername(username);
        cliente.setTelefono(telefono);
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	cliente.setPassword(encoder.encode(password));
    cliente.setRol(Rol.USUARIO);
        cliente=clienteRepositorio.save(cliente);
//        if(isCliente){
//        clienteServicio.crearCliente();
//        }else{
//        
//        }
	return cliente;
    }  
 
  
}
