package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    private ArrayList<Pokemon> pokedexList = new ArrayList<>();
    private PokemonMetadataProvider metadataProvider;
    private PokemonFactory pokemonFactory;

    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory)
    {
        this.metadataProvider = (PokemonMetadataProvider) metadataProvider;
        this.pokemonFactory = (PokemonFactory) pokemonFactory;

        this.metadataProvider.setPokedex(this);
    }

    @Override
    public int size() {
        return pokedexList.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokedexList.add(pokemon);
        return(pokedexList.indexOf(pokemon));
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        return pokedexList.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokedexList;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        ArrayList<Pokemon> resultList = new ArrayList<>();
        resultList = pokedexList;
        resultList.sort(order);

        return resultList;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }
}
