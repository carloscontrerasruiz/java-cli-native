package com.github.carloscontrerasruiz

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

class PokemonCliCommandSpec extends Specification {

    @Shared
    @AutoCleanup
    ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)

    void "test pokemon-cli with command line option"() {
        given:
        ByteArrayOutputStream baos = new ByteArrayOutputStream()
        def out = System.out
        System.setOut(new PrintStream(baos))

        String[] args = ['search', '--name', 'charizard', '--verbose'] as String[]
        PicocliRunner.run(PokemonCliCommand, ctx, args)
        out.println baos.toString()

        expect:
        def output = baos.toString()
        output.contains("Searching running")
        output.contains("charizard")
        output.contains("6")
        !output.containsIgnoreCase("exception")
    }
}

