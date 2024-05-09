package com.champqcsoft.champexamen_by_olivier;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class ChampexamenApplication extends Application {

    private Exam exam;
    private Label labelShowingGrade;
    private VBox[] questionVboxes;
    private VBox root;

    public void button() {
        Button prevButton = new Button("Clear");
        prevButton.setOnAction(e -> clearExamAnswers());
        Button nextButton = new Button("Save");
        nextButton.setOnAction(e -> saveExamAnswers());
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(new SubmitButtonHandler());

    }

    public VBox buildMCQ(int questionNumber, MCQQuestion mcqQuestion)   {
        VBox MCQvBox = new VBox(15);
       String st = String.format("%d) %s", questionNumber + 1, mcqQuestion.getQuestionText());
       Label mcqLabel = new Label(st);

       ToggleGroup mcqToggle = new ToggleGroup();
       RadioButton optA = new RadioButton("a) " + mcqQuestion.getOptions().get(0));
        RadioButton optB = new RadioButton("b) " + mcqQuestion.getOptions().get(1));
        RadioButton optC = new RadioButton("c) " + mcqQuestion.getOptions().get(2));
        RadioButton optD = new RadioButton("d) " + mcqQuestion.getOptions().get(3));

        optA.setToggleGroup(mcqToggle);
        optA.setOnAction(e -> setQuestionAnswer(questionNumber, "a"));
        optB.setToggleGroup(mcqToggle);
        optB.setOnAction(e -> setQuestionAnswer(questionNumber, "b"));
        optC.setToggleGroup(mcqToggle);
        optC.setOnAction(e -> setQuestionAnswer(questionNumber, "c"));
        optD.setToggleGroup(mcqToggle);
        optD.setOnAction(e -> setQuestionAnswer(questionNumber, "d"));

       MCQvBox.setPadding(new Insets(15));
       MCQvBox.getChildren().addAll(mcqLabel,optA,optB,optC,optD);
        return MCQvBox;
    }

    public MenuBar buildMenue() {
        MenuBar mb = new MenuBar();

        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu quiz = new Menu ("Quiz");
        Menu extras = new Menu ("Extras");
        Menu help = new Menu("Help");

        MenuItem open = new MenuItem("Open");
        MenuItem save = new MenuItem("Save");
        MenuItem exit = new MenuItem("Exit");

        MenuItem cut = new MenuItem("Cut");
        MenuItem copy = new MenuItem("Copy");
        MenuItem paste = new MenuItem("Paste");

        MenuItem start = new MenuItem("Start QUiz");
        MenuItem view = new MenuItem("View Results");

        MenuItem settings = new MenuItem("Settings");
        MenuItem about = new MenuItem("About");

        MenuItem helpContent = new MenuItem("Help Content");
        MenuItem aboutApp = new MenuItem("About App");

        file.getItems().add(open);
        file.getItems().add(save);
        file.getItems().add(exit);

        edit.getItems().add(cut);
        edit.getItems().add(copy);
        edit.getItems().add(paste);

        quiz.getItems().add(start);
        quiz.getItems().add(view);

        extras.getItems().add(settings);
        extras.getItems().add(about);

        help.getItems().add(helpContent);
        help.getItems().add(aboutApp);

mb.getMenus().add(file);
mb.getMenus().add(edit);
        mb.getMenus().add(quiz);
        mb.getMenus().add(extras);
        mb.getMenus().add(help);
        return mb;
    }

    public HBox buildNavigationBar() {
        HBox hBox = new HBox();

        Button prevButton = new Button("Clear");
        prevButton.setOnAction(e -> clearExamAnswers());
        Button nextButton = new Button("Save");
        nextButton.setOnAction(e -> saveExamAnswers());
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(new SubmitButtonHandler());

        hBox.getChildren().add(prevButton);
        hBox.getChildren().add(nextButton);
        hBox.getChildren().add(submitButton);

        return hBox;
    }

    public HBox buildTopBanner() {
        HBox topBanner = new HBox();
       File imgONE = new File ("C:\\Users\\olivi\\IdeaProjects\\ChampExamen_by_Olivier\\src\\main\\resources\\quiz.png");
        Image img1 = new Image(imgONE.toURI().toString());
        ImageView viewimg1 = new ImageView(img1);
        viewimg1.setFitHeight(250);
        viewimg1.setFitWidth(500);
        File giffy = new File("C:\\Users\\olivi\\IdeaProjects\\ChampExamen_by_Olivier\\src\\main\\resources\\giphy.gif");
        Image img2 = new Image(giffy.toURI().toString());
        ImageView viewimg2 = new ImageView(img2);
viewimg2.setFitWidth(300);
viewimg2.setFitHeight(250);
topBanner.setAlignment(Pos.CENTER);
       topBanner.getChildren().addAll(viewimg2,viewimg1);
        return topBanner;
    }

    public VBox buildTrueFalseQ(int questionNumber, TFQQuestion tfqQuestion) {
        VBox tfqvBox = new VBox(15);

        String st = String.format("%d) %s",questionNumber + 1, tfqQuestion.getQuestionText());
        Label qlabel = new Label(st);
        ToggleGroup tfqgroup =new ToggleGroup();
        RadioButton optA = new RadioButton("True");
        RadioButton optB = new RadioButton("False");
        optA.setToggleGroup(tfqgroup);
        optB.setToggleGroup(tfqgroup);
        optA.setOnAction(e -> setQuestionAnswer(questionNumber,"True"));
        optB.setOnAction(e -> setQuestionAnswer(questionNumber, "False"));

        tfqvBox.setPadding(new Insets(15));
        tfqvBox.getChildren().addAll(qlabel,optA,optB);
        return tfqvBox;
    }

    private void clearExamAnswers() {
      //not need to code and not requested
    }

    public String convertBoolToString(boolean b) {

        //not asked to code
        return "";
    }

    private VBox[] createExamPage(Exam exam) throws FileNotFoundException{
        VBox[] questionVboxes = new VBox[exam.getNumberOfQuestion()];


        for (int i = 0; i < exam.getNumberOfQuestion(); i++) {
            Question question = exam.questions.get(i);

            if (question.getQuestionType() == QuestionType.TFQ) {
                questionVboxes[i] = buildTrueFalseQ(i, (TFQQuestion) question);
            }
            else if(question.getQuestionType() == QuestionType.MCQ) {
                questionVboxes[i] = buildMCQ(i, (MCQQuestion) question);
            }else{

            }
        }

        return questionVboxes;
    }

   private VBox createQuestionVBox(int questionNumber, Question question) throws FileNotFoundException{
        VBox vBox;
        if (question.getQuestionType() == QuestionType.TFQ) {
                vBox = buildTrueFalseQ(questionNumber, (TFQQuestion) question);
            }
         else {
                vBox = buildMCQ(questionNumber, (MCQQuestion) question);
            }
            vBox.setAlignment(Pos.CENTER);
        return vBox;
    }

    public static void main(String[] args) throws FileNotFoundException {
        launch();

    }

    private void saveExamAnswers() {
//was told not to code it
    }

    class SubmitButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            int counter = 0;
            for (int i = 0; i < exam.questions.size(); i++) {
                Question q =exam.getQuestion(i);
                if (q.getCorrectAnswer().equalsIgnoreCase(exam.submittedAnswers.get(i))) {
                    counter++;

                }
            }
            labelShowingGrade.setText(String.format("Grade: %d / %d", counter, exam.getNumberOfQuestion()));
        }
    }
    public void setQuestionAnswer(int questionNumber,String questionAnswer){
this.exam.submittedAnswers.put(questionNumber,questionAnswer);
    }

    public void start(Stage primaryStage) throws IOException {

        Image image;
        VBox root = new VBox();

        labelShowingGrade = new Label("Grade: ");
        labelShowingGrade.setFont(Font.font(10));
        HBox grdBox = new HBox(labelShowingGrade);
        grdBox.setAlignment(Pos.CENTER);

        QuestionBank qb = new QuestionBank();
        qb.readMCQ("C:\\Users\\olivi\\IdeaProjects\\ChampExamen_by_Olivier\\src\\mcq.txt");
        qb.readTFQ("C:\\Users\\olivi\\IdeaProjects\\ChampExamen_by_Olivier\\src\\tfq.txt");

        //The instructions asked for 10 questions. I tested and it works with 10, simply change the 4 following occurences of the number 64 by 10
        //I used 64 since it is the total amount of questions in the document and allowed me to verify everything worked perfectly for every single one
        Random r = new Random();
        int num = 0;
        ArrayList arrayList = new ArrayList(64); //change 64 here to 10
        int[] selectRand = new int[64]; //change 64 here to 10
        int counter=0;
        while(counter<64){ //change 64 here to 10
            num = r.nextInt(64); //Finally change 64 here to 10 and voila everything works!
            if(!arrayList.contains(num)){
                arrayList.add(num);
                counter++;
            }
        }
        for(int i=0;i<arrayList.size();i++){
            selectRand[i] = (int) arrayList.get(i);
        }
        LinkedList<Question> examQ = qb.selectRandQuestions(selectRand);
        this.exam = new Exam(examQ);

        root.getChildren().clear();
        MenuBar menuBar = new MenuBar();
        menuBar=buildMenue();
        root.getChildren().add(menuBar);
        HBox hBoxTop = buildTopBanner();
        hBoxTop.setPadding(new Insets(20));
        root.getChildren().add(hBoxTop);
        root.getChildren().add(grdBox);

        HBox hboxNav = new HBox( buildNavigationBar());
        hboxNav.setAlignment(Pos.CENTER);
        root.getChildren().add(hboxNav);


        this.questionVboxes = createExamPage(this.exam);
        VBox holder = new VBox();
        holder.getChildren().addAll(this.questionVboxes);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(holder);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        root.getChildren().add(scrollPane);


        Scene scene = new Scene(root, 320, 240);

        primaryStage.setTitle("Champexamen app");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}