package model.data_structures;

import java.util.Iterator;

public interface IListaEnlazadaQueue <T extends Comparable<T>>
{
	public void enqueue(T parte);
	
	public T dequeue ();
	
	public int darTamanio();
	
	public boolean emptyList();
	
	public Node<T> darPrimerElemento();
	
	public Node <T> darUltimoElemento();

}
