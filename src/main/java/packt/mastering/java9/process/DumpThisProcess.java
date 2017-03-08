package packt.mastering.java9.process;

import packt.mastering.java9.stackwalker.LogSetter;

import java.lang.ProcessHandle.Info;
import java.lang.System.Logger;
import java.time.Duration;
import java.time.Instant;

public class DumpThisProcess {
    private static final Logger LOG = System.getLogger(DumpThisProcess.class.getName());

    static {
        LogSetter.console();
    }

    private static void debug(String format, Object... message) {
        LOG.log(Logger.Level.DEBUG, format, message);
    }

    private static boolean looksLikeJavaProcess(Info info){
        return info.command().isPresent() &&
                info.command().get().toLowerCase().indexOf("java") != -1;
    }

    public static void main(String[] args) {
        ProcessHandle me =ProcessHandle.current();
        Info info = me.info();
        debug("Command: {0}",info.command().orElse("??"));
        debug("Command Line: {0}",info.commandLine().orElse("??"));
        debug("Arguments: {0}",String.join(" ",info.arguments().orElse(new String[0])));
        debug("CPU: {0}",info.totalCpuDuration().orElse(Duration.ZERO));
        debug("Start time: {0}",info.startInstant().orElse(Instant.EPOCH));
        debug("User: {0}",info.user().orElse("??"));
        debug("Pid: {0,number,#}",me.getPid());
    }

}
