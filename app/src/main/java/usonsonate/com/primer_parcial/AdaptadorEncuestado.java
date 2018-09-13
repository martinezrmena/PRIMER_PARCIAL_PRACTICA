package usonsonate.com.primer_parcial;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorEncuestado extends ArrayAdapter<Encuestado> {
    public AdaptadorEncuestado(Context context, List<Encuestado> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obteniendo el dato
        Encuestado encuestado = getItem(position);
        //TODO inicializando el layout correspondiente al item (Contacto)
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_encuestado, parent, false);
        }
        TextView lblNombre = (TextView) convertView.findViewById(R.id.lblNombre);
        TextView lblEdad = (TextView) convertView.findViewById(R.id.lblEdad);
        TextView lblAlimento = (TextView) convertView.findViewById(R.id.lblAlimento);
        // mostrar los datos
        lblNombre.setText(encuestado.Nombre);
        lblEdad.setText(encuestado.Edad.toString());
        lblAlimento.setText(encuestado.Alimentos);

        // Return la convertView ya con los datos
        return convertView;
    }
}
