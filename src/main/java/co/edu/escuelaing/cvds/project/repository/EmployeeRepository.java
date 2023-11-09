package co.edu.escuelaing.cvds.project.repository;
import co.edu.escuelaing.cvds.project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //public List<Employee> findByPropiedad(String propiedad);

}

