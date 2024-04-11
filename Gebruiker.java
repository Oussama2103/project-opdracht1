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
}
