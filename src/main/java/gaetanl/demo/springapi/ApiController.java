package gaetanl.demo.springapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is where the various paths to the APIs methods are defined. The
 * {@literal @}RequestMapping annotation at class level defines the root of the
 * API and those at method level define the paths to specific functions and the
 * accepted HTTP methods (GET, POST, etc.).
 */
@RestController
@RequestMapping("api/")
public class ApiController {
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public ResponseEntity<String> getUsers() {
        System.out.println("ApiController.getUsers()");
        return new ResponseEntity<String>("ApiController.getUsers() response", HttpStatus.OK);
    }
}
