package com.sherlok.source.url;

import java.net.MalformedURLException;

public interface SourceURL extends RequestURL{
    String getBuffHtml(String path) throws MalformedURLException;
}
