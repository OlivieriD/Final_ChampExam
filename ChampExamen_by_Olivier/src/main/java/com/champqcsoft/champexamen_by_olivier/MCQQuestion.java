package com.champqcsoft.champexamen_by_olivier;

import java.util.LinkedList;

public class MCQQuestion extends Question{
    private LinkedList <String> options;

public MCQQuestion(){
    super("","",QuestionType.MCQ);
    this.options = new LinkedList<>();
}

    public MCQQuestion(LinkedList<String> options) {
        super("","",QuestionType.MCQ);
        this.options = new LinkedList<>();
        this.options.addAll(options);
    }


    public MCQQuestion(String correctAnswer, String questionText, LinkedList <String> options) {
        super(correctAnswer, questionText, QuestionType.MCQ);
        this.options = new LinkedList<>();
        this.options.addAll(options);
    }
    public void setOptions(LinkedList<String> options) {
        this.options = options;
    }
    public LinkedList<String> getOptions() {
        return options;
    }

    /*public String toString() {
    String str;
    str = this.getQuestionText();
            for (int i = 0; i < options.size(); i++) {
                    str = str + "\n" + options.get(i);
            }
        return str;
    }

     */
}
