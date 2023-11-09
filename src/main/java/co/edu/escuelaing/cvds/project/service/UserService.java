package co.edu.escuelaing.cvds.project.service;
import co.edu.escuelaing.cvds.project.model.user;
import co.edu.escuelaing.cvds.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String login(String username, String password) {
        user user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            String role = user.getRol();
            return role; // Retorna el nombre del rol
        }

        return null; // En caso de credenciales incorrectas
    }
}
