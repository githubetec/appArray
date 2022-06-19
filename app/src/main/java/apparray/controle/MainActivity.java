package apparray.controle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] nomes = new String[3];
    int idx = 0;
    float[] notas = new float[3];
    float media;

    Button btnSalvar, btnCalcular;
    EditText edtNotas;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNotas=findViewById(R.id.edtNotas);
        txtResultado=findViewById(R.id.txtResultado);
        btnSalvar=findViewById(R.id.btnSalvar);
        btnCalcular=findViewById(R.id.btnCalcular);
        btnCalcular.setEnabled(false);
    }

    public void Salvar(View view) {
        notas[idx] = Float.parseFloat(edtNotas.getText().toString());
        idx++;
        edtNotas.setText("");
        if(idx == 3 ) {
            edtNotas.setEnabled(false);
            btnSalvar.setEnabled(false);
            btnCalcular.setEnabled(true);
        }
    }

    public void Calcular(View view) {
        for(int i=0;i<=idx-1;i++) {
            media=media+notas[i];
        }
        media=media/idx;
        txtResultado.setText(String.valueOf(media));
        btnCalcular.setEnabled(false);
        btnSalvar.setEnabled(true);
        edtNotas.setEnabled(true);
        idx=0;
    }

}