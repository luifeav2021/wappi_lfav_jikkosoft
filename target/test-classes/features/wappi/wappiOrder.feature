# language: es
@TCOrder
Característica: Pedir una orden con y sin el cupón de bienvenida Wappi
  La empresa Wappi está desarrollando una aplicación que se encarga del delivery de comidas
  Desea automatizar
  Con la finalidad de verificar su constante y correcto funcionamiento

  @TCOrder @TC_Order_HP01
  Esquema del escenario: Registrar una orden sin el cupón de bienvenida.

    Dado Luisa inicia sesión en la página de wappi con las credenciales <userName> y <password>
    Cuando Luisa confirma un pedido de <article> sin el cupón
    Entonces ella puede ver un mensaje en modal que dice <message>
    Y Luisa observa su pedido en el listado mis pedidos

    Ejemplos:
      | userName | password | article           | message                      |
      | qwerty   | 12345678 | Pan tajado        | Tu pedido ha sido confirmado |
      | qwerty   | 12345678 | Aceite de Girasol | Tu pedido ha sido confirmado |
      | qwerty   | 12345678 | Jamón Premium     | Tu pedido ha sido confirmado |

  @TCOrder @TC_Order_HP02
  Esquema del escenario: Registrar una orden con el cupón de bienvenida.

    Dado Luisa inicia sesión en la página de wappi con las credenciales <userName> y <password>
    Y Luisa obtiene el código del cupón
    Cuando Luisa confirma un pedido de <article> con el cupón
    Entonces ella puede ver un mensaje en modal que dice <message>
    Y Luisa observa su pedido en el listado mis pedidos

    Ejemplos:
      | userName | password | article           | message                      |
      | qwerty   | 12345678 | Pan tajado        | Tu pedido ha sido confirmado |
      | qwerty   | 12345678 | Aceite de Girasol | Tu pedido ha sido confirmado |
      | qwerty   | 12345678 | Jamón Premium     | Tu pedido ha sido confirmado |

  @TCOrder @TC_Order_AP01
  Esquema del escenario: Validación de mensaje de error en cupón inválido.

    Dado Luisa inicia sesión en la página de wappi con las credenciales <userName> y <password>
    Cuando Luisa elije pedir <article> ingresando cupón <coupon> inválido
    Entonces Luisa ve en pantalla mensaje de error <message>

    Ejemplos:
      | userName | password | article           | message        | coupon     |
      | qwerty   | 12345678 | Pan tajado        | Cupón inválido | fdsjfjjksd |
      | qwerty   | 12345678 | Jamón Premium     | Cupón inválido | 11jj44     |
      | qwerty   | 12345678 | Aceite de Girasol | Cupón inválido | asdqwe     |

  @TCOrder @TC_Order_AP02
  Esquema del escenario: Validación de mensaje de error en cupón inválido al utilizarlo más de dos veces.

    Dado Luisa inicia sesión en la página de wappi con las credenciales <userName> y <password>
    Y Luisa obtiene el código del cupón
    Cuando Luisa confirma más de dos veces un pedido de <article> con el cupón
    Entonces Luisa ve en pantalla mensaje de error <message>

    Ejemplos:
      | userName | password | article           | message        |
      | qwerty   | 12345678 | Pan tajado        | Cupón inválido |
      | qwerty   | 12345678 | Jamón Premium     | Cupón inválido |
      | qwerty   | 12345678 | Aceite de Girasol | Cupón inválido |
