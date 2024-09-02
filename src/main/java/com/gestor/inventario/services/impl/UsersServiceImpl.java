package com.gestor.inventario.services.impl;

import com.gestor.inventario.models.Users;
import com.gestor.inventario.repositories.UsersRepository;
import com.gestor.inventario.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    public Users getUsersById(Long id){
        Optional<Users> users = usersRepository.findById(id);
        if (users.isEmpty()){
            try {
                throw new Exception("Error");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return users.get();
    }

    public Users createUsers(Users users){
        return usersRepository.save(users);
    }

    public Users updateUser(Users users, Long id){
        Users existUser = usersRepository.findById(id).map(usuario ->{
            usuario.setUserName(users.getUserName());
            usuario.setPassword(users.getPassword());
            usuario.setLastName(users.getLastName());
            usuario.setPhoneNumber(users.getPhoneNumber());
            usuario.setEmail(users.getEmail());
            usuario.setRol(users.getRol());
            return usersRepository.save(usuario);
        }).orElseGet(()->usersRepository.save(users));

        return existUser;
    }

    public void deleteUser(Long id){
        usersRepository.deleteById(id);
    }
}
