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

public class Obesidade1Activity extends AppCompatActivity {

    // Instanciando os elementos:
    private Button btnFecharObs1;
    private TextView tv_obs1_peso;
    private TextView tv_obs1_altura;
    private TextView tv_obs1_imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade1);

        Log.i("Ciclo de Vida", "Tela Sobrepeso - onCreate");

        btnFecharObs1 = findViewById(R.id.btnFecharObs1);
        tv_obs1_peso = findViewById(R.id.tv_obs1_peso);
        tv_obs1_altura = findViewById(R.id.tv_obs1_altura);
        tv_obs1_imc = findViewById(R.id.tv_obs1_imc);

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

        tv_obs1_peso.setText("Peso: " + resPeso + " kg");
        tv_obs1_altura.setText("Altura: " + resAltura + " m");
        tv_obs1_imc.setText("IMC: " + imcFormatado + " kg/m²");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de Vida", "Tela ObesidadeGrauI - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de Vida", "Tela ObesidadeGrauI - onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela ObesidadeGrauI - onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de Vida", "Tela ObesidadeGrauI - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela ObesidadeGrauI - onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de Vida", "Tela ObesidadeGrauI - onStart");
    }

    // Função para retornar para tela principal:
    public void fechar(View v) {
        Intent intent = new Intent(Obesidade1Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}