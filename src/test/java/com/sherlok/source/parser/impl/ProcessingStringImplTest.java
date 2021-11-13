package com.sherlok.source.parser.impl;

import com.sherlok.source.parser.ProcessingString;
import junit.framework.TestCase;

public class ProcessingStringImplTest extends TestCase {

    public void testSyntacticSings(){
        ProcessingString processingString = new ProcessingStringImpl();

        String buffer = "Как проверить(номер:мобильного телефона? Проверка правильности, " +
                "введенного номера)телефона;является не сложной, но #важной задачей. " +
                "Если пользователь{введет}некорректный?номер, то \"смс сообщение до него не дойдет.";
        String none = "";
        processingString.replaceSigns(buffer);
        processingString.replaceSigns(none);
    }

}