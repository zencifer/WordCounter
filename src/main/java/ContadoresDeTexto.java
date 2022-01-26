import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class ContadoresDeTexto {

        public static void main(String args[]) {

            if (args.length == 0) {
                System.out.println("Falta el nombre del archivo");
                System.exit(1);
            }

            String fileName = args[0];

            FileReader fileReader = null;

            try {
                fileReader = new FileReader(fileName);
            } catch (FileNotFoundException e) {
                System.out.println("El nombre del archivo no se encuentra");
                System.exit(2);
            }

            BufferedReader in = new BufferedReader(fileReader);
            StreamTokenizer st = new StreamTokenizer(in);
            StringTokenizer stringTokenizer = new StringTokenizer(in.lines().collect(Collectors.joining()));

            String textLine = null;
            int contadorPalabras = 0;
            boolean tipoToken;

            long start = System.currentTimeMillis();
            try {
                while ((tipoToken = stringTokenizer.hasMoreTokens())) {
                    System.out.println(stringTokenizer.nextToken());
                        contadorPalabras++;
                        //System.out.println(st.sval);

                }
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // tiempo de procesamiento
            long time = System.currentTimeMillis() - start;

            System.out.printf("El archivo %s tiene %,8d palabras. " , fileName, contadorPalabras );
            System.out.printf(" Numero de lineas: %,8d%n", st.lineno() );// no encontré un metodo para que contase las lineas. Por algún motivo con cualquier otro metodo crashea e incluso si lo quito, también
            System.out.printf("Tiempo procesamiento (milisegundos): %d %n" , time);
        }
}

