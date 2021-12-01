package fr.lernejo.guessgame;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.security.SecureRandom;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me

        this.player = player;
    }

    public void initialize(long numberToGuess) {
        //TODO implement me

        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me

        long number = player.askNextGuess();

        if (number == numberToGuess)
        {
            logger.log("Good answer !\n");

            return true;
        }

        else if (number < numberToGuess)
        {
            player.respond(true);
        }

        else
        {
            player.respond(false);
        }

        return false;
    }

    public void loopUntilPlayerSucceed() {
        //TODO implement me
        int count = 0;

        while(!nextRound())
        {
            count++;
            logger.log("Try again !\n");
        }

        logger.log("You founds in " + count + " round(s) !\n");
    }
}
