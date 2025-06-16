package com.co.choucair.stepdefinitions;

import com.co.choucair.models.UserLoombokData;
import com.co.choucair.questions.FirstSearchResult;
import com.co.choucair.questions.TextsFromTargets;
import com.co.choucair.questions.ValidateText;
import com.co.choucair.tasks.Login;
import com.co.choucair.userinterfaces.GoogleLandingPage;
import com.co.choucair.utils.GlobalData;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;

import static com.co.choucair.interactions.escribirTexto.writeText;
import static com.co.choucair.userinterfaces.GoogleLandingPage.TXTPalabraBusqueda;
import static com.co.choucair.userinterfaces.SerenityLoginPage.TXT_VALIDATION;
import static com.co.choucair.utils.GlobalData.*;
import static junit.framework.TestCase.assertTrue;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.containsString;

public class SerenityLoginStepDefinitions {
    @Given("el usuario abre la pagina de google")
    public void elUsuarioAbreLaPaginaDeGoogle() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URLGoogle));
    }

    @Given("the user is on the serenity demo page")
   public void theUserIsOnTheSerenityDemoPage() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
    }
    @When("attempts to log in")
    public void attemptsToLogIn(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Login.onTheSite(UserLoombokData.setData(dataTable).get(0))
        );
    }
    @Then("^validate the text on screen (.*)$")
    public void validateTheTextOnScreenDashboard(String text) {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateText.of(TXT_VALIDATION), containsString(text)));

    }

    @When("intenta buscar en google {string}")
    public void intentaBuscarEnGoogle(String arg0) {
        GlobalData.palabraClave = arg0;
        OnStage.theActorInTheSpotlight().attemptsTo(
                writeText(arg0, TXTPalabraBusqueda),
                WaitUntil.the(GoogleLandingPage.SUGGESTED_OPTIONS, isVisible()).forNoMoreThan(10).seconds()
                //,SendKeys.of(Keys.ENTER).into(TXTPalabraBusqueda)
        );
    }

    @Then("debería ver sugerencias de búsqueda relacionadas con {string}")
    public void deberiaVerSugerencias(String palabraClave) {
        List<String> sugerencias = OnStage.theActorInTheSpotlight().asksFor(TextsFromTargets.from(GoogleLandingPage.SUGGESTED_OPTIONS));
        assertTrue(sugerencias.stream().anyMatch(s -> s.toLowerCase().contains(palabraClave.toLowerCase())));
    }

    @And("valida que la palabra aparezca en el primer resultado de búsqueda")
    public void validaQueLaPalabraAparezcaEnElPrimerResultado() {
        //System.out.println("_valida que la palabra aparezca en el primer resultado de búsqueda");
        OnStage.theActorInTheSpotlight().attemptsTo(SendKeys.of(Keys.ENTER).into(GoogleLandingPage.TXTPalabraBusqueda));
        OnStage.theActorInTheSpotlight().should( seeThat(FirstSearchResult.containsTheKeyword(), is(true)));
    }

}
