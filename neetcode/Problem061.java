// Guess Number Higher or Lower

import java.util.Random;

class GuessGame {

    private int pick;

    public GuessGame() {
        pick = new Random().nextInt(Integer.MAX_VALUE);
    }

    protected int guess(int num) {
        if (pick == num) return 0;
        else if (pick > num) return 1;
        else return -1;
    }

    public void setRandomLimit(int n) {
        pick = new Random().nextInt(n);
    }
}

public class Problem061 extends GuessGame {
    public int guessNumber(int n) {
        int upperLimit = n;
        int lowerLimit = 1;
        int g = lowerLimit + (upperLimit-lowerLimit) / 2;
        while(guess(g)!=0) {
            if (guess(g)<0) upperLimit = g - 1;
            else lowerLimit = g + 1;
            g = (upperLimit + lowerLimit) / 2;
        }
        return g;
    }
}
