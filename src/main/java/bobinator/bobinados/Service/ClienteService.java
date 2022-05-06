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

    public Cliente registrarUsuario(Cliente cliente) throws Exception {
//	 cliente = clienteRepositorio.findByUsername(cliente.getUsername());

//	if (cliente.getUsername().isEmpty()) {
//	    throw new Exception("El username no puede estar vacio");
////	}
	
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
cliente.setPassword(encoder.encode("1234"));

cliente.setRol(Rol.USUARIO);

        cliente=clienteRepositorio.save(cliente);
//      
	return cliente;
        
        
//	}
//	if (password.isEmpty()) {
//	    throw new Exception("La contraseña no puede estar vacia");
//	}
//	if (password2.isEmpty()) {
//	    throw new Exception("La contraseña no puede estar vacia");
//	}
//	if (!password.equals(password2)) {
//	    throw new Exception("Las contraseñas ingresadas deben ser iguales");
//	}
	

    }  
 
  
}
