package com.sherlok.source.url;

/**Интерфейс определяет каким образом будет проверен адрес ресурса
 *
 * @author sherlok6(Skiba Nikolai)
 * @version 1.0
 * **/
public interface RequestURL{

    /**Метод для проверки {@param mbURL}, является ли он URL адресом
     * @return false - не является URL, true - является**/
    boolean isURL(String mbURL);
}
