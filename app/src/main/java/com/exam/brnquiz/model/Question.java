package com.exam.brnquiz.model;

public class Question {

    String[] answers = {"Medellin","Madrid","Paris","Bogota"};
    String question = "What is the capital of Colombia?";
    int correctIndex = 3;

    public Question() {

    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public void setCorrectIndex(int correctIndex) {
        this.correctIndex = correctIndex;
    }

    public void setQuestion(String question) {
        this.question = question;
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
