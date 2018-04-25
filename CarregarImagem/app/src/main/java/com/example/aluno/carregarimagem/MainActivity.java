package com.example.aluno.carregarimagem;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button btnCarro;
    private Button btnMoto;
    private Button btnBicicleta;
    private ImageView imageView;
    private TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCarro = findViewById(R.id.btnCarro);
        btnMoto = findViewById(R.id.btnMoto);
        btnBicicleta = findViewById(R.id.btnBicicleta);
        imageView = findViewById(R.id.imageView);

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i != TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.ENGLISH);
                    textToSpeech.setSpeechRate(0.5f);
                }
            }
        });

        btnCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textToSpeech.speak(getResources().getString(R.string.carro), TextToSpeech.QUEUE_FLUSH, null);
                Picasso.get().load("http://4.bp.blogspot.com/-o5hCrkQ060k/Uv0HTmoDMOI/AAAAAAAAG84/qjoZrx1SWhQ/s1600/romisetta101.jpg").into(imageView);
            }
        });

        btnMoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textToSpeech.speak(getResources().getString(R.string.moto), TextToSpeech.QUEUE_FLUSH, null);
                Picasso.get().load("http://www.pastorecc.com.br/site/photos/cars/1354/bg_Zi7Wc0lM9M6mW3icmIVh.jpeg").into(imageView);
            }
        });

        btnBicicleta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textToSpeech.speak(getResources().getString(R.string.bicicleta), TextToSpeech.QUEUE_FLUSH, null);
                Picasso.get().load("https://static.wixstatic.com/media/cd0351_b4aa1bf09ce23c4d5383b83704c427d2.jpg/v1/fill/w_600,h_440,al_c,q_90/cd0351_b4aa1bf09ce23c4d5383b83704c427d2.webp").into(imageView);
            }
        });


    }
}
