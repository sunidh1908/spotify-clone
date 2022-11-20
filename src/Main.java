import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Album album1 = new Album("name", "artist");
        album1.addSong("Kesariya",4.45);
        album1.addSong("Legend", 5.36);
        album1.addSong("Callaboose", 6.30);
        album1.addSong("Chosen", 3.33);

        LinkedList<Song> playList = new LinkedList<>();
        album1.addToPlayList("Kesariya", playList);
        album1.addToPlayList("Legend", playList);
        album1.addToPlayList("Callaboose", playList);
        album1.addToPlayList("Chosen", playList);

        play(playList);
    }

    public static void play(LinkedList<Song> myPlayList){
        Scanner sc = new Scanner(System.in);
        ListIterator<Song> itr = myPlayList.listIterator();

        if(itr.hasNext() == false){
            System.out.println("PlayList is Empty");
            return;
        }

        System.out.println("You are now Listening to : " + itr.next());

        showMenu();

        while(true){
            int option = sc.nextInt();
            boolean forward = true;

            switch (option){
                case 0 :
                    System.out.println("Thanks for listening");
                    return;
                case 1 :
                    showMenu();
                    break;

                case 2 :
                    printList(myPlayList);
                    break;

                case 3 :
                    if(!forward){
                        if(itr.hasNext())
                            itr.next();
                    }
                    if(!itr.hasNext()){
                        System.out.println("PlayList end is reached.");
                    }
                    else{
                        System.out.println("The next song is : " + itr.next());
                    }
                    forward = true;
                    break;

                case 4 :
                    if(forward){
                        if(itr.hasPrevious())
                            itr.previous();
                    }
                    if(!itr.hasPrevious()){
                        System.out.println("PlayList starting is reached.");
                    }
                    else{
                        System.out.println("The song is : " + itr.previous());
                    }
                    forward = false;
                    break;

                case 5 :
                    System.out.println("Currently listening to : " + myPlayList.element());
                    break;

                case 6 :
                    itr.remove();
                    System.out.println("Song Deleted");
                    break;
            }
        }
    }

    public static void showMenu(){
        System.out.println("0. Exit");
        System.out.println("1. Print Menu");
        System.out.println("2. Show the list of all Songs in the playlist");
        System.out.println("3. Play next song");
        System.out.println("4. Play previous Song");
        System.out.println("5. Repeat the song");
        System.out.println("6. Delete the song");
    }

    public static void printList(LinkedList<Song> playList){
        ListIterator<Song> itr = playList.listIterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
