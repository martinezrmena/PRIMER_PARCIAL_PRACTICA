package usonsonate.com.primer_parcial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NuevoEscuestadoActivity extends AppCompatActivity {

    private Button btnListaAlimentos;
    public static int GUARDADO=47;
    public static int ENVIOPRINCIPAL=48;
    private String Fruta;
    private EditText txbNombre, txbEdad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_escuestado);

        btnListaAlimentos = findViewById(R.id.btnListarAlimentos);
        txbNombre = findViewById(R.id.txbNombre);
        txbEdad = findViewById(R.id.txbEdad);
    }

    public void btnListarAlimentosClick(View v){
        Intent nuevo = new Intent(NuevoEscuestadoActivity.this, FruitListActivity.class);
        startActivityForResult(nuevo, GUARDADO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GUARDADO){
            if(data==null) return;
            //recibo el dato
            Fruta = data.getStringExtra("ALIMENTO");
            Toast.makeText(NuevoEscuestadoActivity.this, "Selecciono: " + Fruta, Toast.LENGTH_SHORT).show();
        }
    }

    public void btnProcesarClick(View v){
        if (txbEdad.getText() != null && txbNombre.getText() != null && Fruta != null){
            Intent resultIntent = new Intent();
            // TODO envio los datos mediante el intent
            resultIntent.putExtra("NOMBRE", txbNombre.getText().toString());
            resultIntent.putExtra("EDAD", txbEdad.getText().toString());
            resultIntent.putExtra("ALIMENTO", Fruta);
            setResult(MainActivity.ENVIOPRINCIPAL, resultIntent);
            finish();
        }

    }

}
