@TC
Feature: Login Wappi
  La empresa Wappi está desarrollando una aplicación que se encarga del delivery de comidas
  Desea automatizar
  Con la finalidad de verificar su constante y correcto funcionamiento

  @TCTodos @TC01
  Scenario Outline: Login y sign-out.

    Given que se carga la página wappi
    When se inicia sesión con el usuario <userName> y la contraseña <password>
    Then se muestra en pantalla título <firstTitle>
    And después de cerrar sesión se muestra en pantalla el título <secondTitle>

    Examples:
      | userName  | password | firstTitle | secondTitle |
      | qwerty    | 12345678 | Ofertas    | Bienvenido  |
      | asdfghjkl | 12345678 | Ofertas    | Bienvenido  |

  @TCTodos @TC02
  Scenario Outline: Login y sign-out password fails.

    Given que se carga la página wappi
    When se inicia sesión con el usuario <userName> y la contraseña <password>
    Then se muestra en pantalla mensaje de error en contraseña <errorMessage>

    Examples:
      | userName | password        | errorMessage                                        |
      | qwerty   | 1234567         | La contraseña debe contener entre 8 y 14 caracteres |
      | qwerty   | 123456789012345 | La contraseña debe contener entre 8 y 14 caracteres |

  @TCTodos @TC03
  Scenario Outline: Login y sign-out userName fails.

    Given que se carga la página wappi
    When se inicia sesión con el usuario <userName> y la contraseña <password>
    Then se muestra en pantalla mensaje de error en usuario <errorMessage>

    Examples:
      | userName              | password | errorMessage                                     |
      | qwert                 | 12345678 | El usuario debe contener entre 6 y 20 caracteres |
      | qwertyuiopasdfghjklmz | 12345678 | El usuario debe contener entre 6 y 20 caracteres |

  @TCTodos @TC04
  Scenario Outline: El usuario debe ser alfanumérico.

    Given que se carga la página wappi
    When se inicia sesión con el usuario <userName> y la contraseña <password>
    Then se muestra en pantalla mensaje de error en usuario <errorMessage>

    Examples:
      | userName | password | errorMessage                     |
      | qwerty+  | 12345678 | El usuario debe ser alfanumérico |
      | qwertyñ  | 12345678 | El usuario debe ser alfanumérico |