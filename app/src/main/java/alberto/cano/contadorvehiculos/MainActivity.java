package alberto.cano.contadorvehiculos;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import alberto.cano.contadorvehiculos.Actividades.ContadorBicis;
import alberto.cano.contadorvehiculos.Actividades.ContadorCoches;
import alberto.cano.contadorvehiculos.Actividades.ContadorMotos;
import alberto.cano.contadorvehiculos.modelos.Bici;
import alberto.cano.contadorvehiculos.modelos.Coche;
import alberto.cano.contadorvehiculos.modelos.Moto;

public class MainActivity extends AppCompatActivity {

    private TextView txtCantidadCoches;
    private TextView textCantidadMotos;
    private TextView textCantidadBicis;

    private Button buttonCrearCoche;
    private Button buttonCrearMoto;
    private Button buttonCrearBici;

    //Atributos de Lógica
    private ArrayList<Coche> listaCoches;
    private ArrayList<Moto> listaMotos;
    private ArrayList<Bici> listaBicis;

    //Atributos de los launchers
    private ActivityResultLauncher<Intent> launcherCoches;
    private ActivityResultLauncher<Intent> launcherMotos;
    private ActivityResultLauncher<Intent> launcherBicis;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVariables();

        buttonCrearCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherCoches.launch(new Intent(MainActivity.this, ContadorCoches.class));
            }
        });

        buttonCrearMoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherMotos.launch(new Intent(MainActivity.this, ContadorMotos.class));
            }
        });

        buttonCrearBici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherBicis.launch(new Intent(MainActivity.this, ContadorBicis.class));
            }
        });

        launcherCoches = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){
                                Coche coche = (Coche)result.getData().getExtras().getSerializable("COCHE");
                                listaCoches.add(coche);
                                txtCantidadCoches.setText("Coches:" + listaCoches.size());
                            }else {
                                Toast.makeText(MainActivity.this, "No se han pasado los datos", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(MainActivity.this, "Ventana Cancelada", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

        );

        launcherMotos = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){
                                Moto moto = (Moto)result.getData().getExtras().getSerializable("MOTO");
                                listaMotos.add(moto);
                                textCantidadMotos.setText("Motos:" + listaMotos.size());
                            }else {
                                Toast.makeText(MainActivity.this, "No se han pasado los datos", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(MainActivity.this, "Ventana Cancelada", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

        );

        launcherBicis = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){
                                Bici bici = (Bici)result.getData().getExtras().getSerializable("BICI");
                                listaBicis.add(bici);
                                textCantidadBicis.setText("Bicis:" + listaBicis.size());
                            }else {
                                Toast.makeText(MainActivity.this, "No se han pasado los datos", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(MainActivity.this, "Ventana Cancelada", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

        );

    }

    private void inicializarVariables() {
        txtCantidadCoches = findViewById(R.id.textCantidadCoches);
        textCantidadMotos = findViewById(R.id.textViewCantidadMotos);
        textCantidadBicis = findViewById(R.id.textViewCantidadBicis);

        buttonCrearCoche = findViewById(R.id.buttonCrearCoche);
        buttonCrearMoto = findViewById(R.id.buttonCrearMoto);
        buttonCrearBici = findViewById(R.id.buttonCrearBici);




    }



}