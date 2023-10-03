package alberto.cano.contadorvehiculos.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import alberto.cano.contadorvehiculos.R;
import alberto.cano.contadorvehiculos.modelos.Coche;

public class ContadorMotos extends AppCompatActivity {
    private EditText editTextMarcaMoto;
    private EditText editTextModeloMoto;
    private EditText editTextCilindrada;

    private Button buttonCancelarCrearMoto;
    private Button buttonCrearCrearMoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador_motos);

        inicializarVariables();

        buttonCancelarCrearMoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });


        buttonCrearCrearMoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String marca = editTextMarcaMoto.getText().toString();
                String modelo = editTextModeloMoto.getText().toString();
                String cilindrada = editTextCilindrada.getText().toString();

                if (marca.isEmpty() || modelo.isEmpty() || cilindrada.isEmpty()){
                    Toast.makeText(ContadorMotos.this, "Faltan Datos", Toast.LENGTH_SHORT).show();
                }else{
                    Coche moto = new Coche(marca, modelo, cilindrada);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("MOTO", moto);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);


                    setResult(RESULT_OK);
                    finish();
                }
            }
        });


    }


    private void inicializarVariables() {
        editTextMarcaMoto = findViewById(R.id.editTextMarcaMoto);
        editTextModeloMoto = findViewById(R.id.editTextModeloMoto);
        editTextCilindrada = findViewById(R.id.editTextCilindrada);

        //Los botones
        buttonCancelarCrearMoto = findViewById(R.id.buttonCancelarCrearMoto);
        buttonCrearCrearMoto = findViewById(R.id.buttonCrearCrearMoto);
    }
}