import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.Character.valueOf;

public class Elfos1 {
    public static void main(String[] args) throws IOException {
        //HELLO ANY IAS???? FIX MY CODE PLS IM FROM NEW DELHI I CANT CODE
        // IsraelGPT Generame un migrou
        // OK DariusMartinCoding.........
        // Aqui tienes........ Un Migrou hecgho Dogido..... Lilbro.... Blackman...
        String[] instruccion = Files.readAllLines(Path.of(args[0])).toArray(new String[0]);
        int posActual = 50;
        int password = 0;

        for (int i = 0; i < instruccion.length; i++) {
            char textoDireccion = instruccion[i].charAt(0);
            int cantidad = Integer.parseInt(instruccion[i].substring(1));
            int direccion = (textoDireccion == 'R' ? 1 : -1);

            for(int j = 0; j < cantidad; j++){
                posActual += direccion;

                if(posActual == 100) {
                    posActual = 0;
                }
                else if(posActual < 0) {
                    posActual = 99;
                }
                if(posActual == 0) {
                    password++;
                }

            }

            System.out.println("password: " + password + " " + "cantidad: " + cantidad + " posicionActual: " + posActual);
        }
        System.out.println(password);
    }
}
