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
    List<UserDto> obtenerUsuarios();

    /**
     * Método que devuelve un usuario del sistema
     * @param id
     * @return
     */
    UserDto obtenerUsuario(String id);

    /**
     * Método que guarda un usuario en el sistema
     * @param userDto
     */
    void guardarUsuario(UserDto userDto);

    /**
     * Método que actualiza un usuario en el sistema
     * @param userDto
     */
    void actualizarUsuario(UserDto userDto);
}
