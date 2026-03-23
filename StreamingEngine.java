abstract class Media{
    private String title;
    private int duration; // in minutes
    protected boolean isPremium;
    Media(String title, int duration){
        this.title=title;
        this.duration=duration;
    }
    void getTitle(){
        System.out.println("Title: " + title);
    }
    void getDetails(){
        System.out.println("Title: " + title);
        System.out.println("Duration: " + duration + " minutes");
    }
    abstract void playContent();
}

class Movie extends Media{
    protected boolean isPremium=false;
    Movie(String title, int duration, boolean isPremium){
        super(title, duration);
        this.isPremium=isPremium;
    }
    @Override
    void playContent() {
        System.out.println("Verifying subscription....");
        if(isPremium){
            System.out.println("This is premium content. Please subscribe to access.");
        }
        else{
            System.out.print("Playing movie: ");
            getTitle();
            
        }
    }
}

class Podcast extends Media{
    Podcast(String title, int duration){
        super(title, duration);
    }
    @Override
    void playContent() {
        System.out.println("Loading advertisement...");
        System.out.print("Playing podcast: ");
        getTitle();
    }
}

public class StreamingEngine {
    public static void main(String[] args) {
        Movie movie1 = new Movie("Inception", 148,true);
        Podcast podcast1 = new Podcast("Tech Talk", 30);
        
        movie1.playContent();
        System.out.println();
        podcast1.playContent();
        System.out.println();
        Movie movie2 = new Movie("free guy", 115,false);
        System.out.println();
        movie2.playContent();
    }
}