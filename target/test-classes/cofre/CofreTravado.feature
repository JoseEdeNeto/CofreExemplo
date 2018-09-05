# language: en
Feature: Acoes com o cofre travado
    Como um usuario
    desejo realizar as acoes como destravar o cofre
    para pegar meus objetos

    Scenario: Digitar senha errada
        Given dado que a porta esta fechada e travado com a senha
        And apertar 1
        And apertar 2
        And apertar 3
        And apertar 4
        And apertar 5
        And apertar 5
        When eu apertar ok
        Then deve ser mostrado no display "senha errada. Tente novamente"

    Scenario: Digitar senha menor que seis numeros
        Given dado que a porta esta fechada e travado com a senha
        And apertar 1
        And apertar 3
        And apertar 2
        And apertar 5
        When eu apertar ok
        Then deve ser mostrado no display "senha errada. Tente novamente"

    Scenario: Digitar senha correta
        Given dado que a porta esta fechada e travado com a senha
        And apertar 1
        And apertar 2
        And apertar 3
        And apertar 4
        And apertar 5
        And apertar 6
        When eu apertar ok
        Then deve ser mostrado no display "senha correta. Cofre aberto"
