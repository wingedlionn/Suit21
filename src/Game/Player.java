package Game;

public class Player {
    private String name;
    public Hand hand;
    public boolean has21 = false;
    float score = 0;

    public Player(String name) {
        setName(name);
        hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return this.score;
    }

    public void getScore(int score) {
        this.score = score;
    }
}
