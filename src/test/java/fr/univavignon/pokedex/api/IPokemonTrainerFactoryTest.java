package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IPokemonTrainerFactoryTest {

    IPokemonTrainerFactory pkmnTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
    IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);
    IPokedex pokedex = Mockito.mock(IPokedex.class);

    Team team = Team.INSTINCT;
    PokemonTrainer ash = new PokemonTrainer("Ash", team, pokedex);

    @BeforeEach
    void setup()
    {
        try {
            when(pkmnTrainerFactory.createTrainer("Ash", team, pokedexFactory)).thenReturn(ash);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    void createTrainer() {
        try {
            PokemonTrainer trainer = pkmnTrainerFactory.createTrainer("Ash", team, pokedexFactory);
            assertEquals(trainer.getName(), "Ash");
            assertEquals(trainer.getPokedex(), pokedex);
            assertEquals(trainer.getTeam(), team);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
            }
}