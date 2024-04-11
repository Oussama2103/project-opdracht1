import java.util.ArrayList;

public class Game {
    private String name;
    private double prijs;
    private ArrayList <Review> reviews = new ArrayList<Review>();
    private ArrayList <KortingGame> korting = new ArrayList<KortingGame>();

    public Game (String name, double prijs) {
        this.name = name;
        this.prijs = prijs;
    }

    public String getName() {
        return name;
    }

    public double getPrijs() {
        return prijs;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public ArrayList<KortingGame> getKorting() {
        return korting;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }



    public void reviewToevoegen (Review review) {
        reviews.add (review);
    }

    public void addDiscount (KortingGame kortingGame) {
        korting.add (kortingGame);
    }

}
