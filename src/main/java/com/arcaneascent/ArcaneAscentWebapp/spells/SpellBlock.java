package com.arcaneascent.ArcaneAscentWebapp.spells;

import com.arcaneascent.ArcaneAscentWebapp.spellbook.*;

public class SpellBlock extends Spell {

	public SpellBlock() {
		super("Block");
	}
	
	@Override
	public void cast(Book b, int pg) {
		Page p = b.getPage(pg);
		int protection = 4 + p.getPlusMod();
		p.setProtection(p.getProtection() + protection);
	}

}
