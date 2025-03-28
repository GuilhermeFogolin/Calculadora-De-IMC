package br.com.fecapccp.calculadoraparaimc;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class CalculoIMCActivity extends AppCompatActivity {

    // Instanciando os elementos:

    private Button btnCalcular;
    private Button btnLimpar;
    private Button btnFechar;
    private EditText etPeso;
    private EditText etAltura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculo_imcactivity);

        Log.i("Ciclo de Vida", "Tela Cálculos - onCreate");

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFechar = findViewById(R.id.btnFechar);
        etPeso = findViewById(R.id.et_peso);
        etAltura = findViewById(R.id.et_altura);

        btnCalcular.setOnClickListener(view -> {
            calcularIMC();
        });

        btnFechar.setOnClickListener(view -> {
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de Vida", "Tela Cálculos - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de Vida", "Tela Cálculos - onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela Cálculos - onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de Vida", "Tela Cálculos - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela Cálculos - onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de Vida", "Tela Cálculos - onStart");
    }

    private void calcularIMC() {

        String peso = etPeso.getText().toString();
        String altura = etAltura.getText().toString();

        // Converter os dados peso e altura em NUMÉRICO e calcular o IMC:

        double numPeso = Double.parseDouble(peso);
        double numAltura = Double.parseDouble(altura);
        double calcular = numPeso / (numAltura * numAltura);

        // Validação de IMC:

        Intent intent = null;

        if(calcular < 18.5) {
            intent = new Intent(this, AbaixoDoPesoActivity.class);
        } else if(calcular < 25) {
            intent = new Intent(this, PesoNormalActivity.class);
        } else if(calcular < 30) {
            intent = new Intent(this, SobrepesoActivity.class);
        } else if(calcular < 35) {
            intent = new Intent(this, Obesidade1Activity.class);
        }

        // Recuperando valores e inicializando a intent

        intent.putExtra("resultado", calcular);
        intent.putExtra("peso", numPeso);
        intent.putExtra("altura", numAltura);

        startActivity(intent);
    }

    public void limpar(View v) {

        etPeso.setText(""); // Apaga o conteúdo do campo de Peso
        etAltura.setText(""); // Apaga o conteúdo do campo de Altura
    }
}