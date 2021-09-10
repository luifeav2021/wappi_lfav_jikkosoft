@TC
Feature: Profile Update Wappi
  La empresa Wappi está desarrollando una aplicación que se encarga del delivery de comidas
  Desea automatizar
  Con la finalidad de verificar su constante y correcto funcionamiento

  @TCTodos @CouponTC01
  Scenario Outline: Pedir una orden con el cupón de bienvenida.

    Given que se carga la página wappi
    When se inicia sesión con el usuario <userName> y la contraseña <password>
    And obtiene el cupón de bienvenida
    Then se muestra en pantalla título <firstTitle>

    Examples:
      | userName | password | firstTitle | name   | lastName | dateBirth  | country   | gender    |
      | qwerty   | 12345678 | Ofertas    | Carlos | Perez    | 10/09/1989 | Argentina | Masculino |