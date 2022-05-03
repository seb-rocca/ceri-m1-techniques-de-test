package fr.univavignon.pokedex.api;

import java.util.ArrayList;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{

    private Pokedex pokedex;

    public void setPokedex(Pokedex pokedex)
    {
        this.pokedex = pokedex;
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        Pokemon pkmn = pokedex.getPokemon(index);
        return new PokemonMetadata(pkmn.getIndex(), pkmn.getName() , pkmn.getAttack(), pkmn.getDefense(), pkmn.getStamina());
    }
}
