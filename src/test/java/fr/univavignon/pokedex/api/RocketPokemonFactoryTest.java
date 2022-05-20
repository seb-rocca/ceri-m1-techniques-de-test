package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.Assert.*;

public class RocketPokemonFactoryTest {

    public RocketPokemonFactoryTest(){}

    @Test
    public void testCreatePokemonBulbizarre() throws PokedexException {
        RocketPokemonFactory pkmnFacto = new RocketPokemonFactory();
        Pokemon pkmn = pkmnFacto.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(0, pkmn.getIndex());
        assertEquals(613, pkmn.getCp());
        assertEquals(64, pkmn.getHp());
        assertEquals(4000, pkmn.getDust());
        assertEquals(4, pkmn.getCandy());
        assertEquals("Bulbizarre", pkmn.getName());
        assertEquals(126, pkmn.getAttack());
        assertEquals(126, pkmn.getDefense());
        assertEquals(0, pkmn.getIv());
    }

    @Test
    public void testBulbizarreIndex()
    {
        RocketPokemonFactory pkmnFacto = new RocketPokemonFactory();
        Pokemon pkmn = pkmnFacto.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(0, pkmn.getIndex());
    }

    @Test
    public void testBulbizarreCp()
    {
        RocketPokemonFactory pkmnFacto = new RocketPokemonFactory();
        Pokemon pkmn = pkmnFacto.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(613, pkmn.getCp());
    }

    @Test
    public void testBulbizarreHp() throws PokedexException {
        RocketPokemonFactory pkmnFacto = new RocketPokemonFactory();
        Pokemon pkmn = pkmnFacto.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(64, pkmn.getHp());
    }

    @Test
    public void testBulbizarreDust() throws PokedexException {
        RocketPokemonFactory pkmnFacto = new RocketPokemonFactory();
        Pokemon pkmn = pkmnFacto.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(4000, pkmn.getDust());
    }

    @Test
    public void testBulbizarreCandy() throws PokedexException {
        RocketPokemonFactory pkmnFacto = new RocketPokemonFactory();
        Pokemon pkmn = pkmnFacto.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(4, pkmn.getCandy());
    }

    @Test
    public void testBulbizarreName() throws PokedexException {
        RocketPokemonFactory pkmnFacto = new RocketPokemonFactory();
        Pokemon pkmn = pkmnFacto.createPokemon(0, 613, 64, 4000, 4);
        assertEquals("Bulbizarre", pkmn.getName());
    }

    @Test
    public void testBulbizarreAttack() throws PokedexException {
        RocketPokemonFactory pkmnFacto = new RocketPokemonFactory();
        Pokemon pkmn = pkmnFacto.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(126, pkmn.getAttack());
    }

    @Test
    public void testBulbizarreDefense() throws PokedexException {
        RocketPokemonFactory pkmnFacto = new RocketPokemonFactory();
        Pokemon pkmn = pkmnFacto.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(126, pkmn.getDefense());
    }

    @Test
    public void testBulbizarreIv() throws PokedexException {
        RocketPokemonFactory pkmnFacto = new RocketPokemonFactory();
        Pokemon pkmn = pkmnFacto.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(0, pkmn.getIv());
    }
}