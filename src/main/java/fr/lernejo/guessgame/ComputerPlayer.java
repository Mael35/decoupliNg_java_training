package fr.lernejo.guessgame;

public class ComputerPlayer implements Player {

    private long high = Long.MAX_VALUE;
    private long low = 0;
    private long current;

    @Override
    public long askNextGuess() {
        return this.current = (this.high + this.low)/2;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater)
        {
            this.low = this.current;
        }

        else
        {
            this.high = this.current;
        }

        System.out.print(this.current);
    }

}
