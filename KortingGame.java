public class KortingGame {
    private Game game;
    private double kortingPercentage;

    public KortingGame (Game game, double kortingPercentage) {
        this.game = game;
        this.kortingPercentage = kortingPercentage;
    }

    public Game getGame () {
        return game;
    }

    public double getKortingPercentage() {
        return kortingPercentage;
    }

    public void setGame (Game game) {
        this.game = game;
    }

    public void setKortingPercentage(double kortingPercentage) {
        this.kortingPercentage = kortingPercentage;
    }

    public void geefKorting () {
        double huidigePrijs = game.getPrijs();
        double kortingBedrag = huidigePrijs * (kortingPercentage / 100);
        double nieuwePrijs = huidigePrijs - kortingBedrag;
        game.setPrijs(nieuwePrijs);
    }
}
