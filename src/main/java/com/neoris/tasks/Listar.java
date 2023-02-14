package com.neoris.tasks;

import com.neoris.ui.BuscarUI;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

public class Listar {
    public static Performable productos() {
        return Task.where(actor -> {
            List<WebElementFacade> listaProductos = BuscarUI.LISTADO_ELEMENTOS.resolveAllFor(actor);
            actor.remember("LISTA_PRODUCTOS", listaProductos); //memoria la información
            for (WebElementFacade web : listaProductos) {
                String nombreProducto = web.findBy(".//h2/a[contains(@class,'a-link-normal')]").getText();
                String precioCompletoProducto = "";
                String precioFraccionProducto = "";
                try {
                    precioCompletoProducto = web.findBy(".//span[@class='a-price-whole']").getText();
                    precioFraccionProducto = web.findBy(".//span[@class='a-price-fraction']").getText();
                } catch (NoSuchElementException e) {
                    System.out.println("El producto no tiene precio");
                }


                System.out.println(nombreProducto);
                System.out.printf("$%s.%s%n", precioCompletoProducto, precioFraccionProducto);

                //
                //

            }
        });
    }
}
