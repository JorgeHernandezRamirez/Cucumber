Feature: Gestión usuarios

  Scenario: Modificación salario usuario
    Given dado los siguientes usuarios en el sistema
      | id  | nombre      | rol    | salario |
      | 1   | Jorge       | USER   | 18000   |
      | 2   | Jose        | USER   | 20000   |
      | 3   | Admin       | ADMIN  | 40000   |
    When se sube el salario del empleado '1' un 3%
    Then el salario del empleado '1' es 18540

  Scenario: Obtener número de usuarios con rol USER
    Given dado los siguientes usuarios en el sistema
      | id  | nombre      | rol    | salario |
      | 1   | Jorge       | USER   | 18000   |
      | 2   | Jose        | USER   | 20000   |
      | 3   | Admin       | ADMIN  | 40000   |
    When se obtiene los usuarios con rol USER
    Then el número de usuarios obtenidos es 2