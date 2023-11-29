import static org.junit.Assert.*;

import org.example.ConversorRomano;
import org.junit.Test;

public class TesteConversorRomano {

    @Test
    public void testeParaRomano() {
        assertEquals("III", ConversorRomano.paraRomano(3));
        assertEquals("XXV", ConversorRomano.paraRomano(25));
        assertEquals("MCMXCIX", ConversorRomano.paraRomano(1999));
        assertEquals("MCDXLIV", ConversorRomano.paraRomano(1444));
    }

    @Test
    public void testeParaDecimal() {
        assertEquals(4, ConversorRomano.paraDecimal("IV"));
        assertEquals(49, ConversorRomano.paraDecimal("XLIX"));
        assertEquals(1999, ConversorRomano.paraDecimal("MCMXCIX"));
        assertEquals(1444, ConversorRomano.paraDecimal("MCDXLIV"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeParaRomanoNumeroInvalido() {
        ConversorRomano.paraRomano(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeParaRomanoNumeroMaiorQue3999() {
        ConversorRomano.paraRomano(4000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeParaDecimalRomanoInvalido() {
        ConversorRomano.paraDecimal("IIII");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeParaDecimalSimboloRomanoInvalido() {
        ConversorRomano.paraDecimal("XIXV");
    }
}
