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

public class Obesidade2Activity extends AppCompatActivity {

    // Instanciando os elementos:
    private Button btnFecharObs2;
    private TextView tv_obs2_peso;
    private TextView tv_obs2_altura;
    private TextView tv_obs2_imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade2);

        Log.i("Ciclo de Vida", "Tela ObesidadeGrauII - onCreate");

        btnFecharObs2 = findViewById(R.id.btnFecharObs2);
        tv_obs2_peso = findViewById(R.id.tv_obs2_peso);
        tv_obs2_altura = findViewById(R.id.tv_obs2_altura);
        tv_obs2_imc = findViewById(R.id.tv_obs2_imc);

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

        tv_obs2_peso.setText("Peso: " + resPeso + " kg");
        tv_obs2_altura.setText("Altura: " + resAltura + " m");
        tv_obs2_imc.setText("IMC: " + imcFormatado + " kg/m²");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de Vida", "Tela ObesidadeGrauII - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de Vida", "Tela ObesidadeGrauII - onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela ObesidadeGrauII - onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de Vida", "Tela ObesidadeGrauII - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela ObesidadeGrauII - onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de Vida", "Tela ObesidadeGrauII - onStart");
    }

    // Função para retornar para tela principal:
    public void fechar(View v) {
        Intent intent = new Intent(Obesidade2Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}