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
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepositorio;

    public Cliente registrarUsuario(Cliente cliente) throws Exception {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        cliente.setPassword(encoder.encode("1234"));

        cliente.setRol(Rol.USUARIO);
        cliente = clienteRepositorio.save(cliente);
        return cliente;

    }

    public Cliente buscarPorId(String id) {
        return clienteRepositorio.getById(id);
    }

}
