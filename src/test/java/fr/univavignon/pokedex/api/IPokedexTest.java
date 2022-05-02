package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class IPokedexTest extends TestCase {

    public IPokedexTest(){

    }

    IPokedex pokedex = Mockito.mock(IPokedex.class);

    Pokemon bulbizarrePkmn = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    Pokemon aqualiPkmn = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

    ArrayList<Pokemon> pkmnList = new ArrayList<>();

    @Before
    public void setUp()
    {
        try {
            pkmnList.add(bulbizarrePkmn);
            pkmnList.add(aqualiPkmn);

            when(pokedex.getPokemon(any(Integer.class))).then(new Answer<Pokemon>() {
                @Override
                public Pokemon answer(InvocationOnMock invocationOnMock) throws Throwable {
                    int id = invocationOnMock.getArgument(0);
                    for(Pokemon p : pkmnList)
                    {
                        if(p.getIndex() == id)
                        {
                            return p;
                        }
                    }
                    return null;
                }
            });

            when(pokedex.addPokemon(any(Pokemon.class))).then(new Answer<Integer>() {
                @Override
                public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                    Pokemon poke = invocationOnMock.getArgument(0);
                    pkmnList.add(poke);
                    return poke.getIndex();
                }
            });

            when(pokedex.size()).then(new Answer<Integer>() {
                @Override
                public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                    return pkmnList.size();
                }
            });


            //when(pokedex.getPokemons()).thenReturn(pkmnList);

            when(pokedex.getPokemons()).then(new Answer<List<Pokemon>>() {
                @Override
                public List<Pokemon> answer(InvocationOnMock invocationOnMock) throws Throwable {
                    return pkmnList;
                }
            });

            when(pokedex.getPokemons(any())).then(new Answer<ArrayList<Pokemon>>() {
                @Override
                public ArrayList<Pokemon> answer(InvocationOnMock invocationOnMock) throws Throwable {
                    PokemonComparators pokemonComparators = PokemonComparators.INDEX;
                    //ArrayList<Pokemon> list =  new ArrayList<>();
                    pkmnList.sort(pokemonComparators);
                    return pkmnList;
                }
            });

        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }
    }

    @Test
    public void testAddPokemon() {
        try {
            int index = pokedex.addPokemon(bulbizarrePkmn);
            assertEquals(index, 0);
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }
    }

    @Test
    public void testgetPokemon() {
        try {
            Pokemon pkmn = pokedex.getPokemon(0);
            assertEquals(pkmn, bulbizarrePkmn);
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }
    }

    @Test
    public void testGetPokemons() {
            List<Pokemon> aList = pokedex.getPokemons();
            assertEquals(2, aList.size());

    }

    @Test
    public void testGetPokemonsComparators() {
        PokemonComparators comp = PokemonComparators.INDEX;
        List<Pokemon> list = pokedex.getPokemons();
        ArrayList<Pokemon> listComp = new ArrayList<>();

        listComp.add(aqualiPkmn);
        listComp.add(bulbizarrePkmn);
        listComp.sort(comp);
        assertEquals(list, listComp);
    }


    public void testGetSize() {
        try {
            int size = pokedex.size();
            assertEquals(size, 2);
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }
    }

}