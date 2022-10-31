package com.example.lucenedemo;

import com.example.lucenedemo.constclass.LuceneConstants;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@SpringBootTest
class LuceneDemoApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(111);
    }
    @Test
    public Document getDocument(File file) throws IOException {
        Document document = new Document();
        Field  contentField = new Field(LuceneConstants.CONTENTS, new FileReader(file));
        Field fileNameField = new Field(LuceneConstants.FILE_NAME, file.getName(), Field.Store.YES, Field.Index.NOT_ANALYZED);
        //index file path
        Field filePathField = new Field(LuceneConstants.FILE_PATH,
                file.getCanonicalPath(),
                Field.Store.YES,Field.Index.NOT_ANALYZED);
        document.add(contentField);
        document.add(fileNameField);
        document.add(filePathField);
        return document;
    }

}
