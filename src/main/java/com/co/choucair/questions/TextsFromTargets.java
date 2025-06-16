package com.co.choucair.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;
import java.util.stream.Collectors;

public class TextsFromTargets implements Question<List<String>> {

    private final Target target;

    public TextsFromTargets(Target target) {
        this.target = target;
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return target.resolveAllFor(actor)
                .stream()
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());
    }

    public static TextsFromTargets from(Target target) {
        return new TextsFromTargets(target);
    }
}
