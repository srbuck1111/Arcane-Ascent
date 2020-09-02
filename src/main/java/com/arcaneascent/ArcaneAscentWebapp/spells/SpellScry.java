package com.arcaneascent.ArcaneAscentWebapp.spells;

import com.arcaneascent.ArcaneAscentWebapp.spellbook.*;

public class SpellScry extends Spell {

	public SpellScry() {
		super("Scry");
	}
	
	@Override
	public void cast(Book b, int pg) {
		int scryCastPage = (int) (Math.random() * b.getPageCount());
		b.addScryCast(b.getPage(scryCastPage));
	}

}
