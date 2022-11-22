package com.github.carloscontrerasruiz.search;

import com.github.carloscontrerasruiz.api.PokemonHttpClient;
import com.github.carloscontrerasruiz.api.dto.PokemonCharacter;
import jakarta.inject.Inject;
import picocli.CommandLine;

@CommandLine.Command(name = "search",
        description = "Search a pokemon using its name",
        mixinStandardHelpOptions = true)
public class SearchCommand implements Runnable {

    @CommandLine.Option(names = {"--name", "-n"}, description = "Name of the pokemon")
    private String pokemonName = "";

    @CommandLine.Option(names = {"--verbose", "-v"}, description = "Activate verbose mode")
    private boolean verbose = false;

    @Inject
    PokemonHttpClient httpClient;

    @Override
    public void run() {
        if (verbose) {
            System.out.println("Searching running");
        }
        try {
            PokemonCharacter result = httpClient.getCharacter(pokemonName);
            System.out.println(result.getName());
            System.out.println(result.getId());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
