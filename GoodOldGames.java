import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodOldGames {
    private Map<String, Game> games;

    public GoodOldGames(List<Game> gamesList) {
        this.games = new HashMap<>();
        for (Game game : gamesList) {
            this.games.put(game.getName(), game);
        }
    }

    public void addGame(String name, double price) {
        games.put(name, new Game(name, price));
    }

    public void addReview(String gameName, Review review) {
        Game game = games.get(gameName);
        if (game != null) {
            game.addReview(review);
            System.out.println("Review toegevoegd.");
        } else {
            System.out.println("Spel niet gevonden.");
        }
    }

    public void displayReviews(String gameName) {
        Game game = games.get(gameName);
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
        Game game = games.get(gameName);
        if (game != null) {
            game.removeReview(index - 1);
            System.out.println("Review verwijderd.");
        } else {
            System.out.println("Spel niet gevonden.");
        }
    }

    public void editReview(String gameName, int index, String newReviewText) {
        Game game = games.get(gameName);
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

    public void getAvailableGames() {
        System.out.println("Beschikbare spellen om een review voor te schrijven:");
        for (Game game : games.values()) {
            System.out.println(game.getName());
        }
    }
    public void displayAvailableGames() {
        System.out.println("Beschikbare spellen om een review voor te schrijven:");
        for (String gameName : games.keySet()) {
            System.out.println(gameName);
        }
    }

    public Game getGameByName(String gameName) {
        return games.get(gameName);
    }

    public boolean gameExists(String gameName) {
        return games.containsKey(gameName);
    }
}