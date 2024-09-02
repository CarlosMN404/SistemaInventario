package com.gestor.inventario.services;

import com.gestor.inventario.models.Users;
import java.util.List;

public interface UsersService {

    public List<Users> getAllUsers();

    public Users getUsersById(Long Id);

    public Users createUsers(Users users);

    public Users updateUser(Users users, Long id);

    public void deleteUser(Long id);
}
