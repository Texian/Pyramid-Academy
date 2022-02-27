public class Player {
    int choice;
    String again;

    public Player() {

    }

    public Player(int choice, String again) {
        this.choice = choice;
        this.again = again;
    }

    public int getGuess() { return choice; }
    public void setGuess(int choice) { this.choice = choice; }

    public String getAgain() { return again; }
    public void setAgain(String again) { this.again = again; }
}