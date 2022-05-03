package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class IPokemonFactoryTest extends TestCase {

    public IPokemonFactoryTest(){}

    //IPokemonFactory pkmnFacto = Mockito.mock(IPokemonFactory.class);
    PokemonFactory pkmnFacto = new PokemonFactory();

    PokemonMetadataProvider metaProvider = new PokemonMetadataProvider();

    PokemonFactory pkmnFactory = new PokemonFactory();

    Pokedex pokedex = new Pokedex(metaProvider, pkmnFactory);


    //Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

    @Before
    public void setUp() throws PokedexException {
        pkmnFacto.setPokedex(pokedex);
        pkmnFacto.createPokemon(0, 613, 64, 4000, 4);
        try {
            //when(pkmnFacto.createPokemon(0, 613, 64, 4000, 4 )).thenReturn(bulbizarre);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreatePokemonBulbizarre() throws PokedexException {
        Pokemon pkmn = pkmnFacto.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(0, pkmn.getIndex());
        assertEquals(613, pkmn.getCp());
        assertEquals(64, pkmn.getHp());
        assertEquals(4000, pkmn.getDust());
        assertEquals(4, pkmn.getCandy());
    }
}