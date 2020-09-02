package com.arcaneascent.ArcaneAscentWebapp.spells;

import com.arcaneascent.ArcaneAscentWebapp.spellbook.*;

//TODO finish poison spell
//Spell Poison(X) deals X damage the turn of cast, 
//and then X - 1 damage the next turn.
//X is refreshed and additive on recasts
//Ex:
//Turn 1: Poison(3) deals 3 damage.
//Turn 2: Heal(4) heal 4, deal 2 damage.
//Turn 3: Poison(3) deal 4 damage.
//Turn 4: Poison(3) deal 6 damage.
//Turn 5...9: deal 5...4...3...2...1 damage
public class SpellPoison extends Spell {

	public SpellPoison() {
		super("Poison");
	}
	
	@Override
	public void cast(Book b, int pg) {

	}

}
