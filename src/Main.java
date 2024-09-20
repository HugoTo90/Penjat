import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int Fin;
        int PosicionArray = 0;
        int Errores = 0;
        int Aciertos = 0;
        char letra;

        String Palabras[] = ArrayDePalabras();

        char[] Resultado = Seleccionar_Palabra(Palabras);

        char[] Mascara = GenerarMascara(Resultado);

        char[] letrasanteriores = new char[15];

        do{
            Dibujo(Errores);
            MostrarMascara(Mascara);
            letra = PedirLetra(letrasanteriores, PosicionArray);
            MostrarLetrasAnteriores(letrasanteriores);
            PosicionArray++;
            Mascara = ComprobarLetra(letra,Resultado,Mascara);
            Aciertos = ComprobarAcierto(Mascara, letra, Aciertos);
            Errores = Errores + ComprobarError(letra, Mascara);
            MostrarAciertosErrores(Aciertos, Errores);
            Fin = ComprobarFinal(Errores, Aciertos, Resultado);
        }while(Fin == 0);
            Final(Fin, Mascara);

    }

    private static void MostrarLetrasAnteriores(char[] letrasanteriores) {
        System.out.print("Letras anteriores: [" + letrasanteriores[0]);
        for (int i = 1; i < letrasanteriores.length; i++) {
            System.out.print("," + letrasanteriores[i]);
        }
        System.out.println("]");
    }


    private static void Final(int Fin, char[] Mascara) {
        if (Fin == 1){
            System.out.println("--------------\n|            |\n|            o\n|           /|)\n|           / \\\n|\n---------------");
            System.out.println("\nHas perdido :(");
        }else{
            System.out.println(Arrays.toString(Mascara));
            System.out.println("\nHas ganado!");
        }
    }

    private static int ComprobarError(char letra, char[] Mascara) {
        int errores = 1;

        for (int i = 0; i < Mascara.length; i++) {
            if (letra == Mascara[i]) {
                errores = 0;
                break;
            }
        }
        return errores;
    }

    private static char[] GenerarMascara(char[] Resultado) {
        char[] Mascara = new char[Resultado.length];
        for (int i = 0; i < Resultado.length; i++) {
            Mascara[i] = '_';
        }
        return Mascara;
    }

    private static void MostrarAciertosErrores(int Aciertos, int Errores) {
        System.out.println("Aciertos: " + Aciertos);
        System.out.println("Errores: " + Errores);
    }

    private static void MostrarMascara(char[] Mascara) {
        System.out.println(Arrays.toString(Mascara));
    }

    private static void Dibujo(int Errores) {
        switch (Errores) {
            case 1:
                System.out.println("--------------\n|            |\n|            o\n|           \n|            \n|\n---------------");
                break;
            case 2:
                System.out.println("--------------\n|            |\n|            o\n|            |\n|\n|\n---------------");
                break;
            case 3:
                System.out.println("--------------\n|            |\n|            o\n|           /|\n|\n|\n---------------");
                break;
            case 4:
                System.out.println("--------------\n|            |\n|            o\n|           /|)\n|\n|\n---------------");
                break;
            case 5:
                System.out.println("--------------\n|            |\n|            o\n|           /|)\n|           /\n|\n---------------");
                break;
            default:
                System.out.println("--------------\n|            |\n|\n|\n|\n|\n---------------\n\n");
        }
    }

    private static String[] ArrayDePalabras() {
        String Palabras[] = {"perro", "gato", "casa", "arbol", "sol", "luna", "rio", "montaña", "libro", "lapiz", "mesa", "silla", "puerta", "ventana", "nube", "flor", "mar", "piedra", "camino", "reloj", "ojo", "mano", "hoja", "fruta", "sombra", "fuego", "aire", "tierra", "musica", "color"};
        return Palabras;
    }

    private static char[] Seleccionar_Palabra (String[] Palabras) {
            int random = (int) (Math.random() * Palabras.length);
            return Palabras[random].toCharArray();

        }

        private static char PedirLetra (char[] Letrasanteriores, int PosicionArray) {
            int Usada = 0;
            char Letra;
            do {
                System.out.println("Escribe una letra:");
                Letra = Character.toLowerCase(Teclat.llegirChar());
                for (int i = 0; i < Letrasanteriores.length; i++) {
                    if (Letra == Letrasanteriores[i]){
                        System.out.println("Ya has usado esta letra, introduce otra: ");
                        Usada = 1;
                        break;
                    } else {
                        Usada = 0;
                    }
                }
            }while (Usada == 1);
                Letrasanteriores[PosicionArray] = Letra;
            return Letra;
            }



        private static char[] ComprobarLetra (char Letra, char[] Resultado, char[] Mascara) {
            for (int i = 0; i < Resultado.length; i++) {
                if(Letra == Resultado[i]){
                    Mascara[i] = Resultado[i];
                }
            }
        return Mascara;
        }

        private static int ComprobarAcierto (char[] Mascara, char letra, int Aciertos) {
            for (int i = 0; i < Mascara.length; i++) {
                if (letra == Mascara[i]){
                    Aciertos++;
                }
            }
            return Aciertos;
        }

        private static int ComprobarFinal (int Errores, int Aciertos, char[] Resultado) {
            int Fin;
            if (Errores == 6){
                Fin = 1;
            }else if(Aciertos == Resultado.length){
                Fin = 2;
            }else{Fin = 0;}
            return Fin;
        }
}
