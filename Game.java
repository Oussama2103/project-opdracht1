import java.util.List;
import java.util.ArrayList;

class Game {
    private String name;
    private double price;
    private List<Review> reviews;

    public Game(String name, double price) {
        this.name = name;
        this.price = price;
        this.reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void removeReview(int index) {
        if (index >= 0 && index < reviews.size()) {
            reviews.remove(index);
        }
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
