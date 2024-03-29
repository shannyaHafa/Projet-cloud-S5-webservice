package com.example.springboot;

import classes.springboot.Utilisateur;
import classes.springboot.HttpRetour;
import classes.springboot.Token;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import services.springboot.ServiceUtilisateur;

@RestController
public class HelloController {
    private Token token = new Token();
    ServiceUtilisateur s = new ServiceUtilisateur();
    
    @CrossOrigin(origins = "*")
    @PostMapping("/Inscription")
    public HttpRetour inscription(@RequestBody Utilisateur user) throws Exception {
        HttpRetour inscription = s.inscription(user.getLogin(), user.getPwd());
        return inscription;
    }
    
    /* CONNECTION */
    @CrossOrigin(origins = "*")
    @PostMapping("/Connection")
    public HttpRetour connection(@RequestBody Utilisateur user) throws Exception {
        HttpRetour connection = s.connection(user.getLogin(), user.getPwd());
        return connection;
    }
    
    /* DECONNECTION */
    @CrossOrigin(origins = "*")
    @GetMapping("/Deconnection")
    public HttpRetour deconnection(@RequestHeader(name = "Authorization") String token) throws Exception {
        String realToken = token.substring(7, token.length());
        HttpRetour deconnection = s.deconnection(realToken);
        return deconnection;
    }
}
