package Game;

public class Player implements Comparable<Player> {
    private String name;
    public Hand hand;
    private boolean has21 = false;
    private float score = 0;

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

    public void setScore(float score) {
        this.score = score;
    }

    public boolean getHas21() {
        return this.has21;
    }

    public void setHas21(boolean has21) {
        this.has21 = has21;
    }

    @Override
    public int compareTo(Player o) {
        return Float.compare(o.score, this.score);
    }
}
