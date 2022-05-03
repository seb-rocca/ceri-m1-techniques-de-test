package fr.univavignon.pokedex.api;

import org.apache.commons.collections4.map.UnmodifiableMap;

import java.util.Map;

public class PokemonFactory implements IPokemonFactory{


    private Pokedex pokedex;

    public void setPokedex(Pokedex pokedex)
    {
        this.pokedex = pokedex;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {

        PokemonMetadata metadata = pokedex.getPokemonMetadata(index);

        return new Pokemon(index, metadata.getName(), metadata.getAttack(), metadata.getDefense(), metadata.getStamina(), cp, hp, dust, candy, 0);
    }
}
