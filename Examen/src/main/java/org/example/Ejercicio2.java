package org.example;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {
    void ejecutar() {

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
