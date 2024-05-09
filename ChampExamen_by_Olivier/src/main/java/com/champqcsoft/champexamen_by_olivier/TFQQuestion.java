package com.champqcsoft.champexamen_by_olivier;

import java.util.LinkedList;

public class TFQQuestion extends Question{


    public TFQQuestion(){
        super("","",QuestionType.TFQ);
    }

    public TFQQuestion(String correctAnswer, String questionText) {
        super(correctAnswer, questionText, QuestionType.TFQ);
    }

  /*public String toString() {
        String str;
        str = this.getQuestionText() + "\n";
        str = str + "True" + "\n" + "False";
        return str;
    }


   */

}
