package com.co.choucair.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.questions.Text;

import static com.co.choucair.utils.GlobalData.palabraClave;

public class FirstSearchResult {

    // Target dinámico para el primer resultado
    private static final Target FIRST_RESULT_TITLE = Target.the("primer resultado")
            .locatedBy("(//h3)[1]"); // Google suele usar <h3> para títulos

    public static Question<Boolean> containsTheKeyword() {
        return new Question<Boolean>() {
            @Override
            public Boolean answeredBy(Actor actor) {
                String resultText = Text.of(FIRST_RESULT_TITLE).answeredBy(actor);
                return resultText.toLowerCase().contains(palabraClave.toLowerCase());
            }
        };
    }
}
