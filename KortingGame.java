import java.util.List;

public class KortingGame {
    private Game game;
    private double kortingPercentage;

    public KortingGame(Game game, double kortingPercentage) {
        this.game = game;
        this.kortingPercentage = kortingPercentage;
    }

    public Game getGame() {
        return game;
    }

    public double getKortingPercentage() {
        return kortingPercentage;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setKortingPercentage(double kortingPercentage) {
        this.kortingPercentage = kortingPercentage;
    }

    public void geefKorting() {
        double gemiddeldeRating = berekenGemiddeldeRating(game.getReviews());
        // Pas de korting aan op basis van de gemiddelde rating
        if (gemiddeldeRating < 5.0) {
            kortingPercentage = 20.0; // Hoge korting als de gemiddelde rating laag is
        } else if (gemiddeldeRating >= 5.0 && gemiddeldeRating < 7.5) {
            kortingPercentage = 10.0; // Matige korting als de gemiddelde rating gemiddeld is
        } else {
            kortingPercentage = 5.0; // Lage korting als de gemiddelde rating hoog is
        }

        // Bereken de nieuwe prijs met de korting
        double huidigePrijs = game.getPrice();
        double kortingBedrag = huidigePrijs * (kortingPercentage / 100);
        double nieuwePrijs = huidigePrijs - kortingBedrag;
        game.setPrice(nieuwePrijs);
    }

    private double berekenGemiddeldeRating(List<Review> reviews) {
        if (reviews.isEmpty()) {
            return 0.0;
        }
        int totaalScore = 0;
        for (Review review : reviews) {
            totaalScore += (review.getGraphicsScore() + review.getGameplayScore() + review.getStorylineScore()) / 3;
        }
        return (double) totaalScore / reviews.size();
    }
}
