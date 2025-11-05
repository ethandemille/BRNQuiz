package com.exam.brnquiz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.exam.brnquiz.model.Question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {

    private ArrayAdapter<String> adapter;
    private ArrayList<String> qList;
    private ListView listView;
    private Button submitButton;
    private Question q;
    private TextView tvQuestion;
    BRNViewModel model;

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    final int[] a = new int[1];

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.listQ);
        submitButton = view.findViewById(R.id.submitButton);
        tvQuestion = view.findViewById(R.id.tvQuestion);

        model = new
                ViewModelProvider(getActivity()).get(BRNViewModel.class);
        model.addQuestion(new Question());
        model.getQuestion().observe(getViewLifecycleOwner(), new Observer<List<Question>>() {
            @Override
            public void onChanged(List<Question> questions) {

                q = questions.get(0);
                tvQuestion.setText(q.getQuestion());
                qList = new ArrayList<>();
                qList.add(q.getAnswers(0));
                qList.add(q.getAnswers(1));
                qList.add(q.getAnswers(2));
                qList.add(q.getAnswers(3));

                adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, qList);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        a[0] = qList.indexOf(qList.get(position));
                    }
                });
            }
        });


//        qList = new ArrayList<>();
//        qList.add(q.getAnswers(0));
//        qList.add(q.getAnswers(1));
//        qList.add(q.getAnswers(2));
//        qList.add(q.getAnswers(3));
//        qList.add("Medellin");
//        qList.add("Madrid");
//        qList.add("Paris");
//        qList.add("Bogota");

        //adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, qList);
        //listView.setAdapter(adapter);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(a[0] == q.getCorrectIndex()){
                    Toast.makeText(getContext(), "Yay! +1 Point", Toast.LENGTH_LONG).show();
                    model.increaseScore();
                }
                else{
                    Toast.makeText(getContext(), "Wrong! Use Your BRN(AI)", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}