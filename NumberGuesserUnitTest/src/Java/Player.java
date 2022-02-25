public class Player {
    String name;
    int guess;
    String again;

    public Player() {

    }

    public Player(String name, int guess, String again) {
        this.name = name;
        this.guess = guess;
        this.again = again;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getGuess() { return guess; }
    public void setGuess(int guess) { this.guess = guess; }

    public String getAgain() { return again; }
    public void setAgain(String again) { this.again = again; }
}
