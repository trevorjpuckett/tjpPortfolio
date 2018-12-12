package com.tjp.Karaoke;

import com.tjp.Karaoke.models.SongBook;

public class Karaoke {

    private SongBook songBook;
    private KaraokeMachine machine;

    public Karaoke(){
        songBook = new SongBook();
        songBook.importFrom("songs.txt");
        machine = new KaraokeMachine(songBook);
    }

    public void runKaraoke() {
        machine.run();
        System.out.printf("%nSaving book....");
        songBook.exportTo("songs.txt");

    }
}