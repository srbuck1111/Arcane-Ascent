package com.arcaneascent.ArcaneAscentWebapp.spells;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.arcaneascent.ArcaneAscentWebapp.spellbook.*;

public class SpellSkim extends Spell {

	public SpellSkim() {
		super("Skim");
	}
	
	@Override
	public void cast(Book b, int pg) {
		System.out.println("What page would you like to charge?");

		List<Page> options = new ArrayList<>();
		for (Page p : b.getPages()) {
			for (Spell s : p.getAllSpells()) {
				if ((s instanceof SpellSkim)) {
					break;
				}
				options.add(p);
			}
		}

		System.out.println("Page Options:");
		for (Page p : options) {
			System.out.println(p.getPageNumber());
		}
		
		int playerChoice = getOptionChoice(options);
		
		b.getPage(playerChoice).setCharged(true);
		
	}
	
	private static int getOptionChoice(List<Page> options) {
		Scanner scnr = new Scanner(System.in);
		boolean valid = false;
		int input = -1;
		do {
			try {
				input = scnr.nextInt();
				valid = true;
			} catch (InputMismatchException e) {
				System.out.println("Not an option");
			}
		} while (!valid);

		scnr.close();
		return input;
	}

}
