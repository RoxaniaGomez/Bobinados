package bobinator.bobinados.Repository;

import bobinator.bobinados.Entity.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String>{
   
}
