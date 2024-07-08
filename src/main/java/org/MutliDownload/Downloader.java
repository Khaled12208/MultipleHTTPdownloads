package org.MutliDownload;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Downloader {
    private static final Logger logger = LogManager.getLogger(Downloader.class);

    public String download(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(1000);
        connection.setReadTimeout(1000);

        int status = connection.getResponseCode();
        if (status != 200) {
            logger.error("link {} has error , response code {}", urlString, status);
            throw new IOException("Failed to fetch content, status code: " + status);
        }

        Scanner scanner = new Scanner(connection.getInputStream());
        scanner.useDelimiter("\\A");
        String content = scanner.hasNext() ? scanner.next() : "";
        scanner.close();
        connection.disconnect();
        logger.info("link {} has been downloaded ", urlString);
        return content;
    }

}
