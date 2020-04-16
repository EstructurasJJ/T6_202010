package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import model.logic.Comparendo;
import model.logic.Modelo;
import view.View;

public class Controller {

	private Modelo modelo;
	private View view;
	public final static String RUTAGEOJASON = "./data/Comparendos_DEI_2018_Bogotá_D.C.geojson";
	public final static String JUEGUEMOS = "./data/Comparendos_DEI_2018_Bogotá_D.C_small.geojson";
	public final static String COTEJO = "./data/Comparendos_DEI_2018_Bogotá_D.C_50000_.geojson";

	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		Comparendo[] arreglo = null;

		while( !fin )
		{
			view.printMenu();

			int option = lector.nextInt();

			switch(option)
			{
			case 1:

				//Cargar el archivo

				modelo.leerGeoJson(RUTAGEOJASON);

				view.printMessage("Archivo GeoJSon Cargado");
				view.printMessage("Numero actual de comparendos  " + modelo.darArbolito().size() + "\n----------");
				
				System.out.println("El mínimo es: " + modelo.darArbolito().min());
				System.out.println("El máximo es: " + modelo.darArbolito().max() + "\n----------");
				System.out.println("La altura del árbol es: "+modelo.darArbolito().height());
				System.out.println("Las hojas del árbol son: "+modelo.darArbolito().contarHojas());
				System.out.println("Acumulado de altura de hojas del árbol: "+modelo.darArbolito().acumuladoAlturaHojas());
				System.out.println("Promedio de alturas: " +(modelo.darArbolito().acumuladoAlturaHojas()/modelo.darArbolito().contarHojas()));
				break;

			case 2:
				
				System.out.println("Ingrese el ID del comparendo que desea buscar:");
				int id = Integer.parseInt(lector.next());
				
				Comparendo compi = modelo.consultarComparendoPorID(id);
				
				if (compi != null)
				{
					System.out.println("El id es: " + compi.darObjectid());
					System.out.println("La fecha es: " + compi.darFecha_Hora().toString());
					System.out.println("El tipo de servicio es: " + compi.darTipo_Servicio());
					System.out.println("La clase del vehiculo es: " + compi.darClase_Vehi());
					System.out.println("La infracción es: " + compi.darInfraccion() + "\n----------");
				}

				break;

			case 3:
				
				System.out.println("Ingrese el ID mínimo del rango de comparendos que desea buscar:");
				int lo = Integer.parseInt(lector.next());
				
				System.out.println("Ingrese el ID máximo del rango de comparendos que desea buscar:");
				int hi = Integer.parseInt(lector.next());
				
				Iterator<Comparendo> lista = modelo.consultarComparendosEnRango(lo, hi);
				
				while(lista.hasNext())
				{
					Comparendo compi1 = lista.next();
					
					System.out.println("El id es: " + compi1.darObjectid());
					System.out.println("La fecha es: " + compi1.darFecha_Hora().toString());
					System.out.println("El tipo de servicio es: " + compi1.darTipo_Servicio());
					System.out.println("La clase del vehiculo es: " + compi1.darClase_Vehi());
					System.out.println("La infracción es: " + compi1.darInfraccion() + "\n----------");
				}

				break;

			case 4:

				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;

				break;	

			default: 

				view.printMessage("--------- \n Opción Invalida !! \n---------");

				break;

			}
		}

	}	
}
