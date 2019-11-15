package com.dimag.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Player {
	private List<Music> playList = new ArrayList<>();
	private Optional<Music> currentMusic = Optional.empty();

	public void addSong(Music music) {
		playList.add(music);
	}

	public void addSongs(List<Music> songList) {
		playList.addAll(songList);
	}

	public void play(UUID id) {
		Optional<Music> music = getSong(id);
		currentMusic = music;
		if (music.isPresent()) {
			System.out.println("Music caliniyor:" + music.get().getTitle());
		}
	}

	public void playTitle(String title) throws Exception {
		Optional<Music> m = getSongByTitle(title);
		if (m.isPresent()) {
			play(m.get().getId());
		} else {
			throw new Exception("Music bulunadi:" + title);
		}
	}


	public void stop() {
		if (currentMusic.isPresent()) {
			System.out.println("Musik durduruldu:" + currentMusic.get().getTitle());
		}
	}

	private Optional<Music> getSong(UUID id) {
		Optional<Music> music = playList.stream()
				.filter(x -> x.getId().equals(id)).findFirst();

		return music;
	}

	public Optional<Music> getSongByTitle(String title) {
		Optional<Music> music = playList.stream()
				.filter(x -> x.getTitle().equals(title)).findFirst();

		return music;
	}

	public String getCurrentSongTitle() throws Exception {
		if (currentMusic.isPresent()) {
			return currentMusic.get().getTitle();
		} else {
			throw new Exception("Calinan bir music yok...");
		}
	}


}
