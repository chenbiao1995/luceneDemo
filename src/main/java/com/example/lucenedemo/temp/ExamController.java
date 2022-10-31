package com.example.lucenedemo.temp;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

/**
 * @author chenbiao
 * @version 1.0
 * @description  题库相关业务类
 * @date 2022/10/11 19:15
 */
@Controller
@RequestMapping("/exam")
public class ExamController {
    /**
     * @description  通过excel批量导入题库
     * @param
     * @author chenbiao
     * @updateTime 2022/10/11
     */
    @RequestMapping("/importByExcel")
    public void importQuestionByExcel(@RequestPart("file")MultipartFile file) throws Exception{
        List<QuestionVO> questionVOS = ExcelUtils.readMultipartFile(file, QuestionVO.class);
        File file1 = new File("e:\\temp\\testImport.xlsx");
        List<QuestionVO> questions1 = ExcelUtils.readFile(file1, QuestionVO.class);
    }

    @RequestMapping("/getQuestionList")
    public void getQuestionList(int type){
        if (type == 1) {
            //生成闯关试卷
            //从缓存中获取闯关题数的配置、每道题目的答题时间限制、每次闯关的时间间隔限制
            //题目数
            int num = 10;
            //倒计时时间
            int countDown = 60;
            //时间间隔
            int limitTime = 3;
            //2. 随机从内存中获取 num道题目
            List<Question> randomQuestions = QuestionBank.getRandomQuestions(num);
        }   else if (type == 2) {
            //生成练习试卷
            //从缓存中获取闯关题数的配置、每道题目的答题时间限制、每次闯关的时间间隔限制
            //题目数
            int num = 10;
            //倒计时时间
            int countDown = 60;
            //时间间隔
            int limitTime = 3;
            //2. 随机从内存中获取 num道题目
            List<Question> randomQuestions = QuestionBank.getRandomQuestions(num);
        }




    }

    public static void main(String[] args) {
        File file = new File("e:\\temp\\testImport.xlsx");
        try {
            List<QuestionVO> questionsList = ExcelUtils.readFile(file, QuestionVO.class);
            //记录导入失败的题目信息
            ArrayList<FailImportInfo> failImportInfoList = new ArrayList<>();
            ArrayList<String> md5ValueList = new ArrayList<>();

            questionsList.forEach(question -> {
                if (StringUtils.isEmpty(question.getRowTips())) {
                    md5ValueList.add(question.getMd5Value());
                }   else {
                    FailImportInfo failImportInfo = new FailImportInfo();
                    failImportInfo.setRowNum(question.getRowNum());
                    failImportInfo.setReason(question.getRowTips());
                    failImportInfoList.add(failImportInfo);
                }
            });

            List<QuestionVO> questionVOList = null;
//            List<QuestionVO> questionVOList = findQuestionByMd5Value(md5ValueList);
//            for (QuestionVO question : questionsList) {
//                for (QuestionVO questionVO : questionVOList) {
//                    try {
//                        if (question.getMd5Value().equals(questionVO.getMd5Value())) {
//                            //更新
//                        }else {
//                            //新增
//                        }
//                    }   catch (Exception e){
//                        //保存到数据库报错的返回给前端
//                        FailImportInfo failImportInfo = new FailImportInfo();
//                        failImportInfo.setRowNum(question.getRowNum());
//                        failImportInfo.setReason(e.getMessage());
//                        failImportInfoList.add(failImportInfo);
//                    }
//
//
//                }
//
//            }
            System.out.println(JSONObject.toJSONString(questionsList));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/getQuestionPaperTest")
    @ResponseBody
    public String   getQuestionPaperTest() {
        return JSONObject.toJSONString(QuestionBank.questions);
    }

}
