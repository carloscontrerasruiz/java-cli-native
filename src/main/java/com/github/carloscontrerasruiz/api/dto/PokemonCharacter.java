package com.github.carloscontrerasruiz.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Introspected //Para desearilizar json con jackson sin reflection
public class PokemonCharacter {
    private int height;
    private int id;
    private String name;
    private Sprites sprites;
    private int weight;
}
