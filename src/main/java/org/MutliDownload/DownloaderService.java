package org.MutliDownload;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class DownloaderService {

    @Getter
    private List<String> results;
    private static final Logger logger = LogManager.getLogger(DownloadTask.class);


    public List<String> downloadListOfUrls(List<String> URLS)
    {
        CountDownLatch latch = new CountDownLatch(URLS.size());
        Downloader downloader = new Downloader();
        List<Thread> threads = new ArrayList<>();
        results  = new ArrayList<>();

        for (String url : URLS) {
            Thread thread = new Thread(new DownloadTask(url, downloader, results, latch));
            threads.add(thread);
            thread.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            logger.error("Thread exception ",e);
        }

        return results;
    }



}
