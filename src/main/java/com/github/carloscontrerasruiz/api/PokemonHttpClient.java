package com.github.carloscontrerasruiz.api;

import com.github.carloscontrerasruiz.api.dto.PokemonCharacter;
import com.google.gson.Gson;
import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Singleton
public class PokemonHttpClient {

    @Value("${pokemon.url}")
    private String url;

    public PokemonCharacter getCharacter(String characterName) {
        try {
            HttpResponse<String> response = HttpClient.newBuilder().build()
                    .send(HttpRequest.newBuilder()
                                    .uri(new URI(url + characterName.trim().toLowerCase()))
                                    .GET()
                                    .timeout(Duration.ofMillis(3000))
                                    .build(),
                            HttpResponse.BodyHandlers.ofString()
                    );

            if (response.statusCode() != 200) {
                throw new IllegalArgumentException("Este pokemon no existe");
            }

            PokemonCharacter pokemonCharacter = new Gson().fromJson(response.body(), PokemonCharacter.class);

            if (pokemonCharacter == null) {
                throw new IllegalArgumentException("Este pokemon no existe");
            }

            return pokemonCharacter;

        } catch (Exception ex) {
            throw new IllegalArgumentException(ex.getMessage());
        }
//        } catch (IOException e) {
//            throw new IllegalArgumentException(e.getMessage());
//        } catch (InterruptedException e) {
//            throw new IllegalArgumentException(e.getMessage());
//        }
    }
}
