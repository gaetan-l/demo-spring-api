package gaetanl.demo.springapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class ApiController {
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public ResponseEntity<String> getUsers() {
        System.out.println("ApiController.getUsers()");
        return new ResponseEntity<String>("ApiController.getUsers() response", HttpStatus.OK);
    }
}
