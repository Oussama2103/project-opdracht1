import java.util.ArrayList;
import java.util.List;

class Eigenaar {
    private ArrayList<Review> reviewLijst;

    public Eigenaar() {
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
