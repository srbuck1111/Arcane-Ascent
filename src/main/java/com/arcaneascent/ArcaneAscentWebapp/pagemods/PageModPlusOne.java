package com.arcaneascent.ArcaneAscentWebapp.pagemods;

import com.arcaneascent.ArcaneAscentWebapp.spellbook.*;

public class PageModPlusOne extends PageMod {

	@Override
	public void applyMod(Page p) {
		p.setPlusMod(p.getPlusMod() + 1);
	}

}
