package fr.lernejo.logger;

public class LoggerFactory implements Logger {
    public static Logger getLogger(String name)
    {
        return new ConsoleLogger();
    }
}
