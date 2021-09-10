# language: es
@TCLogin
Característica: Login Wappi
  La empresa Wappi está desarrollando una aplicación que se encarga del delivery de comidas
  Desea automatizar
  Con la finalidad de verificar su constante y correcto funcionamiento

  @TCLogin @TC_Login_HP01
  Esquema del escenario:  Verificar inicio y cierre de sesión.

    Dado que Luisa carga la página wappi
    Cuando Luisa inicia sesión con el usuario <userName> y la contraseña <password>
    Entonces Luisa puede ver en pantalla título <firstTitle>
    Y después de cerrar sesión Luisa ve en pantalla el título <secondTitle>

    Ejemplos:
      | userName  | password | firstTitle | secondTitle |
      | qwerty    | 12345678 | Ofertas    | Bienvenido  |
      | asdfghjkl | 12345678 | Ofertas    | Bienvenido  |

  @TCLogin @TC_Login_AP01
  Esquema del escenario: Verificar mensaje de error en contraseña inválida de inicio de sesión.

    Dado que Luisa carga la página wappi
    Cuando Luisa inicia sesión con el usuario <userName> y la contraseña <password>
    Entonces Luisa puede ver en pantalla mensaje de error en contraseña <errorMessage>

    Ejemplos:
      | userName | password        | errorMessage                                        |
      | qwerty   | 1234567         | La contraseña debe contener entre 8 y 14 caracteres |
      | qwerty   | 123456789012345 | La contraseña debe contener entre 8 y 14 caracteres |

  @TCLogin @TC_Login_AP02
  Esquema del escenario: Verificar mensaje de error en usuario inválida de inicio de sesión.

    Dado que Luisa carga la página wappi
    Cuando Luisa inicia sesión con el usuario <userName> y la contraseña <password>
    Entonces Luisa puede ver en pantalla mensaje de error en usuario <errorMessage>

    Ejemplos:
      | userName              | password | errorMessage                                     |
      | qwert                 | 12345678 | El usuario debe contener entre 6 y 20 caracteres |
      | qwertyuiopasdfghjklmz | 12345678 | El usuario debe contener entre 6 y 20 caracteres |

  @TCLogin @TC_Login_AP03
  Esquema del escenario: Verificación de no ingresar caracteres especiales en usuario.

    Dado que Luisa carga la página wappi
    Cuando Luisa inicia sesión con el usuario <userName> y la contraseña <password>
    Entonces Luisa puede ver en pantalla mensaje de error en usuario <errorMessage>

    Ejemplos:
      | userName | password | errorMessage                     |
      | qwerty+  | 12345678 | El usuario debe ser alfanumérico |
      | qwertyñ  | 12345678 | El usuario debe ser alfanumérico |