package com.example.lucenedemo.runner;

import com.example.lucenedemo.temp.Question;
import com.example.lucenedemo.temp.QuestionBank;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author chenbiao
 * @version 1.0
 * @description   初始化试卷
 * @date 2022/10/12 9:45
 */
@Component
public class QuestionPaperInitRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("question_init_runner===========================");
        HashMap<String, Question> questionMap = new HashMap<>();
        Question question = new Question();
        question.setId(1);
        question.setAnswer("B");
        question.setContent("test");
        questionMap.put("1",question);
        QuestionBank.questions = questionMap;
    }
}
