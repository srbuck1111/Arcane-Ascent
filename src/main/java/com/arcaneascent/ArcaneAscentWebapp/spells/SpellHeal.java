package com.arcaneascent.ArcaneAscentWebapp.spells;

import com.arcaneascent.ArcaneAscentWebapp.spellbook.*;

//Spell Heal(X) heals X health. CAN overheal.
public class SpellHeal extends Spell {
	
	public SpellHeal() {
		super("Heal");
	}

	@Override
	public void cast(Book b, int pg) {
		Page p = b.getPage(pg);
		int healing = 4 + p.getPlusMod();
		p.setHealing(p.getHealing() + healing);
	}

}
