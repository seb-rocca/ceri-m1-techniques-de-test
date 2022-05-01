package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IPokemonFactoryTest {


    IPokemonFactory pkmnFacto = Mockito.mock(IPokemonFactory.class);
    Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);

    @BeforeEach
    void setup()
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
    void createPokemonBulbizarre() {
        Pokemon pkmn = pkmnFacto.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(0, pkmn.getIndex());
        assertEquals(613, pkmn.getCp());
        assertEquals(64, pkmn.getHp());
        assertEquals(4000, pkmn.getDust());
        assertEquals(4, pkmn.getCandy());
    }
}