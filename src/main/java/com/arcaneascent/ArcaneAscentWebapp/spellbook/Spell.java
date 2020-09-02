package com.arcaneascent.ArcaneAscentWebapp.spellbook;

/***
 * Abstract class which holds all types of castable spells as subclasses 
 * @author Sean Buck
 */
public abstract class Spell {
	
	private String name;
	
	public abstract void cast(Book b, int pg);
	
//TODO comment each Spell subclass with what it does
	public Spell(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
