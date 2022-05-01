package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

class IPokedexTest {

    IPokedex pokedex = Mockito.mock(IPokedex.class);

    Pokemon bulbizarrePkmn = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
    Pokemon aqualiPkmn = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

    ArrayList<Pokemon> pkmnList = new ArrayList<>();



    @BeforeEach
    void setup()
    {
        try {
            pkmnList.add(bulbizarrePkmn);
            pkmnList.add(aqualiPkmn);

            PokemonComparators pkmnComp = PokemonComparators.INDEX;

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


            when(pokedex.getPokemons()).thenReturn(pkmnList);
            //when(pokedex.getPokemons(pkmnComp.thenComparing(bulbizarrePkmn, aqualiPkmn))).thenReturn(0);
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }
    }

    @org.junit.jupiter.api.Test
    void addPokemon() {
        try {
            int index = pokedex.addPokemon(bulbizarrePkmn);
            assertEquals(index, 0);
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }

    }

    @org.junit.jupiter.api.Test
    void getPokemon() {
        try {
            Pokemon pkmn = pokedex.getPokemon(0);
            assertEquals(pkmn, bulbizarrePkmn);
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }
    }

    @org.junit.jupiter.api.Test
    void getPokemons() {

            List<Pokemon> aList = pokedex.getPokemons();
            assertEquals(2, aList.size());

    }

    @org.junit.jupiter.api.Test
    void testGetPokemons() {

        PokemonComparators pokemonComparators = PokemonComparators.INDEX;
        pkmnList.sort(pokemonComparators);
        ArrayList<Pokemon> listComp = new ArrayList<>();
        listComp.add(bulbizarrePkmn);
        listComp.add(aqualiPkmn);
        assertEquals(pkmnList, listComp);
    }

    @org.junit.jupiter.api.Test
    void getSize() {
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