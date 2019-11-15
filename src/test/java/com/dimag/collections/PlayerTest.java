package com.dimag.collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//Junit 5
//Test-driven coding
public class PlayerTest {


	@Test
	public void getSongByTitle() throws Exception {
		Player p = new Player();
		p.addSong(new Music("Tarkan", 50, "Firoze", "pop", "./tarkan/firoze.mp3"));
		p.playTitle("Firoze");
		String title = p.getCurrentSongTitle();
		assertEquals("Firoze", title);
	}

	@Test(expected = Exception.class)
	public void getSongByTitleWithExeption() throws Exception {
		Player p = new Player();
		p.addSong(new Music("Tarkan", 50, "Firoze", "pop", "./tarkan/firoze.mp3"));
		String title = p.getCurrentSongTitle();
	}

	@Test
	public void getCurrentSongTitle() throws Exception {
		Player p = new Player();
		p.addSong(new Music("Tarkan", 50, "Firoze", "pop", "./tarkan/firoze.mp3"));
		p.playTitle("Firoze");
		String title = p.getCurrentSongTitle();
		assertEquals("Firoze", title);
	}
}