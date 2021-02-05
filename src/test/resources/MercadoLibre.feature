Feature: Funcionalidad búsqueda productos

  Validar que se permita consultar un producto y realizra filtros

  Scenario Outline: Busqueda de producto y filtros

    Given Ingresar a la pagina de Mercado Libre satisfactoriamente
    When Seleccionar país México
    And Buscar producto "<producto>"
    And filtrar por condición "<condicion>" y ubicación "<ubicacion>"
    And Ordenar de Mayor a Menor precio
    Then imprimir productos "<numProdImprimir>"

    Examples:
    |producto     |condicion|ubicacion       |numProdImprimir|
    |playstation 4|Nuevo    |Distrito Federal|5              |



