package com.jorgehernandezramirez.bdd.cucumber.dto;

public class UserDto {

    private String id;

    private String name;

    private String rol;

    private Double salary;

    public UserDto(){
        super();
    }

    public UserDto(String id, String name, String rol, Double salary) {
        this.id = id;
        this.name = name;
        this.rol = rol;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;

        if (id != null ? !id.equals(userDto.id) : userDto.id != null) return false;
        if (name != null ? !name.equals(userDto.name) : userDto.name != null) return false;
        if (rol != null ? !rol.equals(userDto.rol) : userDto.rol != null) return false;
        return salary != null ? salary.equals(userDto.salary) : userDto.salary == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (rol != null ? rol.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", rol='" + rol + '\'' +
                ", salary=" + salary +
                '}';
    }
}
