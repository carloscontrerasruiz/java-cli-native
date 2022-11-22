package com.github.carloscontrerasruiz.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.micronaut.core.annotation.Introspected;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Introspected //Para desearilizar json con jackson sin reflection
public class Sprites {
    private String backDefault;
    private String backFemale;
    private String backShiny;
    private String backShinyFemale;
    private String frontDefault;
    private String frontFemale;
    private String frontShiny;
    private String frontShinyFemale;
}
