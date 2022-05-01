package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IPokedexFactoryTest {


    IPokedexFactory pokedexF = Mockito.mock(IPokedexFactory.class);

    IPokemonMetadataProvider metaProvider = Mockito.mock(IPokemonMetadataProvider.class);
    IPokemonFactory pkmnFactory = Mockito.mock(IPokemonFactory.class);

    IPokedex pokedex = Mockito.mock(IPokedex.class);

    @BeforeEach
    void setup()
    {
        try {
            when(pokedexF.createPokedex(metaProvider, pkmnFactory)).thenReturn(pokedex);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void createPokedex()
    {
        assertEquals(pokedexF.createPokedex(metaProvider, pkmnFactory), pokedex);
    }
}