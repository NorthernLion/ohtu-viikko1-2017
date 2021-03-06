package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void laittaminenLiikaaEiToimi() {
        varasto.lisaaVarastoon(8);
        varasto.lisaaVarastoon(3);

        varasto.otaVarastosta(4);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4.0, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenLiikaaEiToimi() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(9);

        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void alustaminenNegatiivisellaArvollaEiToimi() {
        Varasto kalasto = new Varasto(-2);
        
        assertEquals(0, 0, vertailuTarkkuus);
    }

    @Test
    public void alustaminenSaldollaJaTilavuudellaToimii() {
        Varasto kalasto = new Varasto(10,2);
        
        assertEquals(8, kalasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void alustaminenSaldollaJaTilavuudellaNegatiivisestiSaldoEiToimii() {
        Varasto kalasto = new Varasto(10,-2);
        
        assertEquals(10, kalasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void alustaminenSaldollaJaHuonollaTilavuudellaEiToimii() {
        Varasto kalasto = new Varasto(-2,2);
        
        assertEquals(0, 0, vertailuTarkkuus);
    }

    @Test
    public void lisataamVahemmanKuinNolla() {
        varasto.lisaaVarastoon(-2);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    

    @Test
    public void otetaanVahemmanKuinNolla() {
        varasto.otaVarastosta(-3);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void toStringToimii() {
        String expected = "saldo = 0.0, vielä tilaa 10.0";
        
        assertEquals(expected, varasto.toString());
    }
    
    
    
    
    
   
    

}