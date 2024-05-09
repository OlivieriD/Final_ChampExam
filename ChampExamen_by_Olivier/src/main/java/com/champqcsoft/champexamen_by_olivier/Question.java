package com.champqcsoft.champexamen_by_olivier;

public class  Question {
    private String correctAnswer;
    private String questionText;
    private QuestionType questionType;

public Question(){
        this.correctAnswer = "";
        this.questionText = "";
        this.questionType = null;
}
public Question(String correctAnswer,String questionText,QuestionType questionType){
    this.correctAnswer = correctAnswer;
    this.questionText = questionText;
    this.questionType = questionType;
}

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    //not sure about what to print

    public boolean checkAnswer(String answer){
    String ca = this.correctAnswer.trim();
    return correctAnswer.equalsIgnoreCase(ca.trim());
    }
}
