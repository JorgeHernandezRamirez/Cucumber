package com.jorgehernandezramirez.bdd.cucumber.steps;

import com.jorgehernandezramirez.bdd.cucumber.configuration.UserConfiguration;
import com.jorgehernandezramirez.bdd.cucumber.dto.UserDto;
import com.jorgehernandezramirez.bdd.cucumber.service.IUserService;
import com.jorgehernandezramirez.bdd.cucumber.service.InMemmoryUserService;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = UserConfiguration.class)
public class FilterUserSteps {

    private IUserService userService = new InMemmoryUserService();

    private List<UserDto> usersWithRolUser;

    @When("^se obtiene los usuarios con rol (.*)")
    public void debeObtenerTodosLosUsuariosConRol(final String rol){
        usersWithRolUser = userService.getUsers().stream().filter(userDto -> rol.equals(userDto.getRol())).collect(Collectors.toList());
    }

    @Then("^el número de usuarios obtenidos es (\\d+)")
    public void debeValidarElNumeroDeUsuariosObtenidos(final Integer numeroDeUsuarios) {
        assertEquals(Integer.valueOf(usersWithRolUser.size()),
                Integer.valueOf(numeroDeUsuarios));
    }
}
