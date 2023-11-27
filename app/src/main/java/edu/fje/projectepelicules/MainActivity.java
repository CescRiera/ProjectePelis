package edu.fje.projectepelicules;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private int PuntuacioTotal = 0;
    private ImageView imageView;
    private RadioGroup radioGroup;
    private Button checkButton;

    private Set<TVShow> tvShowsSet;
    private TVShow currentTVShow;
    private TextView hintTextView; //jd
    private ProgressBar progressBar; //jd



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        radioGroup = findViewById(R.id.radioGroup);
        checkButton = findViewById(R.id.checkButton);
        hintTextView = findViewById(R.id.hintTextView); //jd
        progressBar = findViewById(R.id.progressBar); //jd


        initializeTVShows();
        Metode.shuffleArray(tvShowsSet.toArray());

        loadRandomTVShow();

        checkButton.setOnClickListener(v -> checkAnswer());
    }


    private void initializeTVShows() {
        tvShowsSet = new HashSet<>();
        Resources recrusos = new Resources();
        Collections.addAll(tvShowsSet, recrusos.getTVShows());
    }

    private void loadRandomTVShow() {

        Resources recurs1 = new Resources();
        if (recurs1.NoQuedenImatges(tvShowsSet)) {
            moveToPantallaFinal();
        } else {


            // Select a new random TV show from the remaining set
            currentTVShow = Metode.getRandomTVShow(tvShowsSet);

            // Check if the selected TV show has a valid image ID
            if (currentTVShow.getImageResourceId() != -1) {
                // Display the new image
                imageView.setImageResource(currentTVShow.getImageResourceId());

                // Display the TV show name as the correct option
                List<String> options = Metode.getRandomOptions(currentTVShow.getName(), tvShowsSet);
                Collections.shuffle(options);

                int radioButtonsCount = radioGroup.getChildCount();
                for (int i = 0; i < radioButtonsCount; i++) {
                    RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
                    radioButton.setText(options.get(i));
                }

                checkButton.setEnabled(true);
                radioGroup.clearCheck();


            } else {
                loadRandomTVShow();
            }
        }
    }

    private void actualizarProgressBar() { //jd
        int progreso = calcularProgreso();
        progressBar.setProgress(progreso);
    }

    private int calcularProgreso() { //jd
        int totalPreguntas = tvShowsSet.size();
        int preguntasRespondidas = totalPreguntas - tvShowsSet.size();
        return (int) ((preguntasRespondidas / (float) totalPreguntas) * 100);
    }



    private void moveToPantallaFinal() {
        Intent intent = new Intent(MainActivity.this, PantallaFinal.class);
        intent.putExtra("FINAL_SCORE", PuntuacioTotal);
        startActivity(intent);
        finish();
    }

    private void mostrarPista(String hint) { //jd
        hintTextView.setText(hint);
    }

    private void checkAnswer() {
        int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);

        if (selectedRadioButton != null) {
            String selectedOption = selectedRadioButton.getText().toString();

            if (currentTVShow.getName().equals(selectedOption)) {
                int incorrectAttempts = currentTVShow.getIncorrectAttempts();
                int puntsShow = 4 - incorrectAttempts;
                PuntuacioTotal += puntsShow;
                tvShowsSet.remove(currentTVShow);
                actualizarProgressBar(); //jd
                loadRandomTVShow();
                hintTextView.setVisibility(View.GONE);


            } else {
                hintTextView.setVisibility(View.VISIBLE);
                mostrarPista(currentTVShow.getHint());
                currentTVShow.incrementIncorrectAttempts();
                if (currentTVShow.getIncorrectAttempts() == 4){
                    hintTextView.setVisibility(View.GONE);
                    tvShowsSet.remove(currentTVShow);
                    actualizarProgressBar(); //jd

                    loadRandomTVShow();

                }else{

                    imageView.setImageResource(currentTVShow.getImageResourceIdByAttempt());

                }

            }
        }
    }
}