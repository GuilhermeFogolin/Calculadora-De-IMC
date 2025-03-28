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

public class Obesidade3Activity extends AppCompatActivity {

    // Instanciando os elementos:
    private Button btnFecharObs3;
    private TextView tv_obs3_peso;
    private TextView tv_obs3_altura;
    private TextView tv_obs3_imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_obesidade3);

        Log.i("Ciclo de Vida", "Tela ObesidadeGrauIII - onCreate");

        btnFecharObs3 = findViewById(R.id.btnFecharObs3);
        tv_obs3_peso = findViewById(R.id.tv_obs3_peso);
        tv_obs3_altura = findViewById(R.id.tv_obs3_altura);
        tv_obs3_imc = findViewById(R.id.tv_obs3_imc);

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

        tv_obs3_peso.setText("Peso: " + resPeso + " kg");
        tv_obs3_altura.setText("Altura: " + resAltura + " m");
        tv_obs3_imc.setText("IMC: " + imcFormatado + " kg/m²");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de Vida", "Tela ObesidadeGrauIII - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de Vida", "Tela ObesidadeGrauIII - onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela ObesidadeGrauIII - onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de Vida", "Tela ObesidadeGrauIII - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela ObesidadeGrauIII - onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de Vida", "Tela ObesidadeGrauIII - onStart");
    }

    // Função para retornar para tela principal:
    public void fechar(View v) {
        Intent intent = new Intent(Obesidade3Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}