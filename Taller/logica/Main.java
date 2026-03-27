package logica;
// Vicente Ignacio Rojas Malhue / ICCI / 21.894.251-2
// Millaray Belen Zepeda Salfate/ ICCI / 22.063.994-0

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	
public static void main(String[] args) throws FileNotFoundException {
		
		Scanner opcion = new Scanner(System.in);
		//lista primer archivo
		String[] usuarios = new String[300];
        String[] contrasenas = new String[300];
        
		File archivo1 = new File("Usuarios.txt");
		Scanner input1 = new Scanner(archivo1);
		
		int i = 0;
		
		while (input1.hasNextLine()) {
			String linea1 = input1.nextLine();
			String[] partes1 = linea1.split(";");
			
			usuarios[i] = partes1[0];
            contrasenas[i] = partes1[1];
            i++;
		}
		
		input1.close();
		
		
		//segundo lector y sus listas para comparar
        String[] nombres = new String[300];
        String[] fecha = new String[300];
        String[] hora = new String[300];
        String[] actividad = new String[300];
        
		File archivo2 = new File("Registros.txt");
		Scanner input2 = new Scanner(archivo2);
		int j = 0;
		
		while (input2.hasNextLine()) {
			String linea2 = input2.nextLine();
			String[] partes2 = linea2.split(";");
			nombres[j] = partes2[0];
            fecha[j] = partes2[1];
            hora[j] = partes2[2];
            actividad[j] = partes2[3];
            j++;

		}
		
		input2.close();
		
		//menu
		int numero = 0; 

        //menu
        System.out.println("\n1) Menu de Usuarios");
        System.out.println("2) Menu de Analisis");
        System.out.println("3) Salir");

        //opciones
        while (numero != 3) {
            System.out.print("");
            numero = opcion.nextInt(); // toma la opcion

            switch (numero) {
                case 1:
                	int acceso = 0;
                	String logrado = "";//se guarda el usuario

                    while (acceso == 0) {
                        System.out.print("Usuario: ");
                        String persona = opcion.next();

                        System.out.print("Contraseña: ");
                        String contrasena = opcion.next();

                        // FOR para buscar
                        for (int k = 0; k < i; k++) {
                            if (usuarios[k].equals(persona) && contrasenas[k].equals(contrasena)) {
                                acceso = 1;
                                logrado = usuarios[k];
                                break;
                            }
                        }

                        if (acceso == 1) {
                        	int opcion1 = 0;
                            System.out.println("Acceso permitido");
                            System.out.println(" ");
                            System.out.println("Bienvenido "+ logrado+ "!");
                            System.out.println(" ");
                            System.out.println("Que deseas realizar?\r\n"
                            		+ "\r\n"
                            		+ "1) Registrar actividad.\r\n"
                            		+ "2) Modificar actividad.\r\n"
                            		+ "3) Eliminar actividad.\r\n"
                            		+ "4) Cambiar contraseña.\r\n"
                            		+ "5) Salir.");
                            while (opcion1 != 5) {
                            	System.out.print("");
                            	opcion1 = opcion.nextInt();
                            	
                            	if (opcion1 == 5) {
                            		opcion1 = 3; //cierra todo
                            		break;
                                }
                            	switch(opcion1) {
                            	case 1:
                            		System.out.println("111");
                            		break;
                            	case 2:
                            		System.out.println("222");
                            		break;
                            	case 3:
                            		System.out.println("333");
                            		break;
                            	case 4:
                            		System.out.println("444");
                            		break;
                            	case 5:
                                    System.out.println("Saliendo programa total");
                                    break;
               
                            	default:
                            		System.out.println("otra vez:");
                            	}
                            } 
                        } else {
                            System.out.println(" Usuario o contraseña incorrectos, intenta nuevamente");
                        }
                    }
                    break;

                case 2:
                	int numero2 = 0; 
                	
                    System.out.println("\r\n"
                    		+"Bienvenido al menu de analisis!\r\n"
                    		+ "\r\n"
                    		+ "Que deseas realizar?\r\n"
                    		+ "\r\n"
                    		+ "1) Actividad más realizada\r\n"
                    		+ "2) Actividad más realizada por cada usuario\r\n"
                    		+ "3) Usuario con mayor procastinacion\r\n"
                    		+ "4) Ver todas las actividades\r\n"
                    		+ "5) Salir");
                    while (numero2 != 5) {
                    	System.out.print("");
                        numero2 = opcion.nextInt();
                        
                        if (numero2 == 5) {
                            numero = 3; //cierra todo
                            break;
                        }
                    	switch(numero2) {
                    	case 1:
                    		System.out.println("11");
                    		break;
                    	case 2:
                    		System.out.println("22");
                    		break;
                    	case 3:
                    		System.out.println("33");
                    		break;
                    	case 4:
                    		System.out.println("44");
                    		break;
                    	case 5:
                            System.out.println("Saliendo");
                            break;
       
                    	default:
                    		System.out.println("otra vez:");
               
                    		
                    	}
                    }
                    break;

                case 3:
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Opción inválida, intente nuevamente");
                    break;
            }
        }

        opcion.close();
	}

}
