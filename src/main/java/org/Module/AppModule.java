package org.Module;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import org.MutliDownload.DownloaderService;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DownloaderService.class).in(Singleton.class);
    }
}