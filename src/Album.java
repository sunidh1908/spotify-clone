import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean findSong(String title){

        for(Song checkSong : this.songs){

            if(checkSong.getTitle().equals(title)) {
                System.out.println("Song Found !!");
                return true;
            }
        }
        return false;
    }

    public boolean addSong(String title, double duration){
        if(this.findSong(title) == true){
            System.out.print("Song Already Exists !!");
            return false;
        }
        Song newSong = new Song(title, duration);
        this.songs.add(newSong);
        return true;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList){
        for(Song checkSong : this.songs) {
            if (checkSong.getTitle().equals(title)) {
                playList.add(checkSong);
                System.out.println("Successfully Added !!");
                return true;
            }
        }
        return false;
    }

    public boolean addToPlayList(int songNumber, LinkedList<Song> playList){
        int index = songNumber - 1;
        if(index >= 0 && index < this.songs.size()){
            playList.add(this.songs.get(index));
            System.out.println("Successfully Added !!");
            return true;
        }
        return false;
    }
}
