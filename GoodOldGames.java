import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodOldGames {
    private Map<String, Game> retroGames;

    public GoodOldGames() {
        this.retroGames = new HashMap<>();
    }

    public void addGame(String name, double price) {
        retroGames.put(name, new Game(name, price));
    }

    public void addReview(String gameName, Review review) {
        Game game = retroGames.get(gameName);
        if (game != null) {
            game.addReview(review);
            System.out.println("Review toegevoegd.");
        } else {
            System.out.println("Spel niet gevonden.");
        }
    }

    public void displayReviews(String gameName) {
        Game game = retroGames.get(gameName);
        if (game != null) {
            List<Review> reviews = game.getReviews();
            if (!reviews.isEmpty()) {
                System.out.println("Reviews voor " + gameName + ":");
                for (int i = 0; i < reviews.size(); i++) {
                    Review review = reviews.get(i);
                    System.out.println("Review " + (i + 1) + ":");
                    System.out.println("Graphics Score: " + review.getGraphicsScore());
                    System.out.println("Gameplay Score: " + review.getGameplayScore());
                    System.out.println("Storyline Score: " + review.getStorylineScore());
                    System.out.println("Commentaar: " + review.getComment());
                    System.out.println("-----------------------");
                }
            } else {
                System.out.println("Geen reviews gevonden voor " + gameName);
            }
        } else {
            System.out.println("Spel niet gevonden.");
        }
    }

    public void deleteReview(String gameName, int index) {
        Game game = retroGames.get(gameName);
        if (game != null) {
            game.removeReview(index - 1);
            System.out.println("Review verwijderd.");
        } else {
            System.out.println("Spel niet gevonden.");
        }
    }

    public void editReview(String gameName, int index, String newReviewText) {
        Game game = retroGames.get(gameName);
        if (game != null) {
            List<Review> reviews = game.getReviews();
            if (index >= 0 && index < reviews.size()) {
                Review review = reviews.get(index);
                review = new Review(review.getGraphicsScore(), review.getGameplayScore(), review.getStorylineScore(), newReviewText);
                reviews.set(index, review);
                System.out.println("Review aangepast.");
            } else {
                System.out.println("Ongeldige review-index.");
            }
        } else {
            System.out.println("Spel niet gevonden.");
        }
    }
    public List<String> getAvailableGames() {
        List<String> availableGames = new ArrayList<>();
        for (Game game : retroGames.values()) {
            availableGames.add(game.getName());
        }
        return availableGames;
    }
    public Game getGameByName(String gameName) {
        return retroGames.get(gameName);
    }
    public boolean gameExists(String gameName) {
        return retroGames.containsKey(gameName);
    }
}