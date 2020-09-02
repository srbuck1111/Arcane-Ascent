package com.arcaneascent.ArcaneAscentWebapp.spellbook;

import java.util.ArrayList;
import java.util.List;

import com.arcaneascent.ArcaneAscentWebapp.spells.*;

/***
 * @author Sean Buck
 */
public class Book {

	private final int ROLLS_FOR_CHARGING = 3;
	
	private List<Page> pages;
	private Integer pageCount;
	private List<Page> scryCasts;
	private List<Page> sentryCasts;
	
	public Book() {
		List<Page> starterPages = new ArrayList<>();
		//TODO create an addPage method so this can be slightly less hideous
		starterPages.add(new Page(1, new SpellBlast()));
		starterPages.add(new Page(2, new SpellBlast()));
		starterPages.add(new Page(3, new SpellBlock()));
		starterPages.add(new Page(4, new SpellBlock()));
		starterPages.add(new Page(5, new SpellHeal()));
		starterPages.add(new Page(6, new SpellScry()));
		this.setPages(starterPages);
		this.scryCasts = new ArrayList<>();
		this.sentryCasts = new ArrayList<>();
	}
	
	public void addPage(Spell s) {
		pages.add(new Page(pageCount + 1, s));
		this.pageCount = pages.size();
	}

	/***
	 * utilizes Page's cast method to cast the entire page
	 * @param pageNumber page to cast
	 */
	public void castPage(int pageNumber) {
		this.getPage(pageNumber).cast(this);
	}
	
	/***
	 * charges innate spells, then remaining rolls are spent
	 * utilizes allPagesCharged() to return early if needed
	 */
	public void chargeSpells() {
		int rollsForCharging = ROLLS_FOR_CHARGING;
		for (Page p : this.getPages()) {
			if (p.getInnate()) {
				p.setCharged(true);
				rollsForCharging--;
			}
		}
		for (int i = 0; i < rollsForCharging;) {
			if (this.allPagesCharged())
				return;
			int roll = (int) (Math.random() * this.pageCount);
			if (!this.getPage(roll).getCharged()) {
				this.getPage(roll).setCharged(true);
				i++;
			}
		}
	}
	
	/***
	 * Checks if all Pages are charged
	 * @return true by default, false if any page is uncharged.
	 */
	private boolean allPagesCharged() {
		for (Page p : this.getPages()) {
			if (!p.getCharged()) {
				return false;
			}
		}
		return true;
	}
	
	/***
	 * Casts all spells from scry list, then clears the scry list.
	 * @param b Book to cast from
	 */
	public void castScrySpells() {
		for (Page p : this.getScryCasts()) {
			p.cast(this);
		}
		this.removeAllScryCasts();
	}
	
	/***
	 * Casts all sentry spells
	 * @param b Book to cast from
	 */
	public void castSentrySpells() {
		for (Page p : this.getSentryCasts()) {
			p.cast(this);
		}
	}

	public List<Page> getPages() {
		return pages;
	}

	public Page getPage(int i) {
		return this.pages.get(i);
	}

	/***
	 * Sets pages, and updates the instance's pageCount variable
	 * @param pages List of pages to set.
	 */
	public void setPages(List<Page> pages) {
		this.pages = pages;
		this.pageCount = pages.size();
	}
	
	public List<Page> getScryCasts() {
		return scryCasts;
	}

	public void setScryCasts(List<Page> scryCasts) {
		this.scryCasts = scryCasts;
	}
	
	public void addScryCast(Page p) {
		this.scryCasts.add(p);
	}
	
	public void removeAllScryCasts() {
		this.scryCasts.clear();
	}

	public List<Page> getSentryCasts() {
		return sentryCasts;
	}

	public void setSentryCasts(List<Page> sentryCasts) {
		this.sentryCasts = sentryCasts;
	}
	
	public void removeAllSentryCasts() {
		this.sentryCasts.clear();
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	
}
