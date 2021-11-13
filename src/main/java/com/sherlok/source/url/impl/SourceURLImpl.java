package com.sherlok.source.url.impl;

import com.sherlok.source.url.SourceURL;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SourceURLImpl implements SourceURL {

    private static final Logger log = Logger.getLogger(SourceURLImpl.class);

    @Override
    public String getBuffHtml(String path){
        try{
            URL url = new URL(path);
            Document htmlDoc = Jsoup.parse(url, 10000);
            String htmlStr = htmlDoc.body().text();
            url = null;
            log.info("Получен ресурс по указанному адресу");
            return htmlStr;
        } catch (IOException e) {
            log.error("Ошибка при запросе ресурса");
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean isURL(String mbURL) {
        String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
        try {
            Pattern patt = Pattern.compile(regex);
            Matcher matcher = patt.matcher(mbURL);
            boolean match = matcher.matches();
            if(match) {
                log.info("Соответствует шаблону URL");
            } else {
                log.error("Не соответствует URL шаблону");
            }
            return match;
        } catch (RuntimeException e) {
            log.error("Неверно указан URL!");
            log.error(e.getMessage());
            return false;
        }
    }
}
