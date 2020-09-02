package com.arcaneascent.ArcaneAscentWebapp.spellbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/***
 * Holds the data for each page in the spellbook (duh.) <br/>
 * Additionally, holds values that PageMod objects modify, such as plusMod and innate.
 * 
 * @author Sean Buck
 */
public class Page {
	
	private Integer pageNumber;
	//first Spell in orSpells is the original spell of the Page
	private List<Spell> orSpells;
	private List<Spell> andSpells;
	private Integer plusMod;
	private Integer damage;
	private Integer healing;
	private Integer protection;
	private Integer recasts;
	private Boolean charged;
	private Boolean innate;

	public Page(int pgNumber, Spell starterSpell) {
		this.pageNumber = pgNumber;
		this.orSpells = new ArrayList<>();
		this.orSpells.add(starterSpell);
		this.andSpells = new ArrayList<>();
		this.plusMod = 0;
		this.damage = 0;
		this.healing = 0;
		this.plusMod = 0;
		this.recasts = 0;
		this.charged = false;
		this.innate = false;
	}

	public void cast(Book b) {
		if (this.charged) {
			// TODO choose or spell
			if (!(this.orSpells.size() > 1)) {
				this.orSpells.get(0).cast(b, this.pageNumber);
			} else {
				this.orSpells.get(chooseOrSpell()).cast(b, this.pageNumber);
			}
				
			if (!andSpells.isEmpty()) {
				for (Spell spell : andSpells) {
					spell.cast(b, pageNumber);
				}
			}
		} else {
			System.out.println("not charged");
		}
	}
	
	private int chooseOrSpell() {
		int i = 0;
		for (Spell s : this.orSpells) {
			i++;
			System.out.println(i + ". " + s.getName());
		}
		System.out.print("Which spell would you like to cast?");
		Scanner scnr = new Scanner(System.in);
		int choice = scnr.nextInt();
		scnr.close();
		return choice;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public List<Spell> getOrSpells() {
		return orSpells;
	}

	public void setOrSpells(List<Spell> orSpells) {
		this.orSpells = orSpells;
	}

	public List<Spell> getAndSpells() {
		return andSpells;
	}

	public void setAndSpells(List<Spell> andSpells) {
		this.andSpells = andSpells;
	}

	public List<Spell> getAllSpells() {
		List<Spell> allSpells = new ArrayList<>();
		allSpells.addAll(orSpells);
		allSpells.addAll(andSpells);
		return allSpells;
	}

	public Integer getPlusMod() {
		return plusMod;
	}

	public void setPlusMod(Integer plusMod) {
		this.plusMod = plusMod;
	}

	public Integer getDamage() {
		return damage;
	}

	public void setDamage(Integer damage) {
		this.damage = damage;
	}

	public Integer getHealing() {
		return healing;
	}

	public void setHealing(Integer healing) {
		this.healing = healing;
	}

	public Integer getProtection() {
		return protection;
	}

	public void setProtection(Integer protection) {
		this.protection = protection;
	}

	public Integer getRecasts() {
		return recasts;
	}

	public void setRecasts(Integer recasts) {
		this.recasts = recasts;
	}

	public Boolean getCharged() {
		return charged;
	}

	public void setCharged(Boolean charged) {
		this.charged = charged;
	}

	public Boolean getInnate() {
		return innate;
	}

	public void setInnate(Boolean innate) {
		this.innate = innate;
	}

}
