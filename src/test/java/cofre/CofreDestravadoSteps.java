package cofre;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Aluno
 */
public class CofreDestravadoSteps {
    
    public CofreDestravadoSteps(){
    }
    
    private SensorPorta sensorMock;
    private Memoria memoriaMock;
    private CofrePM cofrePM;    
    
    @Given("^que a porta esta aberta$")
    public void que_a_porta_esta_aberta() throws Exception {
        sensorMock = mock(SensorPorta.class);
        memoriaMock = mock(Memoria.class);
        cofrePM = new CofrePM(sensorMock, memoriaMock);
         when(sensorMock.fechada())
                .thenReturn(Boolean.FALSE);
    }
    @Given("^digitar (\\d+)$")
    public void digitar(int arg1) throws Exception {
        cofrePM.pressButton(arg1);
    }
    @When("^eu pressionar ok$")
    public void eu_pressionar_ok() throws Exception {
        cofrePM.ok();
    }
    @Then("^deve ser exibido no display \"([^\"]*)\"$")
    public void deve_ser_exibido_no_display(String arg1) throws Exception {
        assertEquals(arg1, cofrePM.getDisplay());
    }
    @Given("^que a porta esta fechada$")
    public void que_a_porta_esta_fechada() throws Exception {
        sensorMock = mock(SensorPorta.class);
        memoriaMock = mock(Memoria.class);
        cofrePM = new CofrePM(sensorMock, memoriaMock);
         when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);
    }
    @When("^eu ja tiver pressionado$")
    public void eu_ja_tiver_pressionado() throws Exception {}
    
    @Then("^deve ser exibido no display o numero \"([^\"]*)\"$")
    public void deve_ser_exibido_no_display_o_numero(String arg1) throws Exception {
        assertEquals(arg1, cofrePM.getDisplay());
    }
    @Given("^dado que a porta esta fechada e destravada$")
    public void dado_que_a_porta_esta_fechada_e_destravada() throws Exception {
        sensorMock = mock(SensorPorta.class);
        memoriaMock = mock(Memoria.class);
        cofrePM = new CofrePM(sensorMock, memoriaMock);
         when(sensorMock.travada())
                .thenReturn(Boolean.FALSE);
         when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);
    }
    @When("^eu abrir a porta$")
    public void eu_abrir_a_porta() throws Exception {
        when(sensorMock.fechada())
                .thenReturn(Boolean.FALSE);
    }
    @When("^eu pressionar limpar$")
    public void eu_pressionar_limpar() throws Exception {
        cofrePM.clear();
    }
}