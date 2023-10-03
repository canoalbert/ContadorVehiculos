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

public class ContadorCoches extends AppCompatActivity {
    //ATRIBUTOS DE LA LISTA
    private EditText editTextMarcaCoche;
    private EditText editTextModeloCoche;
    private EditText editTextColorCoche;

    private Button buttonCancelarCrearCoche;
    private Button buttonCrearCrearCoche;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador_coches);

        inicializarVariables();

        buttonCancelarCrearCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });


        buttonCrearCrearCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String marca = editTextMarcaCoche.getText().toString();
                String modelo = editTextModeloCoche.getText().toString();
                String color = editTextColorCoche.getText().toString();

                if (marca.isEmpty() || modelo.isEmpty() || color.isEmpty()){
                    Toast.makeText(ContadorCoches.this, "Faltan Datos", Toast.LENGTH_SHORT).show();
                }else{
                    Coche coche = new Coche(marca, modelo, color);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("COCHE", coche);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);


                    setResult(RESULT_OK);
                    finish();
                }
            }
        });


    }


    private void inicializarVariables() {
        editTextMarcaCoche = findViewById(R.id.editTextMarcaCoche);
        editTextModeloCoche = findViewById(R.id.editTextModeloCoche);
        editTextColorCoche = findViewById(R.id.editTextColorCoche);

        //Los botones
        buttonCancelarCrearCoche = findViewById(R.id.buttonCancelarCrearCoche);
        buttonCrearCrearCoche = findViewById(R.id.buttonCrearCrearCoche);
    }
}