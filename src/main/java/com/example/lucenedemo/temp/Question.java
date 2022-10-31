package com.example.lucenedemo.temp;

import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSONArray;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author chenbiao
 * @version 1.0
 * @description   题库表
 * @date 2022/10/11 19:10
 */
public class Question extends BaseImportData{

    /**
     * 题目id
     */
    private int id;

    /**
     * 题干
     */
    private String content;

    /**
     * 选项：[{"tag":"A","content":"选项A"},{"tag":"B","content":"选项B"}]
     */
    private String item;

    /**
     * 答案
     */
    private String answer;

    /**
     * 题干MD5值
     */
    private String md5Value;

    /**
     * 题目状态 0--禁用 1--启用
     */
    private int status;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 修改日期
     */
    private Date updateTime;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 修改用户
     */
    private String updateUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getMd5Value() {
        return md5Value;
    }

    public void setMd5Value(String md5Value) {
        this.md5Value = md5Value;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }
}
