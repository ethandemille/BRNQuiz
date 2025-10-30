package com.exam.brnquiz;

public class Question {

    String[] answers = {"Medellin","Madrid","Paris","Bogota"};
    String question = "What is the capital of Colombia?";
    int correctIndex = 3;

    public Question() {

    }

    public String getQuestion() {
        return question;
    }

    public int getCorrectIndex() {
        return correctIndex;
    }

    public String getAnswers(int i) {
        return answers[i];
    }
}
