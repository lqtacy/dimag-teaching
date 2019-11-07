package com.dimag.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MusicStorage {
	private List<Music> songs = new ArrayList<>();

	public void add(Music music) {
		songs.add(music);

	}

	public void removeById(UUID id) {
		for (int i = 0; i < songs.size(); i++) {
			if (songs.get(i).getId().equals(id)) {
				songs.remove(i);
				break;
			}
		}
	}

	public Optional<Music> getSong(UUID id) {
		Optional<Music> music = songs.stream()
				.filter(x -> x.getId().equals(id)).findFirst();

		return music;
	}
	public Optional<Music> getSongByTitle(String title) {
		Optional<Music> music = songs.stream()
				.filter(x -> x.getTitle().equals(title)).findFirst();

		return music;
	}

	public List<Music> getSongs() {
		return songs;
	}
}
