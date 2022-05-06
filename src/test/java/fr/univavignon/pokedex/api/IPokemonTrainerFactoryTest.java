package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest extends TestCase {

    public IPokemonTrainerFactoryTest()
    {}

    /*IPokemonTrainerFactory pkmnTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
    IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);
    IPokedex pokedex = Mockito.mock(IPokedex.class);*/

    PokemonTrainerFactory pkmnTrainerFactory = new PokemonTrainerFactory();
    PokedexFactory pokedexFactory = new PokedexFactory();

    PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();

    PokemonFactory pkmnFactory = new PokemonFactory();

    Pokedex pokedex = new Pokedex(metadataProvider, pkmnFactory);

    Team team = Team.INSTINCT;
    PokemonTrainer ash = new PokemonTrainer("Ash", team, pokedex);

    @Before
    public void setUp()
    {
        try {
            //when(pkmnTrainerFactory.createTrainer("Ash", team, pokedexFactory)).thenReturn(ash);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateTrainer() {
        try {
            PokemonTrainer trainer = pkmnTrainerFactory.createTrainer("Ash", team, pokedexFactory);
            assertEquals(ash.getName(), trainer.getName());
            assertEquals(ash.getPokedex().getClass(), trainer.getPokedex().getClass());
            assertEquals(ash.getTeam(), trainer.getTeam());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
            }
}