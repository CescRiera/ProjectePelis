package edu.fje.projectepelicules;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private RadioGroup radioGroup;
    private Button checkButton;
    private TextView answerTextView;
    private Set<TVShow> tvShowsSet;
    private TVShow currentTVShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        radioGroup = findViewById(R.id.radioGroup);
        checkButton = findViewById(R.id.checkButton);
        answerTextView = findViewById(R.id.answerTextView);

        initializeTVShows();
        Metode.shuffleArray(tvShowsSet.toArray());

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });

        loadRandomTVShow();
    }

    private TVShow getRandomTVShow() {
        List<TVShow> tvShowsList = new ArrayList<>(tvShowsSet);
        Collections.shuffle(tvShowsList);
        return tvShowsList.get(0);
    }

    private void initializeTVShows() {
        tvShowsSet = new HashSet<>();
        Resources resources = new Resources();
        Collections.addAll(tvShowsSet, resources.getTVShows());
    }

    // Modify loadRandomTVShow to reset the UI for retrying
    private void loadRandomTVShow() {
        // Select a new random TV show from the remaining set
        currentTVShow = getRandomTVShow();

        // Check if the selected TV show has a valid image ID
        if (currentTVShow.getImageResourceId() != -1) {
            // Display the new image
            imageView.setImageResource(currentTVShow.getImageResourceId());

            // Display the TV show name as the correct option
            List<String> options = getRandomOptions(currentTVShow.getName());
            Collections.shuffle(options);

            int radioButtonsCount = radioGroup.getChildCount();
            for (int i = 0; i < radioButtonsCount; i++) {
                RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
                radioButton.setText(options.get(i));
            }

            checkButton.setEnabled(true);
            answerTextView.setVisibility(View.GONE);
            radioGroup.clearCheck();
        } else {
            // Handle the case where the TV show has no image ID
            // You can choose to skip this TV show and load another one or handle it as needed.
            loadRandomTVShow();
        }
    }


    private List<String> getRandomOptions(String correctOption) {
        List<String> options = new ArrayList<>();
        options.add(correctOption);

        while (options.size() < 4) {
            TVShow randomTVShow = getRandomTVShow();
            if (!options.contains(randomTVShow.getName())) {
                options.add(randomTVShow.getName());
            }
        }

        return options;
    }

    private void checkAnswer() {
        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

        if (selectedRadioButton != null) {
            String selectedOption = selectedRadioButton.getText().toString();
            boolean isCorrect = false;

            for (TVShow tvShow : tvShowsSet) {
                if (currentTVShow.getName().equals(selectedOption)) {
                    isCorrect = true;
                    break;
                }
            }

            if (isCorrect) {
                tvShowsSet.remove(currentTVShow);
                loadRandomTVShow();
            } else {
                tvShowsSet.remove(currentTVShow);
                loadRandomTVShow();
            }
            answerTextView.setVisibility(View.VISIBLE);
        }
    }
}