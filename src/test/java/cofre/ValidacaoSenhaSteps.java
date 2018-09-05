package cofre;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Aluno
 */
public class ValidacaoSenhaSteps {
    
    public ValidacaoSenhaSteps(){
    }
    
    private String senha;
    private boolean retorno;
    
    @Given("^que a porta esta fechada e travada$")
    public void que_a_porta_esta_fechada_e_travada() throws Exception {}
    
    @Given("^eu entrei com a senha \"([^\"]*)\"$")
    public void eu_entrei_com_a_senha(String arg1) throws Exception {
        this.senha = arg1;
    }
    @When("^o sistema verifica a senha$")
    public void o_sistema_verifica_a_senha() throws Exception {
        this.retorno = ValidacaoHelper.ehNumero(this.senha);
    }
    @When("^o sistema verifica se eh valido$")
    public void o_sistema_verifica_se_eh_valido() throws Exception {
        this.retorno = ValidacaoHelper.ehSenhaValida(this.senha);
    }
    @Then("^o resultado deve ser \"([^\"]*)\"$")
    public void o_resultado_deve_ser(String arg1) throws Exception {
        assertEquals(this.retorno, Boolean.valueOf(arg1));
    }
}
