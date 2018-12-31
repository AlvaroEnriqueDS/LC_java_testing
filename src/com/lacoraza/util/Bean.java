package com.lacoraza.util;

public abstract class Bean implements java.io.Serializable
{
	public String getReferencia() 
	{return getClass().getName();}
}
    