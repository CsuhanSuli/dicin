package com.example.dicin;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ImageView horse1 = findViewById(R.id.horse1);
        ImageView horse2 = findViewById(R.id.horse2);
        ImageView horse3 = findViewById(R.id.horse3);
        ImageView[] horses = {horse1,horse2,horse3};
        ImageView dice1 = findViewById(R.id.dice1);
        ImageView dice2 = findViewById(R.id.dice2);
        ImageView dice3 = findViewById(R.id.dice3);
        ImageView[] dices = {dice1,dice2,dice3};
        Button start = findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] horsespeed = {(int)(Math.random() * 6),(int)(Math.random() * 6),(int)(Math.random() * 6)};
                int[] dices = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
                dice1.setImageResource(dices[horsespeed[0]]);
                dice2.setImageResource(dices[horsespeed[1]]);
                dice3.setImageResource(dices[horsespeed[2]]);
                int speed = 50;
                int horse1x = (int) horse1.getTranslationX();
                horse1x += horsespeed[0]*speed;
                horse1.setTranslationX(horse1x);

                int horse2x = (int) horse2.getTranslationX();
                horse2x += horsespeed[1]*speed;
                horse2.setTranslationX(horse2x);

                int horse3x = (int) horse3.getTranslationX();
                horse3x += horsespeed[2]*speed;
                horse3.setTranslationX(horse3x);



            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
