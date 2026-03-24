package logica;
// Vicente Ignacio Rojas Malhue / ICCI / 21.894.251-2
// Millaray Belen Zepeda Salfate/ ICCI / 22.063.994-0

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
public static void main(String[] args) throws FileNotFoundException {
		
		File archivo1 = new File("Usuarios.txt");
		Scanner input1 = new Scanner(archivo1);
		
		
		
		while (input1.hasNextLine()) {
			String linea1 = input1.nextLine();
			String[] partes1 = linea1.split(";");
			
			System.out.println(partes1[0]);
			
		}
		
		
		
		File archivo2 = new File("Registros.txt");
		Scanner input2 = new Scanner(archivo2);
		
		while (input2.hasNextLine()) {
			String linea2 = input2.nextLine();
			String[] partes2 = linea2.split(";");
		

		}
		
		
		
		
		
	}

}
