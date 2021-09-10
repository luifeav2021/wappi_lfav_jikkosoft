@TC
Feature: Profile Update Wappi
  La empresa Wappi está desarrollando una aplicación que se encarga del delivery de comidas
  Desea automatizar
  Con la finalidad de verificar su constante y correcto funcionamiento

  @TCTodos @ProfileTC01
  Scenario Outline: Actualización de información dentro del perfil.

    Given que se carga la página wappi
    When se inicia sesión con el usuario <userName> y la contraseña <password>
    And ingresa a la opción perfil para actualizar información con los siguientes datos <name> y <lastName> y <dateBirth> y <country> y <gender>
    Then se muestra en pantalla título <firstTitle>

    Examples:
      | userName | password | firstTitle | name   | lastName | dateBirth  | country   | gender    |
      | qwerty   | 12345678 | Ofertas    | Carlos | Perez    | 10/09/1989 | Argentina | Masculino |