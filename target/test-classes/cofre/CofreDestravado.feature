# language: en
Feature: Acoes com o cofre destravado
    Como um usuario
    desejo realizar as acoes como travar o cofre ou fechar e abrir a porta
    para guardar meus objetos

    Scenario: Limpar a tela
        Given dado que a porta esta fechada e destravada
        And digitar 6
        And digitar 7
        When eu pressionar limpar
        Then deve ser exibido no display ""

    Scenario: Digitar a senha com a porta aberta
        Given que a porta esta aberta
        And digitar 1
        And digitar 2
        And digitar 3
        And digitar 4
        And digitar 5
        And digitar 6
        And digitar 7
        And digitar 8
        And digitar 9
        When eu pressionar ok
        Then deve ser exibido no display "Feche a porta antes de digitar a senha"

    Scenario: Digitar um numero com a porta fechada
        Given que a porta esta fechada
        And digitar 0
        When eu ja tiver pressionado
        Then deve ser exibido no display o numero "0"
        
    Scenario: Salvar senha com porta fechada e destravada
        Given dado que a porta esta fechada e destravada
        And digitar 1
        And digitar 2
        And digitar 3
        And digitar 4
        And digitar 5
        And digitar 6
        When eu pressionar ok
        Then deve ser exibido no display "Senha salva. Cofre trancado"

    Scenario: Travar porta com senha menor que 6 digitos
        Given dado que a porta esta fechada e destravada
        And digitar 1
        And digitar 2
        And digitar 3
        And digitar 4
        And digitar 5
        When eu pressionar ok
        Then deve ser exibido no display "senha precisa de 6 digitos. Tente novamente"

    Scenario: Digitar a senha com a porta fechada e depois abrir e digitar novamente
        Given dado que a porta esta fechada e destravada
        And digitar 4
        And digitar 5
        When eu abrir a porta
        And digitar 3
        Then deve ser exibido no display "Feche a porta antes de digitar a senha"