package usonsonate.com.primer_parcial;

import java.io.Serializable;

public class Encuestado implements Serializable {

    public String Nombre;
    public Integer Edad;
    public String Alimentos;

    public Encuestado(String nombre, Integer edad, String alimentos) {
        Nombre = nombre;
        Edad = edad;
        Alimentos = alimentos;
    }

    
}
