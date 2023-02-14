package com.neoris.tasks;

import com.neoris.ui.BuscarUI;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;
import java.util.stream.Collectors;

public class Buscar {

    public static Performable producto(String nombreProducto) {

        return Task.where(actor -> {
            WebElementFacade webElementFacade = BuscarUI.BUSCARDOR.resolveFor(actor);
            actor.attemptsTo(Enter.theValue(nombreProducto).into(webElementFacade));

        });

    }

    public static Performable marca(String nombreMarca) {
        return Task.where(actor -> {
            List<WebElementFacade> listaProductos = actor.recall("LISTA_PRODUCTOS");
            List<String> listaMarva = listaProductos.stream()
                    .map(WebElementFacade::getText)
                    .filter(text -> text.toLowerCase().contains(nombreMarca.toLowerCase()))
                    .collect(Collectors.toList());
            listaMarva.forEach(System.out::println);
            actor.remember("LISTA_MARCA", listaMarva);


        });
    }
}
