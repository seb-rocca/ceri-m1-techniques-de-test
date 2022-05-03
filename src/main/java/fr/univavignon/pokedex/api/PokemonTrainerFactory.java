package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory{
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonFactory pkmnFactory = new PokemonFactory();

        Pokedex trainerPokedex = (Pokedex) pokedexFactory.createPokedex(metadataProvider, pkmnFactory);
        PokemonTrainer trainer = new PokemonTrainer(name, team, trainerPokedex);

        return trainer;
    }
}
