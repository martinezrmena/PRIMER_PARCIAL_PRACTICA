package usonsonate.com.primer_parcial;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    public static int GUARDADO=47;
    public static int ENVIOPRINCIPAL=48;
    public static int ENVIOLISTA=49;
    private Button btnNuevoEncuestado, btnListaEncuestado;
    private ArrayList<Encuestado> lstEncuestados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNuevoEncuestado = findViewById(R.id.btnEncuestado);
        lstEncuestados = new ArrayList<>();

    }

    public void btnEncuestadoClick(View v){
        Intent nuevo = new Intent(this, NuevoEscuestadoActivity.class);
        startActivityForResult(nuevo, ENVIOPRINCIPAL);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ENVIOPRINCIPAL){
            if(data==null) return;
            //recibo los datos

            Encuestado e = new Encuestado(
                    data.getStringExtra("NOMBRE"),
                    Integer.parseInt(data.getStringExtra("EDAD")),
                    data.getStringExtra("ALIMENTO")
            );

            //Toast.makeText(MainActivity.this, "El nuevo usuario ha sido agregado con exito: " + e.Nombre + ", " + e.Edad + ", " + e.Alimentos,Toast.LENGTH_SHORT).show();
            lstEncuestados.add(e);
            int i = 0;
        }
    }

    public void btnViewListaEncuestadoClick(View v){
        Intent intento = new Intent(MainActivity.this, EncuestadoList.class);
        Bundle contenedor = new Bundle();
        contenedor.putSerializable("array", lstEncuestados);
        intento.putExtras(contenedor);
        startActivity(intento);

    }

}
