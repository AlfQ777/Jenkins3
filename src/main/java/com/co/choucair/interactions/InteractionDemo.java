package com.co.choucair.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class InteractionDemo implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        /* *
        * En este bloque de codigo podremos implementar codigo con Selenium para
        * interactuar por ejemplo, una lista desplegable con la clase WebElement
        * usar un Drag and Drop
        * en pocas palabras, metodos que usamos en POM pero para usarlos en Screenplay
        * para usar una interaccion se llama dentro de una Task
        *
        * Ejemplo:
        *
        *   @Override
            public <T extends Actor> void performAs(T actor) {
                actor.attemptsTo(
                    WaitUntil.the(SerenityLoginPage.TXT_USER, isVisible()).forNoMoreThan(10).seconds(),
                    JavaScriptClick.on(SerenityLoginPage.TXT_USER),
                    InteractionDemo.on()
                );
            }
        * */
    }

    public static InteractionDemo on(){
        return Instrumented.instanceOf(InteractionDemo.class).withProperties();
    }
}
