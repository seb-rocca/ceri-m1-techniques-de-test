package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider pkmnMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);

    PokemonMetadata bulbizarrePkmn = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
    PokemonMetadata aqualiPkmn = new PokemonMetadata(133, "Aquali", 186, 168, 260);



    @BeforeEach
    void setup()
    {
        try
        {
            when(pkmnMetadataProvider.getPokemonMetadata(0)).thenReturn(bulbizarrePkmn);
            when(pkmnMetadataProvider.getPokemonMetadata(133)).thenReturn(aqualiPkmn);


        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }
    }

    @Test
    void shouldGetBulbizarreIndex() {
        try {
            PokemonMetadata bulbizarreMeta = pkmnMetadataProvider.getPokemonMetadata(0);
            assertEquals(bulbizarreMeta.getIndex(), 0);
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }

    }

    @Test
    void shouldGetBulbizarreName() {
        try {
            PokemonMetadata bulbizarreMeta = pkmnMetadataProvider.getPokemonMetadata(0);
            assertEquals(bulbizarreMeta.getName(), "Bulbizarre");
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }

    }

    @Test
    void shouldGetBulbizarreAttack() {
        try {
            PokemonMetadata bulbizarreMeta = pkmnMetadataProvider.getPokemonMetadata(0);
            assertEquals(bulbizarreMeta.getAttack(), 126);
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }

    }

    @Test
    void shouldGetBulbizarreDefense() {
        try {
            PokemonMetadata bulbizarreMeta = pkmnMetadataProvider.getPokemonMetadata(0);
            assertEquals(bulbizarreMeta.getDefense(), 126);
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }

    }

    @Test
    void shouldGetBulbizarreStamina() {
        try {
            PokemonMetadata bulbizarreMeta = pkmnMetadataProvider.getPokemonMetadata(0);
            assertEquals(bulbizarreMeta.getStamina(), 90);
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }

    }


    @Test
    void shouldGetAqualiIndex()
    {
        try {
            PokemonMetadata aqualiMeta = pkmnMetadataProvider.getPokemonMetadata(133);
            assertEquals(aqualiMeta.getIndex(), 133);
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }
    }

    @Test
    void shouldGetAqualiName() {
        try {
            PokemonMetadata aqualiMeta = pkmnMetadataProvider.getPokemonMetadata(133);
            assertEquals(aqualiMeta.getName(), "Aquali");
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }

    }

    @Test
    void shouldGetAqualiAttack() {
        try {
            PokemonMetadata aqualiMeta = pkmnMetadataProvider.getPokemonMetadata(133);
            assertEquals(aqualiMeta.getAttack(), 186);
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }

    }

    @Test
    void shouldGetAqualiDefense() {
        try {
            PokemonMetadata aqualiMeta = pkmnMetadataProvider.getPokemonMetadata(133);
            assertEquals(aqualiMeta.getDefense(), 168);
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }

    }

    @Test
    void shouldGetAqualiStamina() {
        try {
            PokemonMetadata aqualiMeta = pkmnMetadataProvider.getPokemonMetadata(133);
            assertEquals(aqualiMeta.getStamina(), 260);
        }
        catch (Exception e)
        {
            System.out.println(e.getStackTrace());
        }

    }
}