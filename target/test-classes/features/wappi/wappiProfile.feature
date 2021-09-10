# language: es
@TCProfile
Característica: Actualización de información dentro del perfil Wappi
  La empresa Wappi está desarrollando una aplicación que se encarga del delivery de comidas
  Desea automatizar
  Con la finalidad de verificar su constante y correcto funcionamiento

  @TCProfile   @TC_Profile_HP01
  Esquema del escenario: Actualizar de información dentro del perfil.

    Dado Luisa inicia sesión en la página de wappi con las credenciales <userName> y <password>
    Y Luisa ingresa a la opción Información Personal del menú
    Cuando ella ingresa los siguientes datos en el formulario <name> y <lastName> y <dateBirth> y <country> y <gender>
    Entonces Luisa puede ver el mensaje <message>

    Ejemplos:
      | userName | password | name  | lastName | dateBirth  | country  | gender    | message                                |
      | qwerty   | 12345678 | Jorge | Perez    | 12/02/1995 | Colombia | Masculino | Tu información se guardó correctamente |

  @TCProfile   @TC_Profile_AP01
  Esquema del escenario: Verificar mensaje de obligatorio en campos de formulario de actualización de perfil

    Dado Luisa inicia sesión en la página de wappi con las credenciales <userName> y <password>
    Y Luisa ingresa a la opción Información Personal del menú
    Cuando ella ingresa los siguientes datos en el formulario <name> y <lastName> y <dateBirth> y <country> y <gender>
    Entonces Luisa observa el mensaje <message> como error en campo <field>

    Ejemplos:
      | userName | password | name  | lastName | dateBirth  | country     | gender    | field      | message                             |
      | qwerty   | 12345678 |       | Perez    | 12/02/1995 | Colombia    | Masculino | nombre     | El nombre es requerido              |
      | qwerty   | 12345678 | Jorge |          | 12/02/1995 | Colombia    | Masculino | apellido   | El apellido es requerido            |
      | qwerty   | 12345678 | Jorge | Perez    |            | Colombia    | Masculino | nacimiento | La fecha de nacimiento es requerida |
      | qwerty   | 12345678 | Jorge | Perez    | 12/02/1995 | Seleccionar | Masculino | país       | El país es requerido                |
