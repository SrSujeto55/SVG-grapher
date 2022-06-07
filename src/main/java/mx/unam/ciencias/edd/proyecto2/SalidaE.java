package mx.unam.ciencias.edd.proyecto2;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;
/**
 * Clase de salida NO estandar, esta clase es unicamente para guardar archivos en una ruta
 * especifica
 */

public class SalidaE {

    public SalidaE(){};

    public void escritura(String ruta, String SVG) throws IOException{

            FileOutputStream fileOut = new FileOutputStream(ruta);
            OutputStreamWriter osOut = new OutputStreamWriter(fileOut);
            BufferedWriter out = new BufferedWriter(osOut);
            guarda(out, SVG);
            out.close();
    }

    public void guarda(BufferedWriter out, String SVG) 
    throws IOException{
          out.write(SVG);
    }
    
}
