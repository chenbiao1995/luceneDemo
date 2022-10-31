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
public class QuestionVO extends BaseImportData{

    /**
     * 题目id
     */
    private int id;

    /**
     * 题干
     */
    @ExcelImport(value = "题干", required = true, unique = true, maxLength = 10)
    private String content;

    /**
     * 选项：[{"tag":"A","content":"选项A"},{"tag":"B","content":"选项B"}]
     */
    @ExcelImport("选项")
    private String item;
    /**
     * 选项A
     */
    @ExcelImport("选项A")
    private String itemA;
    /**
     * 选项B
     */
    @ExcelImport("选项B")
    private String itemB;
    /**
     * 选项C
     */
    @ExcelImport("选项C")
    private String itemC;
    /**
     * 选项D
     */
    @ExcelImport("选项D")
    private String itemD;

    /**
     * 答案
     */
    @ExcelImport(value = "答案", maxLength = 2, required = true)
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
    /**
     * 错误提示
     */
    private String rowTips;
    /**
     * 题目行号
     */
    private int rowNum;

    /**
     * 对应行的数据
     */
    private String rowData;

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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getMd5Value() {
        String content = this.getContent();
        if (!StringUtils.isEmpty(content)) {
            return SecureUtil.md5(content.replace(" ",""));
        }   else {
            return md5Value;
        }
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

    public String getItemA() {
        return itemA;
    }

    public void setItemA(String itemA) {
        this.itemA = itemA;
    }

    public String getItemB() {
        return itemB;
    }

    public void setItemB(String itemB) {
        this.itemB = itemB;
    }

    public String getItemC() {
        return itemC;
    }

    public void setItemC(String itemC) {
        this.itemC = itemC;
    }

    public String getItemD() {
        return itemD;
    }

    public void setItemD(String itemD) {
        this.itemD = itemD;
    }

    public void setItem(String item) {
        this.item = item;
    }


    public String getRowTips() {
        return rowTips;
    }

    public void setRowTips(String rowTips) {
        this.rowTips = rowTips;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }
//
//    public String getRowData() {
//        return rowData;
//    }
//
//    public void setRowData(String rowData) {
//        this.rowData = rowData;
//    }

}
