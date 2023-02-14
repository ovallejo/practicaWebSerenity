package com.neoris.questions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

public class Validar {
    public static Performable listaMarca() {
        return Task.where(actor ->{
            List<String> listaMarca = actor.recall("LISTA_MARCA");
            actor.attemptsTo(Ensure.that(listaMarca).isEmpty());
        });
    }
}
