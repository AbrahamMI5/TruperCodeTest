package com.example.Truper.Controller;

import com.example.Truper.Model.DTO.AuthenticationRequest;
import com.example.Truper.Model.DTO.ResponseRequest;
import com.example.Truper.Segurity.JwtService;
import com.example.Truper.Segurity.UserDetailServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    private static final Logger log = LogManager.getLogger(AuthController.class);
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    private JwtService jwtService;

    @PostMapping
    public ResponseEntity<ResponseRequest> createToken(@RequestBody AuthenticationRequest request) {
        try{
            //TODO: Obtener datos de la bd, comprar la contraseña contra la que tenemos guardad con el usuario
            if(!request.getUser().equals("admin") && !request.getPassword().equals("admin")){
               throw new RuntimeException();
            }
        }catch(Exception e){
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        final UserDetails userDetails = userDetailService.loadUserByUsername(request.getUser());
        final String token = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(new ResponseRequest(token));
    }
}
