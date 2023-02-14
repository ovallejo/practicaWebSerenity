package com.neoris.stepsdefinitions;

import com.neoris.questions.Validar;
import com.neoris.tasks.Buscar;
import com.neoris.tasks.Listar;
import com.neoris.ui.BuscarUI;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

public class CompraStepdefinition {


    @Cuando("Busco un {word}")
    public void buscoUn(String nombreProducto) {
        OnStage.theActorInTheSpotlight().attemptsTo(Buscar.producto(nombreProducto));
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(BuscarUI.BOTON_BUSCAR));
    }

    @Entonces("me muestra los resultados")
    public void meMuestraLosResultados() {
        OnStage.theActorInTheSpotlight().attemptsTo(Listar.productos());
    }

    @Dado("Busque en los resultado la marca {string}")
    public void busqueEnLosResultadoLaMarca(String nombreMarca) {
        OnStage.theActorInTheSpotlight().attemptsTo(Buscar.marca(nombreMarca));

    }

    @Entonces("Que en la lista haya resultados")
    public void queEnLaListaHayaResultados() {
        OnStage.theActorInTheSpotlight().attemptsTo(Validar.listaMarca());

    }
}
