import java.util.List;

public class Gebruiker {
    private String username;
    private Review review;

    public Gebruiker (String username, Review review) {
        this.username = username;
        this.review = review;
    }

    public String getUsername () {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public void bekijkReviews(Eigenaar eigenaar) {
        List<Review> reviews = eigenaar.bekijkReviews();
        for (Review review : reviews) {
            System.out.println("graphicScore: " + review.getGraphicsScore());
            System.out.println("gameplayScore: " + review.getGameplayScore());
            System.out.println("storylineScore: " + review.getStorylineScore());
            System.out.println("feedback: " + review.getFeedback());
            System.out.println("vragenlijst: " + review.getVragenlijst());
        }
    }
}
