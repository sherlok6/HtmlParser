package com.sherlok.source.url.inface;

import java.io.BufferedReader;

public interface RequestURL extends SourceURL{
    BufferedReader getBuffHtml(String path);
}
