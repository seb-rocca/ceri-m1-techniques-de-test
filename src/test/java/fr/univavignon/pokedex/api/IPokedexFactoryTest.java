package fr.univavignon.pokedex.api;


import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest extends TestCase {

    public IPokedexFactoryTest(){}

    PokedexFactory pokedexFactory = new PokedexFactory();

    PokemonMetadataProvider metaProvider = new PokemonMetadataProvider();

    PokemonFactory pkmnFactory = new PokemonFactory();

    Pokedex pokedex = new Pokedex(metaProvider, pkmnFactory);

    /*IPokedexFactory pokedexF = Mockito.mock(IPokedexFactory.class);

    IPokemonMetadataProvider metaProvider = Mockito.mock(IPokemonMetadataProvider.class);
    IPokemonFactory pkmnFactory = Mockito.mock(IPokemonFactory.class);

    IPokedex pokedex = Mockito.mock(IPokedex.class);*/

    @Before
    public void setUp()
    {
        try {
            //when(pokedexF.createPokedex(metaProvider, pkmnFactory)).thenReturn(pokedex);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testCeatePokedex()
    {
        assertEquals(pokedex.getClass(), pokedexFactory.createPokedex(metaProvider, pkmnFactory).getClass());
    }
}