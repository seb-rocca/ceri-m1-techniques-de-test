package fr.univavignon.pokedex.api;

import org.apache.commons.collections4.map.UnmodifiableMap;

import java.util.Map;

public class PokemonFactory implements IPokemonFactory{



    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {

        PokemonMetadataProvider metaProvider = new PokemonMetadataProvider();

        PokemonMetadata metadata = metaProvider.getPokemonMetadata(index);

        return new Pokemon(index, metadata.getName(), metadata.getAttack(), metadata.getDefense(), metadata.getStamina(), cp, hp, dust, candy, 0);
    }
}
