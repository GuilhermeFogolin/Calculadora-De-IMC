package br.com.fecapccp.calculadoraparaimc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class AbaixoDoPesoActivity extends AppCompatActivity {

    // Instanciando os elementos:
    private Button btnFecharAbaixoDoPeso;
    private TextView tv_abaixo_peso;
    private TextView tv_abaixo_altura;
    private TextView tv_abaixo_imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_abaixo_do_peso);

        Log.i("Ciclo de Vida", "Tela Abaixo do Peso - onCreate");

        btnFecharAbaixoDoPeso = findViewById(R.id.btnFecharAbaixoDoPeso);
        tv_abaixo_peso = findViewById(R.id.tv_abaixo_peso);
        tv_abaixo_altura = findViewById(R.id.tv_abaixo_altura);
        tv_abaixo_imc = findViewById(R.id.tv_abaixo_imc);

        // Recebendo os dados da CalculoIMCActivity: Intent e itens extras.

        Bundle bundle = getIntent().getExtras();

        double peso     = bundle.getDouble("peso"); // Colocar nome da KEY do bundle.
        double altura   = bundle.getDouble("altura");
        double calcular = bundle.getDouble("resultado");

        // Setando os dados peso e altura:

        String resPeso = String.valueOf(peso);
        String resAltura = String.valueOf(altura);

        // Formatando resultado do IMC com três casas decimais:

        DecimalFormat df = new DecimalFormat("##.###");
        String imcFormatado = df.format(calcular);

        // Imprimindo resultados:

        tv_abaixo_peso.setText("Peso: " + resPeso + " kg");
        tv_abaixo_altura.setText("Altura: " + resAltura + " m");
        tv_abaixo_imc.setText("IMC: " + imcFormatado + " kg/m²");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de Vida", "Tela Abaixo do Peso - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de Vida", "Tela Abaixo do Peso - onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela Abaixo do Peso - onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de Vida", "Tela Abaixo do Peso - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela Abaixo do Peso - onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de Vida", "Tela Abaixo do Peso - onStart");
    }

    // Função para retornar para tela principal:
    public void fechar(View v) {
        Intent intent = new Intent(AbaixoDoPesoActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}