# language: en
Feature: Validar senha
    O sistema valida a senha digitada
    se sao numeros e o tamanho e igual a 6
    para evitar que o usuario entre com um valor invalido

    Scenario Outline: Validar se e numero
      Given que a porta esta fechada e travada
      And eu entrei com a senha <senha>
      When o sistema verifica a senha
      Then o resultado deve ser <res>

      Examples: 
            | senha     | res     |
            | "123"     | "true"  |
            | "1234444" | "true"  |
            | ""        | "false" |
            | "123aaaa" | "false" |

    Scenario Outline: Validar se eh valido
        Given que a porta esta fechada e travada
        And eu entrei com a senha <senha>
        When o sistema verifica se eh valido
        Then o resultado deve ser <res>

        Examples:
            |senha      |res        |
            |"123456"   |"true"     |
            |"12"       |"false"    |
            |"1234"     |"false"    |
            |""         |"false"    | 