package com.jorgehernandezramirez.bdd.cucumber.service;

import com.jorgehernandezramirez.bdd.cucumber.dto.UserDto;

import java.util.List;

/**
 * Api de usuarios
 */
public interface IUserService {

    /**
     * Método que devuelve los usuarios del sistema
     * @return
     */
    List<UserDto> getUsers();

    /**
     * Método que devuelve un usuario del sistema
     * @param id
     * @return
     */
    UserDto getUser(String id);

    /**
     * Método que guarda un usuario en el sistema
     * @param userDto
     */
    void save(UserDto userDto);

    /**
     * Método que actualiza un usuario en el sistema
     * @param userDto
     */
    void update(UserDto userDto);
}
