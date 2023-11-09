package co.edu.escuelaing.cvds.project.repository;
import co.edu.escuelaing.cvds.project.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<user, Long> {

    user findByUsername(String username);

}