package org.MutliDownload;


import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class DownloadTask implements Runnable
{

    @Getter private final String url;
    private final Downloader downloader;
    private final List<String> results;
    private final CountDownLatch latch;
    private static final Logger logger = LogManager.getLogger(DownloadTask.class);

    public DownloadTask(String url, Downloader downloader, List<String> results, CountDownLatch latch) {
        this.url = url;
        this.downloader = downloader;
        this.results = results;
        this.latch = latch;
    }
    @Override
    public void run() {
        try {
            logger.info("Download Task for URL {} has started",url);
            String content = downloader.download(url);
            synchronized (results) {
                results.add(content);
            }
        } catch (Exception e) {
            logger.error("Failed to download " + url + ": " + e.getMessage());
            System.exit(1);
        } finally {
            latch.countDown();
        }
    }

}
