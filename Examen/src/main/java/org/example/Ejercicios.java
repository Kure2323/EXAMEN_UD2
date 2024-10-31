package org.example;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicios {

    public void ej1(){

        Scanner entrada = new Scanner(System.in);
        Random random = new Random();
        int j = 0;  //Puntuación del jugador
        int m = 0;  //Puntuación de la máquina
        String elección = "";

        for (int i = 1; i <= 3; i++){   //Realizo un bucle for haciendo de "i" las rondas

            System.out.println("¿Piedra, papel o tijera? (p/a/t):");
            elección = entrada.nextLine();
            int rdm = random.nextInt(1,4);  //Número aleatorio (1, 2 o 3) los cuales son respectivamente piedra, papel y tijera

            if (elección.equals("p")){  //En caso de que la elección del jugador sea = p
                switch (rdm){   //Switch para los tres posibles resultados
                    case 1:     //Caso en el que la máquina saque piedra
                        System.out.println("Empate");
                        i--;    //Anulo la posibilidad de pasar de ronda
                        break;
                    case 2:     //Caso en el que saca papel
                        System.out.println("La máquina ha usado papel, has perdido");
                        m++;    //Suma punto a la máquina
                        break;
                    case 3:     //Caso en el que saca tijera
                        System.out.println("La máquina ha usado tijera, has ganado");
                        j++;    //Suma punto al jugador
                        break;
                }
                System.out.println("Marcador actual (PC-usuario): " + m + "-" + j);     //Indica la puntuación en el momento de el jugador y la máquina

            } else if (elección.equals("a")) {
                switch (rdm) {
                    case 1:
                        System.out.println("La máquina ha usado piedra, has ganado");
                        j++;
                        break;
                    case 2:
                        System.out.println("Empate");
                        i--;
                        break;
                    case 3:
                        System.out.println("La máquina ha usado tijera, has perdido");
                        m++;
                        break;
                }
                System.out.println("Marcador actual (PC-usuario): " + m + "-" + j);

            } else if (elección.equals("t")) {
                switch (rdm) {
                    case 1:
                        System.out.println("La máquina ha usado piedra, has perdido");
                        m++;
                        break;
                    case 2:
                        System.out.println("La máquina ha usado papel, has ganado");
                        j++;
                        break;
                    case 3:
                        System.out.println("Empate");
                        i--;
                        break;
                }
                System.out.println("Marcador actual (PC-usuario): " + m + "-" + j);

            } else {    //En caso de introducirse cualquier otro tipo de input salta el siguiente mensaje
                System.out.println("Solo debe introducirse una letra: p/a/t");
                i--;    //Y además no suma una ronda más
            }
        }
        if (j > m) {    //Cuando termina el bucle se evalúa quién tiene más puntuación y se notifica
            System.out.println("¡HAS GANADO!");
        }else {
            System.out.println("GAME OVER");
        }
    }
    public void ej2(){
        Scanner entrada = new Scanner(System.in);
        LocalDate today = LocalDate.now();
        int edad = 0;
        String hoy = today.toString();
        String año_actual = hoy.substring(0, 4);    //Saco tan solo las 4 primeras cifras para sacar el año
        int actual = Integer.parseInt(año_actual);  //Y lo transformo a int para poder jugar con la fecha y calcular
//        System.out.println(año_actual);
        boolean tc = true;

        int año = 0;
        while (tc) {    //Filtro con try catch para que no se introduzcan otro tipo de valores excepto los que se piden
            try {

                System.out.println("Dame tu año de nacimiento:");
                año = entrada.nextInt();

                if (año < 1900 || año > actual){    //En caso de ser mayor al actual o menor a 1900 salta el mensaje y vuelve a pedir el año de nacimiento
                    System.out.println("El año introducido no debe ser mayor al actual ni menor a 1900.");
                } else {
                    tc = false;     //En caso contrario sale del bucle
                }

            } catch (InputMismatchException e) {
                System.out.println("No debe introducir otra cosa que no sean números.");
                entrada.nextLine();
            }
        }

        for (int i = año; i <= actual; i++) {   //Bucle que calcula la edad respecto al año, sumando uno a uno cada valor
            System.out.println(i + "-edad: " + edad);
            edad++;
        }
    }
}
