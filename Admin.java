import java.util.ArrayList;
import java.util.List;

public class Admin {
    private Gebruiker gebruiker;

    public Admin (Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }
    private ArrayList<Review> reviewLijst;

    public Admin() {
        reviewLijst = new ArrayList<>();
    }

    public void voegReviewToe(Review review) {
        reviewLijst.add(review);
    }

    public List<Review> bekijkReviews() {
        return new ArrayList<>(reviewLijst);
    }

    public void geefReview(int graphicScore, int gameplayScore, int storylineScore, String feedback, Vragenlijst vragenlijst) {
        Review review = new Review(graphicScore, gameplayScore, storylineScore, feedback, vragenlijst);
        voegReviewToe(review);
    }
}