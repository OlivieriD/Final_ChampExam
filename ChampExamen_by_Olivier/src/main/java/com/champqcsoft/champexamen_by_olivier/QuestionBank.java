package com.champqcsoft.champexamen_by_olivier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.random.RandomGenerator;

public class QuestionBank {
    protected LinkedList<Question> questions;

    public QuestionBank(LinkedList<Question> questions) {
        this.questions = new LinkedList<>();
        this.questions.addAll(questions);
    }

    public QuestionBank() {
this.questions = new LinkedList<>();
    }

    public void clearQuestions() {
        this.questions.clear();
    }


    public Question getQuestion(int i) {
        return questions.get(i);
    }

    public void printAllQuestions() {
        Iterator it = questions.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

    public void readMCQ(String fname) throws FileNotFoundException {
        File f = new File(fname);
        Scanner sc = new Scanner(f);
        LinkedList <String> ll = new LinkedList<>();
        while (sc.hasNext()) {

            String questionText = sc.nextLine();
            questionText = questionText.substring(4);
            String optionA = sc.nextLine();
            optionA = optionA.substring(3);
            ll.add(optionA);
            String optionB = sc.nextLine();
            optionB = optionB.substring(3);
            ll.add(optionB);
            String optionC = sc.nextLine();
            optionC = optionC.substring(3);
            ll.add(optionC);
            String optionD = sc.nextLine();
            optionD = optionD.substring(3);
            ll.add(optionD);
            String correctAnswer = sc.nextLine();
            String parts[] =correctAnswer.split(": ");
            correctAnswer=parts[1];
            MCQQuestion q = new MCQQuestion(correctAnswer,questionText, ll);
            ll.clear();
            this.questions.add(q);
        }
    }

    public void readTFQ(String fname) throws FileNotFoundException {
        File f = new File(fname);
        Scanner sc = new Scanner(f);
        LinkedList<String> ll = new LinkedList<>();
        while (sc.hasNext()) {
            String questionText = sc.nextLine();
            questionText = questionText.substring(4);
            String answer = sc.nextLine();
            String parts[] = answer.split(": ");
            answer = parts[1];
            TFQQuestion q = new TFQQuestion(answer,questionText);
            this.questions.add(q);
        }
    }

    public LinkedList<Question> selectRandQuestions(int[] indices) {
        LinkedList<Question> rdmques = new LinkedList<>();
        int index;
        Question q;
        for (int i = 0; i < indices.length; i++) {
            index = indices[i];
            q = questions.get(index);
            rdmques.add(q);
        }
        return rdmques;
    }
}
