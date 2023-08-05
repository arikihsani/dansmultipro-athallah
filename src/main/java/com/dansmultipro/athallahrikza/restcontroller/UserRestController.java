package com.dansmultipro.athallahrikza.restcontroller;


import com.dansmultipro.athallahrikza.dto.LoginDTO;
import com.dansmultipro.athallahrikza.dto.UserDTO;
import com.dansmultipro.athallahrikza.model.UserModel;
import com.dansmultipro.athallahrikza.service.UserService;
import com.dansmultipro.athallahrikza.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserRestController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO user){
        // create simple validation
        // password must not be less than 6 characters
        if (user.getPassword().length()<6){
            return ResponseUtil.failResponse("Password must not be less than 6 characters!");
        }
        UserModel newUser = new UserModel();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser = userService.addUser(newUser);
        // check whether email is already registered or not
        if (newUser==null){
            return ResponseUtil.failResponse("Email already registered!");
        }
        return ResponseUtil.okResponse(newUser, "Registered Successfully!");

    }
    @PostMapping(path = "login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO login){
        UserModel user = userService.findByEmail(login.getEmail());
        // check if email already registered
        if (user==null){
            return ResponseUtil.failResponse("Wrong email!");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean check = passwordEncoder.matches(login.getPassword(), user.getPassword());
        // check if password matches
        if (!check){
            return ResponseUtil.failResponse("Wrong password!");
        }
        return ResponseUtil.okResponse(null, "Login Successful!");
    }
}
