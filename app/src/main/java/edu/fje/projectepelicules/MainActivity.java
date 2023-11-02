package edu.fje.projectepelicules;

import static edu.fje.projectepelicules.Resources.TVShowImages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
        onCreate(savedInstanceState);
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

    private void initializeTVShows() {
        tvShowsSet = new HashSet<>();
        Resources resources = new Resources();
        Collections.addAll(tvShowsSet, resources.getTVShows());
    }

    // Modify loadRandomTVShow to reset the UI for retrying
    private void loadRandomTVShow() {
        if (tvShowsSet.isEmpty()) {
            return;
        }
        tvShowsSet.remove(currentTVShow);

        if (tvShowsSet.isEmpty()) {
            // Handle the case when there are no more TV shows left
            // You can display a message or perform any other desired action
            return;
        }

        // Select a new random TV show from the remaining set
        currentTVShow = tvShowsSet.iterator().next();

        // Display the new image
        imageView.setImageResource(currentTVShow.getImageResourceId());

        // Display the TV show name as the correct option
        List<String> options = getRandomOptions(currentTVShow.getName());
        Collections.shuffle(options);

        radioGroup.removeAllViews();
        for (String option : options) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(option);
            radioGroup.addView(radioButton);
        }

        checkButton.setEnabled(true);
        answerTextView.setVisibility(View.GONE);
        radioGroup.clearCheck();
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

    private TVShow getRandomTVShow() {
        List<TVShow> tvShowsList = new ArrayList<>(tvShowsSet);
        Collections.shuffle(tvShowsList);
        return tvShowsList.get(0);
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
                answerTextView.setText("¡Respuesta Correcta!");
                loadRandomTVShow();
            } else {
                answerTextView.setText("Respuesta Incorrecta");
            }
            answerTextView.setVisibility(View.VISIBLE);
        }
    }
}