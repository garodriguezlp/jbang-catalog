///usr/bin/env jbang "$0" "$@" ; exit $?

//DEPS org.junit.jupiter:junit-jupiter-api:5.7.2
//DEPS org.junit.jupiter:junit-jupiter-engine:5.7.2
//DEPS org.junit.platform:junit-platform-launcher:1.7.2

//SOURCES MavenInitializer.java

import org.junit.jupiter.api.Test;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.LoggingListener;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

// JUnit5 Test class for MavenInitializer
public class MavenInitializerTest {

    // Define each Unit test here and run them separately in the IDE
    @Test
    public void testMavenInitializer() {
            assertEquals(1,2, "You should add some testing code for MavenInitializer here!");
    }   

    // Run all Unit tests with JBang with ./MavenInitializer.java
    public static void main(final String... args) {
        final LauncherDiscoveryRequest request =
                LauncherDiscoveryRequestBuilder.request()
                        .selectors(selectClass(MavenInitializerTest.class))
                        .build();
        final Launcher launcher = LauncherFactory.create();
        final LoggingListener logListener = LoggingListener.forBiConsumer((t,m) -> {
            System.out.println(m.get());
            if(t!=null) {
                t.printStackTrace();
            };
        });
        final SummaryGeneratingListener execListener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(execListener, logListener);
        launcher.execute(request);
        execListener.getSummary().printTo(new java.io.PrintWriter(out));
    }
}
