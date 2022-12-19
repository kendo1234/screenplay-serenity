package org.screenplay.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.screenplay.tasks.GoogleSearchResults;
import org.screenplay.tasks.SearchForKeyword;
import org.screenplay.tasks.StartWith;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.containsString;



import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
public class GoogleSearchScreenplayLiveTest {

    @Managed(driver = "chrome")
    WebDriver browser;

    Actor kitty = Actor.named("kitty");

    @Before
    public void setup() {
        kitty.can(BrowseTheWeb.with(browser));
    }

    @Test
    public void whenGoogleThenShouldSeeEugen() {
        givenThat(kitty).wasAbleTo(StartWith.googleSearchPage());

        when(kitty).attemptsTo(SearchForKeyword.of("baeldung"));

        then(kitty).should(seeThat(GoogleSearchResults.displayed(),
                hasItem(containsString("Eugen (Baeldung)"))));
    }
}