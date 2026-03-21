abstract class LibraryItem {
    private String itemId;
    private String title;
    LibraryItem(String itemId, String title) {
        this.itemId = itemId;
        this.title = title;
    }
    protected boolean isReserved = false;
    void showDetails() {
        System.out.print("ID: " + this.itemId + ", Title: " + this.title);
    }
    abstract void processLoan();

}

class Textbook extends LibraryItem {
    Textbook(String itemId, String title) {
        super(itemId, title);
    }
    @Override
    void processLoan() {
        if (!isReserved) {
            this.showDetails() ;
            System.out.println(" issued");
            System.out.println();
            isReserved = true;
        } else {
            
            this.showDetails();
            System.out.println(" is already reserved.");
            System.out.println();
        }
    }
}

class ResearchPaper extends LibraryItem {
    ResearchPaper(String itemId, String title, String author) {
        super(itemId, title);
    }
    @Override
    void processLoan() {
        System.out.println("Generating secure PDF link...");
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Textbook tb = new Textbook("B101", "Java Core");
        tb.processLoan();
        tb.processLoan();


        ResearchPaper rp = new ResearchPaper("RP202", "AI in Healthcare", "Dr. Smith");
        rp.processLoan();
    }
}
