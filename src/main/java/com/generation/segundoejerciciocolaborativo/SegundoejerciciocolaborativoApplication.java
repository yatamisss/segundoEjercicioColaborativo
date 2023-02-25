package com.generation.segundoejerciciocolaborativo;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

@SpringBootApplication
public class SegundoejerciciocolaborativoApplication {
	
//Funciones del ejercicio colaborativo
/*funcion para sacar el promedio */
public static Double promedioNotas(ArrayList<Double> notas){
 Double suma = 0.0;
 for (int i = 0; i < notas.size(); i++){
     //suma = suma + notas.get(i) -> es lo mismo
	 suma += notas.get(i);
 }
 return suma/notas.size();
}

/*funcion que verifica si el promedio del alumno esta approbado o reprobado */
public static Boolean aprobado(ArrayList<Double> notas, Double notaAprobatoria){
	Double promedio = promedioNotas(notas);
	if(promedio>= notaAprobatoria){
		return true;
	}else{
		return false;
	}
	}

/*funcion que verifica si el promedio del alumno es mayor al promedio general */
public static void sobrePromedio(Double promedioGeneral, ArrayList<Double> notas, String nombreAlum){
	Double promedioAlumno = promedioNotas(notas);
		if(promedioAlumno>promedioGeneral){
			System.out.println("El alumno "+nombreAlum+" está sobre el promedio");
		}else if(promedioAlumno == promedioGeneral){
		    System.out.println("El alumno "+nombreAlum+" es igual al promedio general");
		}else{
			System.out.println("El alumno "+nombreAlum+" está bajo el promedio");
	}
	}

	  
	  
	public static void main(String[] args) {

		/* vamos a pedir al usuario que ingrese la cantidad de alumnos a los cuales se les 
	 * asignaran notas
	 * luego de que ingrese la cantidad de de alumnos y la cantidad de notas por alumno
	 * se le mostrara un menu:
	 * mostrar el promedio de notas
	 * mostrar si la nota es aprobatoria y reprobatoria 
	 * mostrar si la nota esta por sobre o por debajo del promedio del curso
	 */

	 /* solicitar al usuario la cantidad de alumnos 
	  * solicitar el nombre de cada alumno 
	  * solicitar la cantidad de notas por alumno 
	  * ingresar notas por alumno 
	  * definir la nota aprobatoria
	  * sacar el promedio por alumno y general 
	  * verificar si el promedio de alumno esta por sobre o por debajo del promedio general
	  * verificar si la nota aprueba o reprueba 
	  * hacer el menu con solo 3 opciones con cero finalizando el menu
	  * hacer el menu 
	  * hacer validaciones sobre las notas y la cantidad de alumnos
	  * verificar que el promedio se calcule previamente antes de las operaciones que lo requieren
	  */
	

	    //Definimos las variables que utilizaremos en el ejercicio, estan aqui ya que son variables globales
		Scanner teclado = new Scanner(System.in);
		String nomAlum = "";
		Double notaAprobatoria = 4.0;
		HashMap <String, ArrayList<Double>> libroClase = new HashMap<String, ArrayList<Double>>();
		
		//se declara fuera del do...while ya que si la declaramos adentro
		//la variable pasa a ser local por ende no podriamos ocuparla fuera de este
		int cantAlum;
		int cantNotas;
		
		//Se declaro un do.. while para que el numero que ingrese el usuario no sea menor ni igual a cero
		//ya que la cantidad de alumnos no puede ser cero ni -1 por ejemplo.
		
		do{
		  System.out.print("Indique la cantidad de alumnos que va a ingresar: ");
		  cantAlum = teclado.nextInt();
		  if(cantAlum < 0){
			  System.out.print("La cantidad de alumnos debe ser mayor a cero, por favor intente nuevamente");
		  }
  
		} while (cantAlum <= 0);
  
		//aqui ocurre lo mismo que arriba, ya que la cantidad de notas tampoco puede ser menor o igual a cero
		//el do... while hace y luego pregunta. va a hacer lo que se le pidio y luego verificara la condicion
		do{
		  System.out.print("Indique la cantidad de notas por alumno: ");
		  cantNotas = teclado.nextInt();
		  if(cantNotas <= 0){
			  System.out.print("La cantidad de notas debe ser mayor a cero, por favor intente nuevamente");
		  }
		  }while(cantNotas <= 0);
	  

		  for(int i = 1; i <= cantAlum; i++){
			  teclado.nextLine();
			  ArrayList <Double> notasAlumnos = new ArrayList<Double>();
			  System.out.print("Ingresa nombre del alumno: ");
			  nomAlum = teclado.nextLine();
			  for(int x = 1; x <= cantNotas; x++){
				  System.out.print("Ingresa nota " + x + " del alumno " + nomAlum + ": ");
				  Double nota = teclado.nextDouble();
				  notasAlumnos.add(nota);
		  }
		 
		  libroClase.put(nomAlum, notasAlumnos);
		  //desafio, verificar donde deberia o como deberia limpiar el arreglo para que funcione
		  //con la declaracion de manera global
		  //notasAlumnos.clear();
		}
		
		// for(String i : libroClase.keySet()){
		//   System.out.println("key: "+ i +" valor:" + libroClase.get(i));
		// }
		// Aqui se comienzan a crear todos los mensajes que apareceran para que puedas seleccionar una opcion del menu 
        int opcion = 1;
       
		while(opcion != 0){
		do{
			System.out.println("*****************Comienzo del menu****************");
			System.out.println("Bienvenido/a");
			System.out.println("Seleccione 1 si quiere obtener el promedio de las notas por alumno.");
			System.out.println("Seleccione 2 si quiere ver si el alumno aprueba o reprueba");
			System.out.println("Seleccione 3 para ver si la nota está sobre o por debajo del promedio general");
			System.out.println("Seleccione 0 para salir del menú");
			System.out.print("Seleccione su opción: ");
			opcion = teclado.nextInt();

		}while (opcion < 0 || opcion > 3);

		if(opcion ==1){
		for(String i : libroClase.keySet()){
			//cada vez que ocupemos un for para hashmap
			//el valor de la llave (en este caso el array)
			//está contenido dentro de la sintaxis nomHasmap.get(i)
			Double promAlum = promedioNotas(libroClase.get(i));
			System.out.println("El promedio del alumno: "+ i +" es de: " + promAlum);
		}
	}else if (opcion == 2){
		for(String i : libroClase.keySet()){
			Boolean aprobar = aprobado(libroClase.get(i), notaAprobatoria);
			//es lo mismo que poner if (aprobar == true)
			if(aprobar){
				System.out.println("El alumno/a "+i+" está aprobado");
			}else{
				System.out.println("El alumno/a "+i+" está reprobado");
			}
			
		}
	}else if(opcion == 3){
		Double sumaPromedio = 0.0;
		for(String i : libroClase.keySet()){
			sumaPromedio = sumaPromedio + promedioNotas(libroClase.get(i));
			
		}
		Double promedioGeneral = sumaPromedio / cantAlum;
		for(String i : libroClase.keySet()){
	      sobrePromedio(promedioGeneral, libroClase.get(i), i);
		}
	}else{
		System.out.println("Gracias por cerrar el menú, hasta pronto :D");
	}

}




}
}


	