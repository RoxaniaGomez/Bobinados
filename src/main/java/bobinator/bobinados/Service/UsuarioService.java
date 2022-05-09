package bobinator.bobinados.Service;


import bobinator.bobinados.Entity.Usuario;
import bobinator.bobinados.Repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepositorio;

    public List<Usuario> findAll() {
	return usuarioRepositorio.findAll();
    }
    
      public void agregarUsuarioALaSesion(Usuario usuario) {
        ServletRequestAttributes attributes  = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attributes.getRequest().getSession(true);
        session.setAttribute("usuario", usuario);
    }

    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	try {
	    Usuario usuario = usuarioRepositorio.findByUsername(username);
	    List<GrantedAuthority> autoritties = new ArrayList<>();
            agregarUsuarioALaSesion(usuario);
	    autoritties.add(new SimpleGrantedAuthority("ROLE_" + usuario.getRol()));
	    return new User(username, usuario.getPassword(), autoritties);
	} catch (Exception e) {
	    throw new UsernameNotFoundException("El usuario no existe");
	}
    }

}
