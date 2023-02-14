package com.neoris.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.time.Duration;

public class BuscarUI {

    public static final Target BUSCARDOR = Target.the("Buscador").locatedBy("//input[@id='twotabsearchtextbox']").waitingForNoMoreThan(Duration.ofSeconds(30));
    public static final Target BOTON_BUSCAR = Target.the("Botón Buscar").located(By.id("nav-search-submit-button")).waitingForNoMoreThan(Duration.ofSeconds(30));
    public static final Target LISTADO_ELEMENTOS = Target.the("Listado Elementos").locatedBy("//div[contains(@class,'s-widget-container')]/div[contains(@class,'s-card-container')]").waitingForNoMoreThan(Duration.ofSeconds(30));
}
