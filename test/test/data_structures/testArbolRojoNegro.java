package test.data_structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;

import model.data_structures.ArbolRojoNegro;
import model.logic.Comparendo;

public class testArbolRojoNegro 
{
	private ArbolRojoNegro<Integer, Integer> arbolito;
	
	public void setUp1()
	{
		arbolito= new ArbolRojoNegro<Integer, Integer>();
	}
	public void setUp2()
	{
		arbolito = new ArbolRojoNegro<Integer, Integer>();
		
		for (int i=1;i<=100;i++)
		{
			arbolito.put(i, i);
		}
		
		for (int i=200;i>=101;i--)
		{
			arbolito.put(i, i);
		}
		assertTrue(arbolito.check());
	}
	
	@Test
	public void testSize()
	{
		setUp1();
		assertTrue("Debería estar vacía", arbolito.isEmpty());
		setUp2();
		assertEquals("No da el size esperado", 200, arbolito.size());
		
	}
	
	@Test
	public void testGet()
	{
		setUp2();
		assertTrue(arbolito.get(200).equals(200));
		assertTrue(!arbolito.contains(300));
	}
	
	@Test
	public void testHeight()
	{
		setUp2();
		assertEquals ("No da la altura esperada", arbolito.height(), 9);
	}
	
	@Test
	public void testValuesInRange()
	{	setUp2();
		Iterator <Integer> respuesta =arbolito.values(50, 150).iterator();
		int s=0;
		
		while(respuesta.hasNext())
		{
			Integer compi1 = respuesta.next();
			s++;
		}
		
		assertEquals(s, 101);
	}
}
