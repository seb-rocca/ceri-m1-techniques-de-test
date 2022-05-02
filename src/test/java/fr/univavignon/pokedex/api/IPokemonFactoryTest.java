package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class IPokemonFactoryTest extends TestCase {

    public IPokemonFactoryTest(){}

    IPokemonFactory pkmnFacto = Mockito.mock(IPokemonFactory.class);
    Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

    @Before
    public void setUp()
    {
        try {
            when(pkmnFacto.createPokemon(0, 613, 64, 4000, 4 )).thenReturn(bulbizarre);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreatePokemonBulbizarre() {
        Pokemon pkmn = pkmnFacto.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(0, pkmn.getIndex());
        assertEquals(613, pkmn.getCp());
        assertEquals(64, pkmn.getHp());
        assertEquals(4000, pkmn.getDust());
        assertEquals(4, pkmn.getCandy());
    }
}