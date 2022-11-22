package com.github.carloscontrerasruiz;

import com.github.carloscontrerasruiz.search.SearchCommand;
import io.micronaut.configuration.picocli.PicocliRunner;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "pokemon-cli", description = "Search pokemon using commands",
        mixinStandardHelpOptions = true, subcommands = {SearchCommand.class})
public class PokemonCliCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(PokemonCliCommand.class, args);
    }

    public void run() {
        // business logic here
        if (verbose) {
            System.out.println("Hi!");
        }
    }
}
