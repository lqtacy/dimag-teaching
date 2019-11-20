package com.dimag.collections;

import java.util.Optional;

public class MusicManager {
	private Player player = new Player();
	private MusicStorage storage = new MusicStorage();


	public void play(String title) throws Exception {
		player.playTitle(title);
	}

	public void stop() {
		player.stop();
	}

	public void add(Music m) {
		storage.add(m);
	}

	public void createPlayList() {
		storage.getSongs().forEach(song -> {
			Optional<Music> m = storage.getSongByTitle(song.getTitle());
			if (m.isPresent()) {
				player.addSong(m.get());
			}
		});

	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public static void main(String[] args) throws Exception {

		MusicManager manager = new MusicManager();

		manager.add(new Music("Tarkan", 50, "Firoze", "pop", "./tarkan/firoze.mp3"));
		manager.add(new Music("Kahtali Mice", 120, "Sakine", "pop", "./mice/sakine.mp3"));
		manager.add(new Music("Muslum Gurses", 50, "Unutamadim", "pop", "./tarkan/firoze.mp3"));

		manager.createPlayList();

		manager.play("Unutamadim");
		manager.play("Sakine");

		String current = manager.getPlayer().getCurrentSongTitle();
		System.out.println("Playing music is:" + current);
		manager.stop();


	}
}
