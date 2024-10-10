package com.system.draughts.services;

import com.system.draughts.domain.employee.Employee;
import com.system.draughts.domain.employee.EmployeeRequestDTO;
import com.system.draughts.domain.employee.EmployeeResponseDTO;
import com.system.draughts.domain.player.Player;
import com.system.draughts.domain.player.PlayerRequestDTO;
import com.system.draughts.domain.player.PlayerResponseDTO;
import com.system.draughts.exceptions.EntityNotFoundException;
import com.system.draughts.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository){
        this.repository = repository;
    }

    //CREATE
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto){

        Employee employee = new Employee();

        employee.setName(dto.getName());
        employee.setBirthdayDate(dto.getBirthdayDate());
        employee.setSexType(dto.getSexType());
        employee.setEmail(dto.getEmail());
        employee.setPassword(dto.getPassword());
        employee.setCpf(dto.getCpf());

        var employeeSaved = repository.save(employee);
        return new EmployeeResponseDTO(employeeSaved);
    }

    //FIND_BY_ID
    @Transactional(readOnly = true)
    public EmployeeResponseDTO findEmployeeById(Long id) throws EntityNotFoundException {
        Employee employee = (Employee) repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee was not found!"));
        return new EmployeeResponseDTO(employee);
    }

    //UPDATE
    public EmployeeResponseDTO updateEmployee(Long id, Employee employee){
//        ADD CODE HERE
        return null;
    }

    //DELETE
    @Transactional
    public void deleteEmployee (Long id){
        repository.deleteById(id);
    }

    //CREATE
    public PlayerResponseDTO createPlayer(PlayerRequestDTO dto){

        Player player = new Player();

        player.setName(dto.getName());
        player.setBirthdayDate(dto.getBirthdayDate());
        player.setSexType(dto.getSexType());
        player.setEmail(dto.getEmail());
        player.setPassword(dto.getPassword());
        player.setCpf(dto.getCpf());

        var playerSaved = repository.save(player);
        return new PlayerResponseDTO(playerSaved);
    }

    //FIND_BY_ID
    @Transactional(readOnly = true)
    public PlayerResponseDTO findPlayerById(Long id) throws EntityNotFoundException {
        Player player = (Player) repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Player was not found!"));
        return new PlayerResponseDTO(player);
    }

    //UPDATE
    public PlayerResponseDTO updatePlayer(Long id, Player player){
//        ADD CODE HERE
        return null;
    }

    //DELETE
    @Transactional
    public void deletePlayer(Long id){
        repository.deleteById(id);
    }

}
