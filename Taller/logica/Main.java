package logica;
// Vicente Ignacio Rojas Malhue / ICCI / 21.894.251-2
// Millaray Belen Zepeda Salfate/ ICCI / 22.063.994-0

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	
public static void main(String[] args) throws FileNotFoundException {
		
		int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
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
		
		int NUsuarios = i;
		
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
		
		int NActividades = j;
		
		input2.close();
		
		//menu
		int numero = 0; 

        

        //opciones
        while (numero != 3) {
        	System.out.println("\n1) Menu de Usuarios");
            System.out.println("2) Menu de Analisis");
            System.out.println("3) Salir");
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
                        	System.out.println(" ");
                            System.out.println("Acceso permitido");
                            System.out.println(" ");
                            
                            while (opcion1 != 5) {
                            	System.out.println("Bienvenido "+ logrado+ "!");
                                System.out.println(" ");
                                System.out.println("Que deseas realizar?\r\n"
                                		+ "\r\n"
                                		+ "1) Registrar actividad.\r\n"
                                		+ "2) Modificar actividad.\r\n"
                                		+ "3) Eliminar actividad.\r\n"
                                		+ "4) Cambiar contraseña.\r\n"
                                		+ "5) Salir.");
                            	System.out.print("");
                            	opcion1 = opcion.nextInt();
                   
                            	
                            	if (opcion1 == 5) {
                            		
                            		break;
                                }
                            	switch(opcion1) {
                            	case 1:
                            		
                            		System.out.println(" ");
                            		
                            		int dia = 0;
                            		int mes = 0;
                            		int tiempo = 0;
                            		
                            		boolean valorValido = false;
                            		
                            		// pidiendo el mes
                            		valorValido = false;
                            		while (!valorValido) {
                            		    try {
                            		        System.out.print("mes: ");
                            		        mes = opcion.nextInt();
                            		        opcion.nextLine();
                            		        while (mes <= 0 || mes > 12) {
                            		        	System.out.println("Mes no valido (no existe)");
                            		        	System.out.println(" ");
                                		        System.out.print("mes: ");
                            		        	mes = opcion.nextInt();
                            		        	opcion.nextLine();
											}
                            		        valorValido = true;
                            		    } catch (Exception e) {
                            		        System.out.println("Error: debes ingresar un número");
                            		        opcion.nextLine();
                            		    }
                            		}
                            		
                            		//pidiendo el dia
                            		valorValido = false;
                            		while (!valorValido) {
                            		    try {
                            		        System.out.print("dia: ");
                            		        dia = opcion.nextInt();
                            		        do {
												if (dia <= 0 || dia > diasPorMes[mes-1]) {
													System.out.println("Dia no valido (no existe)");
													System.out.print("dia: ");
		                            		        dia = opcion.nextInt();
												} else {
													valorValido = true;
												}
											} while (!valorValido);
											
                            		        valorValido = true;
                            		    } catch (Exception e) {
                            		        System.out.println("Error: debes ingresar un número");
                            		        opcion.nextLine();
                            		    }
                            		}
                            		
                            		
                            		//pidiendo horas procrastinadas
                            		valorValido = false;
                            		while (!valorValido) {
                            		    try {
                            		        System.out.print("Horas Procrastinadas: ");
                            		        tiempo = opcion.nextInt();
                            		        opcion.nextLine();
                            		        valorValido = true;
                            		    } catch (Exception e) {
                            		        System.out.println("Error: debes ingresar un número");
                            		        opcion.nextLine();
                            		    }
                            		}
                            		//guardando la fecha en un string
                            		String laFecha = null;
                            		if (dia < 10 && mes > 9) {
                            			laFecha = "0" + dia + "/" + mes + "/2026";
									} else if (dia < 10 && mes < 10) {
										laFecha = "0" + dia + "/0" + mes + "/2026";
									} else if (dia > 9 && mes > 9) {
										laFecha = dia + "/" + mes + "/2026";
									}else {
										laFecha = dia + "/0" + mes + "/2026";
									}
                            		
                            		System.out.print("Actividad: ");
                            		String laActividad = opcion.nextLine();
                            		System.out.println("");
                            		String laHora = tiempo + "";
                            		
                            		
                            		nombres[NActividades] = logrado;
                            		fecha[NActividades] = laFecha;
                            		hora[NActividades] = laHora;
                            		actividad[NActividades] = laActividad;
                            		NActividades++;
                            		System.out.println("-- la actividad a sido registrada con exito!");
                            		System.out.println(" ");


                            		break;
                            	case 2:
                            		System.out.println(" ");
                            		System.out.println("Cual actividad deseas modificar?");
                            		System.out.println(" ");
                            		
                            		int [] listaDeIndices = new int [NActividades];
                            		int contadorLista = 0;
                            		
                            		for (int contador = 0; contador < NActividades; contador++) {
										if (nombres[contador].equals(logrado)) {
											System.out.println((contadorLista + 1) + ") " + nombres[contador] + ";" + fecha[contador] + ";" + hora[contador] + ";" + actividad[contador]);
											listaDeIndices[contadorLista] = contador;
											contadorLista++;
											
										}
                            		}
                            		System.out.println(" ");
                            		int elegirModificar = 0;
                            		
                            		// ciclo para verifiar si el indice es de user seleccionado
                            		valorValido = false;
                            		while (!valorValido) {
                            		    try {
                            		    	while ((elegirModificar <= 0) || (elegirModificar > contadorLista)) {
                            		    		System.out.print("eleccion: ");
                                		        elegirModificar = opcion.nextInt();
                                		        opcion.nextLine();
                                		        if ((elegirModificar <= 0) || (elegirModificar > contadorLista)) {
													System.out.println("error, indice de actividad no valido");
													System.out.println(" ");
													valorValido = false;
												} else {
													valorValido = true;
												}
                                		        
											}
                            		    } catch (Exception e) {
                            		        System.out.println("Error: debes ingresar un número");
                            		        opcion.nextLine();
                            		    }
                            		}
                            		//con esto, la eleccion del user estara dentro del rango de opciones, y podremos sacar el indice de la lista completa de actividades
                            		elegirModificar = elegirModificar - 1; //para que este en formato indice, ya que el usuario eligio la actividad a modificar como numero del 1 a n actividades hechas, y java lee desde el indice 0
                            		//ahora tenemos que preguntar que se desea modificar
                            		valorValido = false;
                            		int opcionDeModificar = 0;
                            		while (!valorValido) {
                            		    try {
                            		    	while ((opcionDeModificar <= 0 ) || (opcionDeModificar > 3)) {
                            		    		System.out.println(" ");
                            		    		System.out.println("Que deseas modificar?");
                            		    		System.out.println(" ");
                            		    		System.out.println("1) Fecha");
                            		    		System.out.println("2) Actividad");
                            		    		System.out.println("3) Volver");
                            		    		System.out.println(" ");
                            		    		
                                		        opcionDeModificar = opcion.nextInt();
                                		        opcion.nextLine();
                                		        if ((opcionDeModificar <= 0) || (opcionDeModificar > 3)) {
													System.out.println("Opcion no valida");
													System.out.println(" ");
													valorValido = false;
												} else {
													valorValido = true;
												}
											}
                            		    } catch (Exception e) {
                            		        System.out.println("Error: debes ingresar un número");
                            		        opcion.nextLine();
                            		    }
                            		}
                            		
                            		if (opcionDeModificar == 1) {
                            			//editarFecha
                            			dia = 0;
                                		mes = 0;
                            			//pidiendo el mes (copiado del codigo hecho para la verificacion de la fecha
                                		valorValido = false;
                                		while (!valorValido) {
                                		    try {
                                		        System.out.print("mes: ");
                                		        mes = opcion.nextInt();
                                		        opcion.nextLine();
                                		        while (mes <= 0 || mes > 12) {
                                		        	System.out.println("Mes no valido (no existe)");
                                		        	System.out.println(" ");
                                    		        System.out.print("mes: ");
                                		        	mes = opcion.nextInt();
                                		        	opcion.nextLine();
    											}
                                		        valorValido = true;
                                		    } catch (Exception e) {
                                		        System.out.println("Error: debes ingresar un número");
                                		        opcion.nextLine();
                                		    }
                                		}
                                		
                                		//pidiendo el dia
                                		valorValido = false;
                                		while (!valorValido) {
                                		    try {
                                		        System.out.print("dia: ");
                                		        dia = opcion.nextInt();
                                		        do {
    												if (dia <= 0 || dia > diasPorMes[mes-1]) {
    													System.out.println("Dia no valido (no existe)");
    													System.out.print("dia: ");
    		                            		        dia = opcion.nextInt();
    												} else {
    													valorValido = true;
    												}
    											} while (!valorValido);
    											
                                		        valorValido = true;
                                		    } catch (Exception e) {
                                		        System.out.println("Error: debes ingresar un número");
                                		        opcion.nextLine();
                                		    }
                                		}
                                		
                                		//guardando la fecha en un string
                                		laFecha = null;
                                		if (dia < 10 && mes > 9) {
                                			laFecha = "0" + dia + "/" + mes + "/2026";
    									} else if (dia < 10 && mes < 10) {
    										laFecha = "0" + dia + "/0" + mes + "/2026";
    									} else if (dia > 9 && mes > 9) {
    										laFecha = dia + "/" + mes + "/2026";
    									}else {
    										laFecha = dia + "/0" + mes + "/2026";
    									}
                                		
                                		//ahora tenemos que modificar la fecha de la actividad que elegimos
                                		
                                		int indiceAModificar = listaDeIndices[elegirModificar];
                                		fecha[indiceAModificar] = laFecha;
                            			
										
									} else if (opcionDeModificar == 2) {
										//editarActividad
									}else if (opcionDeModificar == 3) {
										System.out.println("Operacion Cancelada");
										System.out.println(" ");
									}
										
									
                            		
                            		
                            		break;
                            	case 3:
                            		System.out.println(" ");
                            		System.out.println("Cual actividad deseas Eliminar?");
                            		System.out.println(" ");
                            		
                            		for (int contador = 0; contador < NActividades; contador++) {
										if (nombres[contador].equals(logrado)) {
											System.out.println((contador + 1) + ") " + nombres[contador] + ";" + fecha[contador] + ";" + hora[contador] + ";" + actividad[contador]);
											
										}
										
									}
                            		break;
                            	case 4:
                            		System.out.println(" ");
                            		System.out.print("Nueva contraseña: ");
                            		opcion = new Scanner(System.in);
                            		String newContra = opcion.nextLine();
                            		
                                    for (int k = 0; k < NUsuarios; k++) {
                                        if (usuarios[k].equals(persona)) {
                                            contrasenas[k] = newContra;
                                            break;
                                        }
                                    }
                            		
                            		
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
                	
                 
                    while (numero2 != 5) {
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
                    	System.out.print("");
                        numero2 = opcion.nextInt();
                        
                        if (numero2 == 5) {//regresa al inicio
                        	
                            break; // solo sale del while(opcion1)    
                        }
                    	switch(numero2) {
                    	case 1:
                   
                    	    System.out.println(" ");

                    	    String actividadGlobal = "";
                    	    int cantidadMayor = 0;

                    	   
                    	    for (int m = 0; m < NActividades; m++) {

                    	        String actividadTemporal = actividad[m];
                    	        int contadorActividad = 0;

                    	       
                    	        for (int n = 0; n < NActividades; n++) {
                    	            if (actividad[n].equals(actividadTemporal)) {
                    	                contadorActividad++;
                    	            }
                    	        }
                    	        if (contadorActividad > cantidadMayor) {
                    	            cantidadMayor = contadorActividad;
                    	            actividadGlobal = actividadTemporal;
                    	        }
                    	    }

                    	    System.out.println("Actividad más realizada: ");
                    	    System.out.println(actividadGlobal +": " + cantidadMayor + " veces");
                    	    break;
               
                    	case 2:
                    		System.out.println(" ");
                    		System.out.println("\nActividades más realizada por cada usuario:");

                            for (int x = 0; x < i; x++) {

                                String usuarioActual = usuarios[x];
                                boolean yaMostrado = false;

                                for (int z = 0; z < x; z++) {
                                    if (usuarios[z].equals(usuarioActual)) {
                                        yaMostrado = true;
                                        break;
                                    }
                                }

                                //para que continue 
                                if (yaMostrado == false) {

                                    String actividadMas = "";
                                    int maxHoras = 0;

                                    for (int a = 0; a < NActividades; a++) {

                                        if (nombres[a].equals(usuarioActual)) {

                                            String act = actividad[a];
                                            int sumaHoras = 0;

                                            for (int b = 0; b < NActividades; b++) {
                                                if (nombres[b].equals(usuarioActual)
                                                        && actividad[b].equals(act)) {
                                                    sumaHoras += Integer.parseInt(hora[b]);
                                                }
                                            }

                                            if (sumaHoras > maxHoras) {
                                                maxHoras = sumaHoras;
                                                actividadMas = act;
                                            }
                                        }
                                    }

                                    if (maxHoras > 0) {
                                        System.out.println("* " + usuarioActual + " -> " + actividadMas
                                                + " -> " + maxHoras + " horas");
                                    }
                                }
                            }

                            break;
                    	case 3:
                    	    System.out.println(" ");

                    	    String usuarioProcrastinador = "";
                    	    int mayorHoras = 0;

                
                    	    for (int p = 0; p < i; p++) {

                    	        String usuarioActual = usuarios[p];

     
                    	        boolean repetido = false;
                    	        for (int q = 0; q < p; q++) {
                    	            if (usuarios[q].equals(usuarioActual)) {
                    	                repetido = true;
                    	                break;
                    	            }
                    	        }

                    	        if (repetido == false) {

                    	            int horasTotales = 0;

                    	            for (int r = 0; r < NActividades; r++) {
                    	                if (nombres[r].equals(usuarioActual)) {
                    	                    horasTotales = horasTotales + Integer.parseInt(hora[r]);
                    	                }
                    	            }
                    	            if (horasTotales > mayorHoras) {
                    	                mayorHoras = horasTotales;
                    	                usuarioProcrastinador = usuarioActual;
                    	            }
                    	        }
                    	    }

                    	    System.out.println("Usuario con mayor procrastinación: ");
                    	    System.out.println(usuarioProcrastinador +": " + mayorHoras + " horas registradas");
                    	    break;
                    	case 4:
                    	    System.out.println(" ");
                    	    System.out.println("Todas las actividades:");

                    	    for (int s = 0; s < NActividades; s++) {

                    	        System.out.println(
                    	            (s + 1) + ") " +
                    	            nombres[s] + ";" +
                    	            fecha[s] + ";" +
                    	            hora[s] + ";" +
                    	            actividad[s]
                    	        );
                    	    }

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
        
        //GUARDADO O SOBREESCRITURA DE ARCHIVOS
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Usuarios.txt"));

            for (j = 0; j < NUsuarios; j++) {
                writer.write(usuarios[j] + ";" + contrasenas[j]);
                writer.newLine();
            }
            
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("Registros.txt"));

            for (j = 0; j < NActividades; j++) {
                writer2.write(nombres[j] + ";" + fecha[j] + ";" + hora[j] + ";" + actividad[j]);
                writer2.newLine();
            }
            writer.close();
            writer2.close();


        } catch (IOException e) {
            System.out.println("Error al escribir el archivo");
            
        }
	}
}