package com.system.draughts.domain.employee;

import com.system.draughts.domain.address.Address;
import com.system.draughts.domain.person.Person;
import com.system.draughts.domain.phone.Phone;
import com.system.draughts.enums.SexType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

public class Employee extends Person {

    public Employee() {
    }

    public Employee(Long id, String name, Date birthdayDate, SexType sexType, String email, String password, String cpf, String rg, Address address, Phone phone) {
        super(id, name, birthdayDate, sexType, email, password, cpf, rg, address, phone);
    }
}
