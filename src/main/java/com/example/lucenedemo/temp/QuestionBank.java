package com.example.lucenedemo.temp;

import cn.hutool.core.util.ObjectUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author chenbiao
 * @version 1.0
 * @description 试卷
 * @date 2022/10/12 9:52
 */
public class QuestionBank {
    /**
     * 试卷
     */
    public static HashMap<String, Question> questions = new HashMap<>();

    /**
     * @description 随机获取指定数量的题目组成试卷
     * @param: num[题目的数量]
     * @author chenbiao
     * @updateTime 2022/10/12
     * @return: java.util.List<com.example.lucenedemo.temp.Question>
     */
    public static List<Question> getRandomQuestions(int num) {
        ArrayList<Question> list = new ArrayList<>();
        String[] questionArray = (String[])questions.keySet().toArray();
        int length = questionArray.length;
        if (length > 0) {
            int[] randoms = RandomUtil.getRandoms(0, length, num);
            for (int random : randoms) {
                Question question = questions.get(questionArray[random]);
                if (ObjectUtil.isNotEmpty(question)){
                    question.setAnswer("");
                    list.add(question);
                }
            }
        }
        return list;
    }
}
