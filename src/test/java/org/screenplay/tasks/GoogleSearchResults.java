package org.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.screenplay.pages.GoogleSearchPageObject;

import java.util.List;

public class GoogleSearchResults implements Question<List<String>> {

    public static Question<List<String>> displayed() {
        return new GoogleSearchResults();
    }

    public List<String> answeredBy(Actor actor) {
        return Text.of(GoogleSearchPageObject.SEARCH_RESULT_TITLES).viewedBy(actor).asList();
    }
}

