package com.example.lucenedemo.temp;

/**
 * @author chenbiao
 * @version 1.0
 * @description
 * @date 2022/10/11 19:50
 */
public class Item {
    /**
     * 选项名称 A B C D
     */
    private String tag;

    /**
     * 内容
     */
    private String content;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Item(String tag, String content) {
        this.tag = tag;
        this.content = content;
    }
}
