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
public class CofreTravadoSteps {
    
    public CofreTravadoSteps(){
    }
    
    private SensorPorta sensorMock;
    private Memoria memoriaMock;
    private CofrePM cofrePM;   
    
    @Given("^dado que a porta esta fechada e travado com a senha$")
    public void dado_que_a_porta_esta_fechada_e_travado_com_a_senha() throws Exception {
        sensorMock = mock(SensorPorta.class);
        memoriaMock = mock(Memoria.class);
        cofrePM = new CofrePM(sensorMock, memoriaMock);
         when(sensorMock.fechada())
                .thenReturn(Boolean.TRUE);
         when(sensorMock.travada())
                .thenReturn(Boolean.TRUE);   
         when(memoriaMock.getSenha())
                .thenReturn("123456");
    }
    @Given("^apertar (\\d+)$")
    public void apertar(int arg1) throws Exception {
        cofrePM.pressButton(arg1);
    }
    @When("^eu apertar ok$")
    public void eu_apertar_ok() throws Exception {
        cofrePM.ok();
    }
    @Then("^deve ser mostrado no display \"([^\"]*)\"$")
    public void deve_ser_mostrado_no_display(String arg1) throws Exception {
        assertEquals(arg1, cofrePM.getDisplay());
    }
}
