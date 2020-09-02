package com.arcaneascent.ArcaneAscentWebapp.spells;

import com.arcaneascent.ArcaneAscentWebapp.spellbook.*;

//Blast(X): deal (X) damage
public class SpellBlast extends Spell {
	
	public SpellBlast() {
		super("Blast");
	}

	@Override
	public void cast(Book b, int pg) {
		Page p = b.getPage(pg);
		int damage = 4 + p.getPlusMod();
		p.setDamage(p.getDamage() + damage);
	}

}
