package com.system.draughts.controllers;

import com.system.draughts.domain.employee.Employee;
import com.system.draughts.domain.player.Player;
import com.system.draughts.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

//    @PostMapping("/employee")
//    public ResponseEntity<Employee> createDoctor(@RequestBody Employee employee){
//        var res = service.createDoctor(employee);
//        return ResponseEntity.status(HttpStatus.CREATED).body(res);
//    }

//    @PostMapping("/player")
//    public ResponseEntity<Player> createPatient(@RequestBody Player player){
//        var res = service.createPlayer(player);
//        return ResponseEntity.status(HttpStatus.CREATED).body(res);
//    }

//    @GetMapping("/employee/{id}")
//    public ResponseEntity<Employee> findById(@PathVariable Long id){
//        var employee = service.findEmployeeById(id);
//        return ResponseEntity.status(HttpStatus.OK).body(employee);
//    }
//
//    @GetMapping("/player/{id}")
//    public ResponseEntity<Employee> findById(@PathVariable Long id){
//        var player = service.findPlayerById(id);
//        return ResponseEntity.status(HttpStatus.OK).body(player);
//    }
}
