package com.arcaneascent.ArcaneAscentWebapp.utility;

import com.arcaneascent.ArcaneAscentWebapp.spellbook.Book;

/***
 * Contains methods which assist the main game
 * @author Sean Buck
 */
public class ArcaneAscentMethods {
	
	/***
	 * "Upkeep" (Stolen from MTG) starts your turn. <br/>
	 * This casts any spells you scryed last turn in 
	 * addition to your current level's sentry casts. <br/>
	 * 
	 * It then charges your spells for the turn.
	 * 
	 * @param b Book to edit/cast from
	 */
	public static void upkeep(Book b) {
		b.castScrySpells();
		b.castSentrySpells();
		b.chargeSpells();
	}
	
	/***
	 * Completes the current level. <br/> 
	 * Allows player to upgrade their Book and removes all scry and sentry casts from the Book.
	 * 
	 * @param b Book to edit/cast from
	 */
	public static void completeLevel(Book b) {
		//TODO write code for completeLevel()
	}
	
}
