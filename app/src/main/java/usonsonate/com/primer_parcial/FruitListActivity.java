package usonsonate.com.primer_parcial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FruitListActivity extends AppCompatActivity {
    ListView lstFrutas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_list);

        //inicializando el adaptador, utilizando un prototipo por defecto
        final ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        //creando los datos
        String datos[] = {"Frutas", "Verduras", "Carnes"};

        lstFrutas = findViewById(R.id.lstFrutas);
        //agrego los datos al adaptador - este se encarga de mostrar los datos en el listview
        adaptador.addAll(datos);
        //agrego el adaptador a la lista
        lstFrutas.setAdapter(adaptador);
        //notifico siempre que ha habido un cambio en los datos (insertar, eliminar, modificar)
        adaptador.notifyDataSetChanged();

        //Evento para items de la listas
        lstFrutas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String nombre_fruta = adaptador.getItem(position).toString();
                Toast.makeText(FruitListActivity.this, nombre_fruta, Toast.LENGTH_SHORT).show();
                //envio los datos al MainActivity
                Intent resultIntent = new Intent();
                // TODO envio los datos mediante el intent
                resultIntent.putExtra("ALIMENTO",nombre_fruta);
                setResult(NuevoEscuestadoActivity.GUARDADO, resultIntent);
                finish();
            }
        });

    }
}
