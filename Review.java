class Review {
    private int graphicsScore;
    private int gameplayScore;
    private int storylineScore;
    private String comment;

    public Review(int graphicsScore, int gameplayScore, int storylineScore, String comment) {
        this.graphicsScore = graphicsScore;
        this.gameplayScore = gameplayScore;
        this.storylineScore = storylineScore;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }
}
