import net.serenitybdd.jbehave.SerenityStepFactory;
import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.guice.Injectors;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ParameterControls;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

public class StoriesRunner extends SerenityStories{

    public static net.thucydides.core.webdriver.Configuration getConfiguration() {
        return Injectors.getInjector().getInstance(net.thucydides.core.webdriver.Configuration.class);
    }

    @Override
    public List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()).getFile(), Arrays.asList("**/UlmartTest.story".split("\\s*,\\s*")), null);
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return SerenityStepFactory.withStepsFromPackage("ru.aplana.autotests.steps", configuration()).andClassLoader(getClassLoader());
    }
}

