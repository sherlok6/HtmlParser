package com.sherlok.source.url.impl;

import com.sherlok.source.url.SourceURL;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Класс реализует интерфейс {@link SourceURL} и
 * содержит объект для логирования <b>log</b> и свойство <b>regex</b>.
 *
 * @author sherlok6(Skiba Nikolai)
 * @version 1.0
 * **/
public class SourceURLImpl implements SourceURL {

    /** Объект для логирования, полученный методом {@link Logger#getLogger(Class)}**/
    private static final Logger log = Logger.getLogger(SourceURLImpl.class);

    /**Содержит шаблон по которому будут проверяться входящие строки на наличие в них URL адреса**/
    private String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    /**Для работы с URL запросами используется класс {@link URL}, для доступа к ресурсу(страницы),и класс {@link Document}.
     * Объект класса {@link Document}, содержит инормацию о документе, расположенному по URL адресу.
     * Данный объект получаем с помощью метода {@link Jsoup#parse(URL, int)}, указываем URL объект и время ожидания.
     * Затем извлекаем элемент{@link Element} <body></body>, используя {@link Document#body()},
     * из которого с помощью метода {@link Element#text()} получаем текст страницы и возвращает его.
     * Для обработки ошибок, используется try-catch и {@link IOException e}.
     * Создается запись в лог файл при ошибке и нет.
     * @return null-ошибка, htmlStr-строка с текстом страницы
     * **/
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

    /**Используется {1} и {2} для работы с regular expression.
     * {1} создаёт объект шаблона, по которому {2} будет искать совпадения в {@param mbURL}.
     * Делает запись в лог при ошибочных ситуациях, успешных и не очень({@param mbURL} не является URL-адресом).
     * @return false-не соотвествует URL запросу или возникли ошибки при составлении ReqularExpression,true-соответствует
     * **/
    @Override
    public boolean isURL(String mbURL) {
        try {
            Pattern patt = Pattern.compile(regex);
            Matcher matcher = patt.matcher(mbURL);
            boolean match = matcher.matches();
            if(match && matcher.groupCount() == 1) {
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
