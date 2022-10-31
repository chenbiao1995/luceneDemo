package com.example.lucenedemo.filter;

/**
 * @author chenbiao
 * @version 1.0
 * @description
 * @date 2022/8/2 17:37
 */
import java.io.File;
import java.io.FileFilter;

public class TextFileFilter implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        return pathname.getName().toLowerCase().endsWith(".txt");
    }
}

