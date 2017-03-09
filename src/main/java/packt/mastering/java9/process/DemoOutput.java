package packt.mastering.java9.process;

import java.text.MessageFormat;

public class DemoOutput {
    static void out(String format, Object... message) {
        System.out.println(MessageFormat.format(format, message));
    }
}
