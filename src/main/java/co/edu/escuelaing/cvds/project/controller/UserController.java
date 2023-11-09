package co.edu.escuelaing.cvds.project.controller;
import co.edu.escuelaing.cvds.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import javax.servlet.http.HttpSession; importante

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("login"); // Esta es la página de inicio de sesión
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String username, @RequestParam String password) {
        String role = userService.login(username, password);

        if (role != null) {
           

            if (role.equals("ADMINISTRADOR")) {
                return new ModelAndView("redirect:/index"); // Redirigir a la página de administrador
            } else if (role.equals("CLIENTE")) {
                return new ModelAndView("redirect:/pagecliente"); // Redirigir a la página de cliente
            }
        }

        return new ModelAndView("login-failed"); // En caso de credenciales incorrectas, redirigir a una página de inicio de sesión nuevamente
    }

    //modificar para el cliente 
    @RequestMapping("/pagecliente")
    public ModelAndView employeePage() {
        return new ModelAndView("pagecliente"); // Página de empleado
    }
}
