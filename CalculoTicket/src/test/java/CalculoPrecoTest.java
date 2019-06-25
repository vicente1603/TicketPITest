
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalculoPrecoTest {

    private static int PRECO_TICKET_ADULTO = 40;
    private static int PRECO_TICKET_CRIANCA = 20;
    private CalculoPreco calculadora = new CalculoPreco();

    @Test
    public void calculoPrecoParaUmAdulto() {
        List<Passageiro> passageiros = new ArrayList<>();
        Passageiro passageiro = new Passageiro(20);
        passageiros.add(passageiro);
        double preco = calculadora.calcularPreco(passageiros, PRECO_TICKET_ADULTO, PRECO_TICKET_CRIANCA);
        assertEquals(PRECO_TICKET_ADULTO, preco, 0);
    }

    @Test
    public void calculoPrecoParaUmaCrianca() {
        List<Passageiro> passageiros = new ArrayList<>();
        Passageiro PassageiroCrianca = new Passageiro(15);
        passageiros.add(PassageiroCrianca);
        double preco = calculadora.calcularPreco(passageiros, PRECO_TICKET_ADULTO, PRECO_TICKET_CRIANCA);
        assertEquals(PRECO_TICKET_CRIANCA, preco, 0);
    }

    @Test
    public void calcularPrecoFamilia() {
        List<Passageiro> passageiros = new ArrayList<>();
        Passageiro PassageiroAdulto1 = new Passageiro(20);
        Passageiro PassageiroAdulto2 = new Passageiro(20);
        Passageiro PassageiroCrianca3 = new Passageiro(12);
        Passageiro PassageiroCrianca4 = new Passageiro(4);
        passageiros.add(PassageiroAdulto1);
        passageiros.add(PassageiroAdulto2);
        passageiros.add(PassageiroCrianca3);
        passageiros.add(PassageiroCrianca4);
        double preco = calculadora.calcularPreco(passageiros, PRECO_TICKET_ADULTO, PRECO_TICKET_CRIANCA);
        assertEquals((2 * PRECO_TICKET_ADULTO + 2 * PRECO_TICKET_CRIANCA) *
                (1 - CalculoPreco.DESCONTO_FAMILIA), preco, 0);
    }

    @Test
    public void calcularPrecoCriancaCasoEspecifico() {
        List<Passageiro> passageiros = new ArrayList<>();
        Passageiro PassageiroCrianca = new Passageiro(18);
        passageiros.add(PassageiroCrianca);
        double preco = calculadora.calcularPreco(passageiros, PRECO_TICKET_ADULTO, PRECO_TICKET_CRIANCA);
        assertEquals(PRECO_TICKET_CRIANCA, preco, 0);
    }

    @Test
    public void calcularPrecoGratisCasoEspecifico() {
        List<Passageiro> passageiros = new ArrayList<>();
        Passageiro PassageiroCrianca = new Passageiro(3);
        passageiros.add(PassageiroCrianca);
        double preco = calculadora.calcularPreco(passageiros, PRECO_TICKET_ADULTO, PRECO_TICKET_CRIANCA);
        assertEquals(0, preco, 0);
    }

    @Test
    public void SemDecontoFamiliaCasoDoisAdultosUmaCrianca() {
        List<Passageiro> passageiros = new ArrayList<>();
        Passageiro PassageiroAdulto1 = new Passageiro(20);
        Passageiro PassageiroAdulto2 = new Passageiro(20);
        Passageiro PassageiroCrianca1 = new Passageiro(12);
        passageiros.add(PassageiroAdulto1);
        passageiros.add(PassageiroAdulto2);
        passageiros.add(PassageiroCrianca1);
        double preco = calculadora.calcularPreco(passageiros, PRECO_TICKET_ADULTO, PRECO_TICKET_CRIANCA);
        assertEquals((2 * PRECO_TICKET_ADULTO + PRECO_TICKET_CRIANCA), preco, 0);
    }

    @Test
    public void SemDecontoPrecoFamiliaCasoDuasCriancasUmAdulto() {
        List<Passageiro> passageiros = new ArrayList<>();
        Passageiro PassageiroAdulto1 = new Passageiro(20);
        Passageiro PassageiroCrianca1 = new Passageiro(12);
        Passageiro PassageiroCrianca2 = new Passageiro(12);
        passageiros.add(PassageiroAdulto1);
        passageiros.add(PassageiroCrianca1);
        passageiros.add(PassageiroCrianca2);
        double preco = calculadora.calcularPreco(passageiros, PRECO_TICKET_ADULTO, PRECO_TICKET_CRIANCA);
        assertEquals((PRECO_TICKET_ADULTO + 2 * PRECO_TICKET_CRIANCA), preco, 0);
    }

}
