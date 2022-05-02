package fr.univavignon.pokedex.api;



import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest extends TestCase {

    public IPokemonMetadataProviderTest()
    {}

    IPokemonMetadataProvider pkmnMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);

    PokemonMetadata bulbizarrePkmn = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
    PokemonMetadata aqualiPkmn = new PokemonMetadata(133, "Aquali", 186, 168, 260);

    @Before
    public void setUp()
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
    public void testShouldGetBulbizarreIndex() {
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
    public void testShouldGetBulbizarreName() {
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
    public void testShouldGetBulbizarreAttack() {
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
    public void testShouldGetBulbizarreDefense() {
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
    public void testShouldGetBulbizarreStamina() {
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
    public void testShouldGetAqualiIndex()
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
    public void testShouldGetAqualiName() {
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
    public void testShouldGetAqualiAttack() {
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
    public void testShouldGetAqualiDefense() {
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
    public void testShouldGetAqualiStamina() {
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