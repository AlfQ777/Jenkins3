package com.co.choucair.tasks;

import com.co.choucair.models.UserLoombokData;
import com.co.choucair.userinterfaces.SerenityLoginPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

    UserLoombokData userLoombokData;

    public Login(UserLoombokData userLoombokData) {
        this.userLoombokData = userLoombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SerenityLoginPage.TXT_USER, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(userLoombokData.getUser()).into(SerenityLoginPage.TXT_USER),
                Enter.theValue(userLoombokData.getPass()).into(SerenityLoginPage.TXT_PASS),
                JavaScriptClick.on(SerenityLoginPage.BTN_SUBMIT),
                WaitUntil.the(SerenityLoginPage.TXT_VALIDATION, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static Login onTheSite(UserLoombokData userLoombokData){
        return Instrumented.instanceOf(Login.class).withProperties(userLoombokData);
    }
}
