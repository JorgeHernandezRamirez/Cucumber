package com.jorgehernandezramirez.bdd.cucumber.service;

import com.jorgehernandezramirez.bdd.cucumber.dto.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemmoryUserService implements IUserService {

    private static final List<UserDto> USERS = new ArrayList<UserDto>();

    public InMemmoryUserService(){
        super();
    }

    @Override
    public List<UserDto> obtenerUsuarios() {
        return USERS;
    }

    @Override
    public UserDto obtenerUsuario(final String id) {
        final Optional<UserDto> userDtoOptional = USERS.stream().filter(userDto -> id.equals(userDto.getId())).findFirst();
        if(userDtoOptional.isPresent()){
            return userDtoOptional.get();
        }
        return null;
    }

    @Override
    public void guardarUsuario(UserDto userDto) {
        if(!existeUsuario(userDto.getId())) {
            USERS.add(userDto);
        }
    }

    @Override
    public void actualizarUsuario(final UserDto userDto) {
        final UserDto usuarioAActualizar = obtenerUsuario(userDto.getId());
        if(usuarioAActualizar != null){
            usuarioAActualizar.setNombre(userDto.getNombre());
            usuarioAActualizar.setSalario(userDto.getSalario());
        }
    }

    private Boolean existeUsuario(final String id){
        return obtenerUsuario(id) != null;
    }
}
