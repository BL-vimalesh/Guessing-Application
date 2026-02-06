package src;

public class GuessAppMain {
    public static void main(String[] args) {
        GameConfig config = new GameConfig();

        GamePlay gamePlay = new GamePlay(config);
        gamePlay.start();
    }
}
