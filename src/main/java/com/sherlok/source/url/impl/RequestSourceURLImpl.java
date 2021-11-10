package com.sherlok.source.url.impl;

import com.sherlok.source.url.inface.RequestURL;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestSourceURLImpl implements RequestURL {

    private static final Logger log = Logger.getLogger(RequestSourceURLImpl.class);

    RequestSourceURLImpl(){
    }

    @Override
    public BufferedReader getBuffHtml(String path) {
        try{
            URL url = new URL(path);
            BufferedReader htmlBuff = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            url = null;
            log.info("Получен ресурс по указанному адресу");
            return htmlBuff;
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
            log.info("Соответствует шаблону URL");
            return matcher.matches();
        } catch (RuntimeException e) {
            log.error("Неверно указан URL!");
            log.error(e.getMessage());
            return false;
        }
    }
}
