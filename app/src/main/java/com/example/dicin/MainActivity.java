package com.example.dicin;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Vibrator;

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
        Vibrator vibrator = this.getSystemService(Vibrator.class);
        int speed = 50;
        int[] dicesImg = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};
        int[] soundLinks = {R.raw.horse1,R.raw.horse2,R.raw.horse3,R.raw.horse4,R.raw.horse5};
        Button start = findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //normal movement and gameplay
                int[] horsespeed = {(int)(Math.random() * 6),(int)(Math.random() * 6),(int)(Math.random() * 6)};
                for (int i = 0; i < 3; i++)
                {
                    dices[i].setImageResource(dicesImg[horsespeed[i]]);
                    int x = (int)horses[i].getTranslationX();
                    x += horsespeed[i] * speed;
                    horses[i].setTranslationX(x);
                }
                //sounds
                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,soundLinks[(int)(Math.random()*5)]);
                mediaPlayer.setVolume(50,50);
                mediaPlayer.start();
                //vibration
                vibrator.vibrate(VibrationEffect.createOneShot(300,200));
                //notification

            }
        });
        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 3; i++)
                {
                    int x = 10;
                    horses[i].setTranslationX(x);
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
