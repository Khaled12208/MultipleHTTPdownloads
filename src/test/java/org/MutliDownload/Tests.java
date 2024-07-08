package org.MutliDownload;


import com.google.inject.Inject;
import org.extension.GuiceExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(GuiceExtension.class)
public class Tests {

    @Inject
    DownloaderService downloaderService;

    @Test
    public void multiDownloaderTest()
    {
        List<String> URLS = new ArrayList<>();
        URLS.add("https://raw.githubusercontent.com/GoogleContainerTools/distroless/main/java/README.md");
        URLS.add("https://raw.githubusercontent.com/golang/go/master/README.md");
        List<String> results =  downloaderService.downloadListOfUrls(URLS);
        for (String res : results) {
            System.out.println("=".repeat(20));
            System.out.println(res);
        }

    }

    @Test
    public void multiDownloaderInvalidTest()
    {
        List<String> URLS = new ArrayList<>();
        URLS.add("https://raw.githubusercontent.com/GoogleContainerTools/distroless/main/java/README.md");
        URLS.add("https://FAKE.com");
        List<String> results =  downloaderService.downloadListOfUrls(URLS);
        for (String res : results) {
            System.out.println("=".repeat(5));
            System.out.println(res);
        }

    }

}

