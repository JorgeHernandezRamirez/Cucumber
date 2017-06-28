package com.jorgehernandezramirez.bdd.cucumber.dto;

import java.util.Date;

public class UserDto {

    private String id;

    private String nombre;

    private String rol;

    private Double salario;

    public UserDto(){
        super();
    }

    public UserDto(String id, String nombre, String rol, Double salario) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.salario = salario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;

        if (id != null ? !id.equals(userDto.id) : userDto.id != null) return false;
        if (nombre != null ? !nombre.equals(userDto.nombre) : userDto.nombre != null) return false;
        if (rol != null ? !rol.equals(userDto.rol) : userDto.rol != null) return false;
        return salario != null ? salario.equals(userDto.salario) : userDto.salario == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (rol != null ? rol.hashCode() : 0);
        result = 31 * result + (salario != null ? salario.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", rol='" + rol + '\'' +
                ", salario=" + salario +
                '}';
    }
}
