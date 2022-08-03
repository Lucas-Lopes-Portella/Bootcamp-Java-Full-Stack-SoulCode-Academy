import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class VeiculoTest {
    static int totalTests = 0;
    static DateTimeFormatter timeFormatter;

    @BeforeAll // exuta antes de todos os testes
    // o método deve ser estático
    public static void beforeAll(){
        totalTests = 0;
        timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    }

    @AfterAll // ao final de todos testes
    // o método deve ser estático
    public static void afterAll(){
        System.out.println("Total de testes" + totalTests);
    }

    @BeforeEach // executa antes de CADA teste
    public void beforeEach(){
        totalTests++;
        var agora = LocalDateTime.now();
        System.out.println("[START] Teste #" + totalTests + " | " + agora.format(timeFormatter));
    }

    @AfterEach // executa após CADA teste
    public void afterEach(){
        var agora = LocalDateTime.now();
        System.out.println("[END] Teste #" + totalTests + " | " + agora.format(timeFormatter));
    }

    @Test
    public void testCarroNaoViajaDesliga(){
        var v1 = new Veiculo(4,20,2000,10);
        boolean viajou = v1.viajar(1);
        assertFalse(viajou);
    }

    @Test
    public void testVeiculoContaCorretamenteCombustivel(){
        var v1 = new Veiculo(4,30,2000,30);
        v1.ligar();
        v1.viajar(60);

        assertEquals(28.0,v1.getTanque(),0.0);
    }

    @Test
    public void testVeiculoViajaApenasOPossivel(){
        var v1 = new Veiculo(4,30,2000,30);
        v1.ligar();
        boolean viajou = v1.viajar(100_000_000);
        assertFalse(viajou);
    }

    @Test
    public void testVeiculoNaoGastaCombustivel(){
        var v1 = new Veiculo(4,30,2000,30);
        double tanqueAtual = v1.getTanque();
        v1.ligar();
        v1.viajar(100_000_000);
        assertEquals(tanqueAtual, v1.getTanque(),0.0);
    }

    // Prática I: Ajustar o método viajar() para não aceitar valores negativos
    // criar um @test para esta situação

    // Prática II: Fazer teste unitário da classe CalculadoraPorcentagem (aplica JUNIT)

    @Test
    public void testeVeiculoAntigoNaoLiga(){
        var v1 = new Veiculo(4,20,1900,10);
        v1.ligar();
        assertFalse(v1.getLigado());
        // assert (v1.getLigado() == false);
    }

    @Test
    public void testeVeiculoRecenteLiga(){
        var v1 = new Veiculo(4,20,2000,10);
        v1.ligar();
        assertTrue(v1.getLigado());
    }
}
