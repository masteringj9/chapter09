package packt.mastering.java9.process;

import packt.mastering.java9.stackwalker.DumpStack;
import packt.mastering.java9.stackwalker.LogSetter;

import java.lang.System.Logger;

public class ProcessLister {
    private static final Logger LOG = System.getLogger(ProcessLister.class.getName());

    static {
        LogSetter.console();
    }

    private static void debug(String format, Object... message) {
        LOG.log(Logger.Level.DEBUG, format, message);
    }

    public static void main(String[] args) {
        LOG.log(Logger.Level.DEBUG, "starting");
        DumpStack.dump(System.out);
        ProcessHandle.allProcesses().map(ProcessHandle::info).forEach(
                (info) -> debug("{0} {1}", info.user().orElse("nobody"),
                        info.command().orElse(info.commandLine().orElse(" noname-process")))
        );
    }

}
