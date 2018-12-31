package com.lacoraza.util;
import java.util.ArrayList;
public class Lista 
{
	protected ArrayList lista = new ArrayList();
	private boolean anterior;
	private int disponible;
	/*tama�o del 1 al numPagina*/
	private int numPagina;
	private boolean siguiente;
	private int tamPagina;
	public void eliminarElemento() {
		try {
			lista.remove(0);
		} catch (Exception e) {
		}
	}
	public void eliminarElemento(int index) {
		try {
			lista.remove(index);
		} catch (Exception e) {
		}
	}
	public boolean existeElemento(Bean elemento) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).equals(elemento))
				return true;
		}
		return false;
	}
	public int getDisponible() {
		return disponible;
	}

	public int getNumeroElementos() {
		return lista.size();
	}

	public Bean getElemento() {
		Bean elemento = null;

		try {
			elemento = (Bean) lista.get(0);
		} catch (Exception e) {
		}
		return elemento;
	}
	public String getElementoX(int index) 
	{
		String elemento = null;
		try {
			elemento = (String) lista.get(index + tamPagina * numPagina);
		} catch (Exception e) {
			System.out.println("getElemento" + e);
		}
		return elemento;	
	}
	
	public Bean getElemento(int index) 
	{
		Bean elemento = null;
		try {
			elemento = (Bean) lista.get(index + tamPagina * numPagina);
		} catch (Exception e) {
			System.out.println("getElemento" + e);
		}
		return elemento;
	}
	
	
	//Obtiene la posici�n del primer elemento
	//de la p�gina.
	public int getFirstElementPage(int page) {
		return (page - 1) * getTamPagina() + 1;
	}
	//Obtiene la posici�n del �ltimo elemento
	//de la p�gina.
	public int getLastElementPage(int page) {

		int intPos = 0;

		if (page * getTamPagina() > getTamanio()) {
			intPos =
				(page - 1) * getTamPagina() + getTamanio() % getTamPagina();
		} else {
			intPos = page * getTamPagina();
		}

		return intPos;
	}
	public void getNextPage() {

		int total;
		int restantes;
		total = getTamanio();
		if (total > (numPagina + 1) * tamPagina) {
			numPagina++;

			restantes = total - numPagina * tamPagina;

			if (restantes >= tamPagina)
				disponible = tamPagina;
			else
				disponible = restantes;

			anterior = (numPagina > 0);

			if (restantes > tamPagina)
				siguiente = true;
			else
				siguiente = false;

		}
	}
	//Obtiene el Nro de P�ginas de la Lista.
	public int getNumPagina() 
	{
		//int intPaginas;

		return (int) Math.ceil((double) getTamanio() / (double) getTamPagina());

	}
	public void getPrevPage() {
		if (numPagina > 0) {
			numPagina--;
			disponible = tamPagina;
			siguiente = true;
			anterior = (numPagina > 0);
		}
	}
	public int getTamanio() {
		return lista.size();
	}
	public int getTamPagina() {
		return tamPagina;
	}
	public void Init() {
		tamPagina = 3;
		numPagina = -1;
		getNextPage();
	}
	public boolean isAnterior() {
		return anterior;
	}
	public boolean isSiguiente() {
		return siguiente;
	}
	public void limpiarLista() {
		lista.clear();
	}
	public void setAnterior(boolean newAnterior) {
		anterior = newAnterior;
	}
	public void setDisponible(int newDisponible) {
		disponible = newDisponible;
	}
	public void setElemento(Bean elemento) 
	{
		try 
		{lista.set(lista.size(), elemento);} 
		catch (Exception e) 
		{lista.add(elemento);}
	}
	
	public void setElementoX(String elemento) 
	{
		try 
		{lista.set(lista.size(), elemento);} 
		catch (Exception e) 
		{lista.add(elemento);}
	}
	
	public Bean setElemento(Bean elemento, int index) 
	{
		try 
		{lista.set(index, elemento);} 
		catch (Exception e) 
		{lista.add(elemento);}
		return elemento;
	}
	public void setElementoX(String elemento, int index) 
	{
		try 
		{lista.set(index, elemento);} 
		catch (Exception e) 
		{lista.add(elemento);}		
	}
	
	public void setNumPagina(int newNumPagina) 
	{numPagina = newNumPagina;}
	
	public void setSiguiente(boolean newSiguiente) 
	{siguiente = newSiguiente;}
	
	public void setTamPagina(int newTamPagina) 
	{tamPagina = newTamPagina;}
}