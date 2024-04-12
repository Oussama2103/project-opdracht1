import java.util.ArrayList;
import java.util.List;

public class Review {
    private int graphicsScore;
    private int gameplayScore;
    private int storylineScore;
    private String feedback;
    private Vragenlijst vragenlijst;

    public Review(int graphicsScore, int gameplayScore, int storylineScore, String feedback, Vragenlijst vragenlijst) {
        this.graphicsScore = graphicsScore;
        this.gameplayScore = gameplayScore;
        this.storylineScore = storylineScore;
        this.feedback = feedback;
        this.vragenlijst = vragenlijst;
    }


    public void setGraphicsScore(int graphicsScore) {
        this.graphicsScore = graphicsScore;
    }

    public void setGameplayScore(int gameplayScore) {
        this.gameplayScore = gameplayScore;
    }

    public void setStorylineScore(int storylineScore) {
        this.storylineScore = storylineScore;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setVragenlijst(Vragenlijst vragenlijst) {
        this.vragenlijst = vragenlijst;
    }


    public int getGraphicsScore() {
        return graphicsScore;
    }

    public int getGameplayScore() {
        return gameplayScore;
    }

    public int getStorylineScore() {
        return storylineScore;
    }

    public String getFeedback() {
        return feedback;
    }

    public Vragenlijst getVragenlijst() {
        return vragenlijst;
    }

    public void voegVragenlijst(Vragenlijst vragenlijst) {
        this.vragenlijst = vragenlijst;
    }
}

