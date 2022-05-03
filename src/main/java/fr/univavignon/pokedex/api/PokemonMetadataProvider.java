package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.HashMap;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{
    private static HashMap<Integer, PokemonMetadata> pokemonHash;
    static
    {
        pokemonHash = new HashMap<Integer, PokemonMetadata>();
        PokemonMetadata bulbizarrePkmn = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        PokemonMetadata aqualiPkmn = new PokemonMetadata(133, "Aquali", 186, 168, 260);
        pokemonHash.put(0, bulbizarrePkmn);
        pokemonHash.put(133, aqualiPkmn);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        PokemonMetadata pkmn = pokemonHash.get(index);
        return new PokemonMetadata(pkmn.getIndex(), pkmn.getName() , pkmn.getAttack(), pkmn.getDefense(), pkmn.getStamina());
    }
}
