package com.exam.brnquiz;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.exam.brnquiz.model.Question;

import java.util.ArrayList;
import java.util.List;

public class BRNViewModel extends ViewModel {
    private final MutableLiveData<List<Question>> questions = new MutableLiveData<>(new ArrayList<>());
    private final MutableLiveData<Integer> nCorrect = new MutableLiveData<>();
    private final MutableLiveData<Integer> score = new MutableLiveData<>(0);

    public MutableLiveData<Integer> getScore() {
        return score;
    }

    public void increaseScore() {
        Integer current = score.getValue();
        if(current == null)
            current = 0;
        score.setValue(current + 1);
    }

    public void addQuestion(Question q) {
        List<Question> current = questions.getValue();

        if (current == null) {
            current = new ArrayList<>();
        }

        current.add(q);
        questions.setValue(current);
    }

    public MutableLiveData<List<Question>> getQuestion() {
        return questions;
    }

    public MutableLiveData<Integer> getnCorrect() {
        return nCorrect;
    }
}
