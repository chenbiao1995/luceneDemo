package com.example.lucenedemo.temp;

/**
 * @author chenbiao
 * @version 1.0
 * @description excel导入题库失败的信息
 * @date 2022/10/11 20:43
 */
public class FailImportInfo {
    /**
     * 导入失败的行数
     */
    private int rowNum;
    /**
     * 导入失败的原因
     */
    private String reason;

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
