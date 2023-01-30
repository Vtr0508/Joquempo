package br.com.victor.joquempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("Pedra");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("Tesoura");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("Papel");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {

        ImageView imagemApp = findViewById(R.id.imageview_padrao);
        TextView textViewResultado = findViewById(R.id.textview_resultado);
        int numero = new Random().nextInt(3);
        String[] opcoes = {"Papel", "Tesoura", "Pedra"};
        String opcoesApp = opcoes[numero];

        if (opcoesApp == "Papel") {
            imagemApp.setImageResource(R.drawable.papel);


        } else if (opcoesApp == "Tesoura") {
            imagemApp.setImageResource(R.drawable.tesoura);
        } else {
            imagemApp.setImageResource(R.drawable.pedra);
        }

        if ((opcoesApp == "Papel" && opcaoSelecionada == "Pedra") ||
                (opcoesApp == "Pedra" && opcaoSelecionada == "Tesoura") ||
                (opcoesApp == "Tesoura" && opcaoSelecionada == "Papel")) {

            textViewResultado.setText("Voce perdeu");


            Toast.makeText(this, "Voce perdeu!", Toast.LENGTH_SHORT);
        } else if ((opcaoSelecionada == "Papel" && opcoesApp == "Pedra") ||
                (opcaoSelecionada == "Pedra" && opcoesApp == "Tesoura") ||
                (opcaoSelecionada == "Tesoura" && opcoesApp == "Papel")) {

            textViewResultado.setText("Voce ganhou");

        } else {
            textViewResultado.setText("Empatou");
        }

    }
}