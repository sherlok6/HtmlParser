package com.sherlok.source.url;

/**Интерфейс наследуется от {@link RequestURL} и определяет
 *  как будет получен текст страницы, расположенной по адресу
 *
 * @author sherlok6(Skiba Nikolai)
 * @version 1.0
 *  **/
public interface SourceURL extends RequestURL{

    /**Возвращает строку, содержащую текст страницы расположенной по адресу {@param path}**/
    String getBuffHtml(String path);
}
