// Bahar Topkaya 240446001 week5 lab3 19.10.2026
public class MusicPlaylist {
    private SongNode head;
    private SongNode tail;
    private SongNode current;
    public MusicPlaylist(){
        this.head = null;
        this.tail = null;
        this.current = null;
    }
    public void addSong(String title){
        SongNode newNode = new SongNode(title);
        if (head == null){
            head = newNode;
            tail = newNode;
            current = newNode;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void removeSong(String title){
        SongNode temp = head;
        boolean found = false;

        while ( temp!= null){
            if (temp.title.equals(title)){
                found = true;
                break;
            }
            temp = temp.next;
        }
        if (!found){
            System.out.println("The song isn't in the playlist");
            return;
        }
        if (temp == current){
            if(current.next != null) current = current.next;
            else current = current.prev;
        }
        if (head == tail && temp == head) {
            head = null;
            tail = null;
            current = null;
        }
        else if (temp == head) {
            head = head.next;
            head.prev = null;
        }
        else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Removed: " + title);
    }
    public void nextSong() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Playing: " + current.title);
        } else {
            System.out.println("Already at the last song of the playlist.");
        }
    }
    public void previousSong() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Playing: " + current.title);
        } else {
            System.out.println("Already at the first song of the playlist.");
        }
    }
    public void displayCurrentSong() {
        if (current != null) {
            System.out.println("Current Song: " + current.title);
        } else {
            System.out.println("Playlist is empty.");
        }
    }
    public void displayPlaylist() {
        SongNode temp = head;
        while (temp != null) {
            System.out.print(temp.title + " <-> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
}

