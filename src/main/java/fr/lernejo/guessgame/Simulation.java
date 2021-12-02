package fr.lernejo.guessgame;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public void loopUntilPlayerSucceed(long nbmax) {
        //TODO implement me
        int count = 1;
        boolean failed = false;
        long beforeTime = System.currentTimeMillis();

        while(!nextRound())
        {
            count++;

            if (count == nbmax)
            {
                logger.log("No more try ...\n");
                failed = true;
                break;
            }

            logger.log("Try again !\n");
        }

        if (!failed)
        {
            logger.log("You founds in " + count + " round(s) !\n");
        }

        else
        {
            logger.log("The number was " + numberToGuess + " !\n");
        }

        long currentTime = System.currentTimeMillis();

        long timeUsed = currentTime - beforeTime;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss:SSS");
        Date date = new Date(timeUsed);
        String time = simpleDateFormat.format(date);
        logger.log("Time elapsed : " + time + "\n");
    }
}
