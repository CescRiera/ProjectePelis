package edu.fje.projectepelicules;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PantallaFinal extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_final_activity);

        // Recuperar la puntuación pasada desde MainActivity
        int score = getIntent().getIntExtra("FINAL_SCORE", 0); // Use "FINAL_SCORE" here

        // Mostrar la puntuación en un TextView
        TextView scoreTextView = findViewById(R.id.textViewScore);
        scoreTextView.setText("Tu puntuación: " + score + " / 40");
    }
}

