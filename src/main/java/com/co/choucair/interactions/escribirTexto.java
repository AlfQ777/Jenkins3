package com.co.choucair.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class escribirTexto implements Interaction {

    private String palabraBusqueda;
    private Target TXTPalabraBusqueda;
    public escribirTexto(String palabraBusqueda, Target TXTPalabraBusqueda) {
        this.palabraBusqueda = palabraBusqueda;
        this.TXTPalabraBusqueda = TXTPalabraBusqueda;
    }
    public static escribirTexto writeText(String palabraBusqueda, Target TXTPalabraBusqueda){
        return new escribirTexto(palabraBusqueda, TXTPalabraBusqueda);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXTPalabraBusqueda, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(palabraBusqueda).into(TXTPalabraBusqueda)
        );
    }

}
