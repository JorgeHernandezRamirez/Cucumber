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
    public List<UserDto> getUsers() {
        return USERS;
    }

    @Override
    public UserDto getUser(final String id) {
        final Optional<UserDto> userDtoOptional = USERS.stream().filter(userDto -> id.equals(userDto.getId())).findFirst();
        if(userDtoOptional.isPresent()){
            return userDtoOptional.get();
        }
        return null;
    }

    @Override
    public void save(UserDto userDto) {
        if(!userExists(userDto.getId())) {
            USERS.add(userDto);
        }
    }

    @Override
    public void update(final UserDto userDto) {
        final UserDto userToUpdate = getUser(userDto.getId());
        if(userToUpdate != null){
            userToUpdate.setName(userDto.getName());
            userToUpdate.setSalary(userDto.getSalary());
        }
    }

    private Boolean userExists(final String id){
        return getUser(id) != null;
    }
}
