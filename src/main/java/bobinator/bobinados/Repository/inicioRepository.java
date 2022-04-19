//package bobinator.bobinados.Repository;
//
//import bobinator.bobinados.Entity.MotorTrifasico;
//import bobinator.bobinados.Entity.Usuario;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface inicioRepository extends JpaRepository<MotorTrifasico, String> {
//
//    @Query("Select u from MotorTrifasico u where u.username = :pepe")
//    public MotorTrifasico buscarUsuarioPorUsername(@Param("pepe") String MotorTrifasico);
//}
