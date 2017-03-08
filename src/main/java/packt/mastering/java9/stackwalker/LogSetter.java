package packt.mastering.java9.stackwalker;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

public class LogSetter {
    public static void console() {
        java.util.logging.Logger logger =
                java.util.logging.Logger.getLogger(
                        StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                                .getCallerClass().getName());
        logger.setLevel(Level.ALL);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        handler.setFormatter(new SimpleFormatter());
        logger.addHandler(handler);
    }
}
