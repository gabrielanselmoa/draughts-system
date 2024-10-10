package com.system.draughts.domain.player;

import com.system.draughts.domain.address.Address;
import com.system.draughts.domain.person.Person;
import com.system.draughts.domain.phone.Phone;
import com.system.draughts.enums.SexType;

import java.util.Date;

public class Player extends Person {

    public Player() {
    }

    public Player(Long id, String name, Date birthdayDate, SexType sexType, String email, String password, String cpf, String rg, Address address, Phone phone) {
        super(id, name, birthdayDate, sexType, email, password, cpf, rg, address, phone);
    }
}
