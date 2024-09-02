package com.gestor.inventario.controllers;

import com.gestor.inventario.models.Users;
import com.gestor.inventario.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("/todos")
    public List<Users> users(){
        return usersService.getAllUsers();
    }

    @GetMapping("/usuario/{id}")
    public Users getUser(@PathVariable Long id){
        return usersService.getUsersById(id);
    }

    @PostMapping("/guardar")
    public Users saveUser(@RequestBody Users users){
        return usersService.createUsers(users);
    }

    @PutMapping("/actualizar/{id}")
    public Users updateUsers(@RequestBody Users users, @PathVariable Long id){
        return usersService.updateUser(users, id);
    }

    @DeleteMapping("/eliminar/{id}")
    public void deleteUsers(@PathVariable Long id){
        usersService.deleteUser(id);
    }
}
