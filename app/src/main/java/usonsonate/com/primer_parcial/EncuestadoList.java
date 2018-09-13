package usonsonate.com.primer_parcial;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class EncuestadoList extends AppCompatActivity {

    ListView lstEncuestado;
    public static int ENVIOLISTA=49;
    ArrayList<Encuestado> listaEncuestadoNueva, listaEncuestadoRecibido;
    private AdaptadorEncuestado adaptadorEncuestado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuestado_list);

        lstEncuestado = findViewById(R.id.lstEncuestados);

        Bundle contenedor = getIntent().getExtras();
        listaEncuestadoRecibido = (ArrayList<Encuestado>) contenedor.getSerializable("array");
        listaEncuestadoNueva = new ArrayList<>();

        adaptadorEncuestado = new AdaptadorEncuestado(EncuestadoList.this, listaEncuestadoNueva);
        lstEncuestado.setAdapter(adaptadorEncuestado);

        FillListEncuestado();


    }

    private void FillListEncuestado(){
        for (final Encuestado c:listaEncuestadoRecibido){
            listaEncuestadoNueva.add(c);
            adaptadorEncuestado.notifyDataSetChanged();
        }
    }


}
