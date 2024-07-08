package org.extension;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.Module.AppModule;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

public class GuiceExtension implements TestInstancePostProcessor, BeforeEachCallback {

    private Injector injector;

    public GuiceExtension() {
        injector = Guice.createInjector(new AppModule());
    }

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) {
        injector.injectMembers(testInstance);
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        injector.injectMembers(context.getTestInstance().orElse(null));
    }
}