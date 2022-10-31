package com.example.lucenedemo.test;

/**
 * @author chenbiao
 * @version 1.0
 * @description
 * @date 2022/8/2 18:48
 */
import java.io.IOException;

import com.example.lucenedemo.constclass.LuceneConstants;
import com.example.lucenedemo.filter.TextFileFilter;
import com.example.lucenedemo.index.Indexer;
import com.example.lucenedemo.search.Searcher;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class LuceneTester {

    String indexDir = "E:\\Lucene\\Index";
    String dataDir = "E:\\Lucene\\Data";
    Indexer indexer;
    Searcher searcher;

    public static void main(String[] args) {
        LuceneTester tester;
        try {
            tester = new LuceneTester();
            tester.createIndex();
            tester.search("record01");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void createIndex() throws IOException{
        indexer = new Indexer(indexDir);
        int numIndexed;
        long startTime = System.currentTimeMillis();
        numIndexed = indexer.createIndex(dataDir, new TextFileFilter());
        long endTime = System.currentTimeMillis();
        indexer.close();
        System.out.println(numIndexed+" File indexed, time taken: "
                +(endTime-startTime)+" ms");
    }

    private void search(String searchQuery) throws IOException, ParseException{
        searcher = new Searcher(indexDir);
        long startTime = System.currentTimeMillis();
        TopDocs hits = searcher.search(searchQuery);
        long endTime = System.currentTimeMillis();

        System.out.println(hits.totalHits +
                " documents found. Time :" + (endTime - startTime));
        for(ScoreDoc scoreDoc : hits.scoreDocs) {
            Document doc = searcher.getDocument(scoreDoc);
            System.out.println("File: "
                    + doc.get(LuceneConstants.FILE_PATH));
            System.out.println("Content: "
                    + doc.get(LuceneConstants.CONTENTS));
        }
        searcher.close();
    }
}
//更多请阅读：https://www.yiibai.com/lucene/lucene_first_application.html#article-start

