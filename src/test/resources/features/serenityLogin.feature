Feature: login test

  Scenario Outline: testing the successful login
    Given el usuario abre la pagina de google
    When intenta buscar en google "<palabraBusqueda>"
    #Then validate the text on screen <message>
    #Then debería ver sugerencias de búsqueda relacionadas con "<palabraBusqueda>"
    #And valida que la palabra aparezca en el primer resultado de búsqueda
    Examples:
      | palabraBusqueda  | message   |
      | Choucair | prueba exitosa |

