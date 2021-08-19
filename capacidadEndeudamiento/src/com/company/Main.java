package com.company;

//import javafx.scene.input.KeyCode;
import java.util.Scanner;

import clases.CapacidadEndeudamiento;



public class Main {
	
    private static CapacidadEndeudamiento capacidadEndeudamiento = new CapacidadEndeudamiento();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String ingMensuales;
        double endeudamiento;
    	Integer gastosFijos;
    	Integer gastoVariable;
    	
        String entrada2 = "SI";
        while (entrada2.equals("SI")) {

        	System.out.println("Ingrese sus ingresos mensuales");
        	ingMensuales = in.nextLine();
        	
        if(isNumeric(ingMensuales.toString())) { //if acorde al valor registrado en ingresos mensuales, si envio una letra no continua el proceso
        	//Para este caso realizamos una consulta de IsNumeric tambien para los ingresos mensuales, sin embargo no se si aplica esa gestion o solo deberia ser para los valores dentro del while
        	capacidadEndeudamiento.setIngresosTotales(Integer.valueOf(ingMensuales));
        	System.out.println("el valor es " + capacidadEndeudamiento.getIngresosTotales());
        	entrada2 = "NO";
        }
        else {
        	entrada2 = "SI";
        	System.out.println("Datos errados, ingrese nuevamente");	
        }
        }
        	

            String entrada = "SI";
            while (entrada.equals("SI")) {
                System.out.println("Ingrese sus gastos fijos");         
                gastosFijos = in.nextInt();
                
                System.out.println("Ingrese sus gastos variable");
                gastoVariable = in.nextInt();

                //Valida las entradas de los usuarios que no vayas a convertir una "A" numero y el calculo no te funcione          
                
               if (isNumeric(gastosFijos.toString()) && isNumeric(gastoVariable.toString())) {
                   capacidadEndeudamiento.setGastosFijos(gastosFijos);
                   capacidadEndeudamiento.setGastoVaribales(gastoVariable);
               	endeudamiento = capacidadEndeudamiento.getCapacidadEndeudamiento(capacidadEndeudamiento.getIngresosTotales(), capacidadEndeudamiento.getGastosFijos(), capacidadEndeudamiento.getGastoVaribales());
               System.out.println("La capacidad de endeudamiento de la persona es:  " + endeudamiento) ;
               }
                	else {
                        System.out.println("Los valores registrados no son numericos por favor vuelva a intentar!");
                	}
               //Utiliza el metodo is numeric para cada entrada de ser necesarios
                }        	

            in.close();
        }
            
            //Esto te dara la primera entrada al proceso de solicitar los datos para instancir nuestro objeto
            // CapacidadEndedudamiento()

    
    public static boolean isNumeric(String value) {
        // implementa un bloque try catch aca
    	try {
            Double.parseDouble(value);
    		return true;
    	} catch (NumberFormatException nfe){
           return false;
    	} 

    }
    
}
