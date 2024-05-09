package com.champqcsoft.champexamen_by_olivier;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Exam {
    protected HashMap<Integer, Question> questions;
    protected HashMap<Integer, String> submittedAnswers;

    public Exam() {
        this.questions = new HashMap<>();
        this.submittedAnswers = new HashMap<>();
    }

    public Exam(HashMap<Integer, Question> questions, HashMap<Integer, String> submittedAnswers) {
        this.questions = new HashMap<>();
        this.questions.putAll(questions);
        this.submittedAnswers = new HashMap<>();
        this.submittedAnswers.putAll(submittedAnswers);
    }

    public Exam(LinkedList<Question> qlist) {
this.questions = new HashMap<>();
for(int i=0;i<qlist.size();i++){
    this.questions.put(i,qlist.get(i));
}
this.submittedAnswers=new HashMap<>();
    }

    public void clearQuestions() {
        this.questions.clear();
    }

    public Question getQuestion(int i) {

        return questions.get(i);
    }

    public String getSubmittedAnswer(int i) {
        return this.submittedAnswers.get(i);
    }

    public int getNumberOfQuestion() {
        return questions.size();
    }
    public void printAllQuestions() {
        for (int i = 0; i < questions.size(); i++) {
            System.out.println(questions.get(i));
        }
    }
}
