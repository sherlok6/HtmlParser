package com.sherlok.source.parser.impl;

import com.sherlok.source.parser.ProcessingSource;
import junit.framework.TestCase;

import java.util.Arrays;

public class ProcessingSourceImplTest extends TestCase {

    public void testSplit() {
        ProcessingSource processingSource = new ProcessingSourceImpl();
        String str = "Как проверить номер мобильного телефона  Проверка правильности  введенного " +
                "номера телефона является не сложной  но  важной задачей  Если";
        System.out.println(Arrays.toString(processingSource.split(str)));
    }
}