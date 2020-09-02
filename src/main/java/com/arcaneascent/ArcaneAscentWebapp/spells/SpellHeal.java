package com.arcaneascent.ArcaneAscentWebapp.spells;

import com.arcaneascent.ArcaneAscentWebapp.spellbook.*;

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
