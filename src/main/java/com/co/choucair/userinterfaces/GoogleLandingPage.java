package com.co.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GoogleLandingPage {

    public static final Target TXTPalabraBusqueda = Target.the("campo de texto de busqueda de google")
            .located(By.xpath("(//textarea)[1]"));

    public static final Target SUGGESTED_OPTIONS = Target.the("opciones sugeridas por Google")
            .located(By.xpath("//ul[@role='listbox']//li//span"));
}
