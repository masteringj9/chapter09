package packt.mastering.java9.process;

import packt.mastering.java9.stackwalker.DumpStack;
import packt.mastering.java9.stackwalker.LogSetter;

import java.lang.ProcessHandle.Info;
import java.lang.System.Logger;

public class ProcessLister {
    private static final Logger LOG = System.getLogger(ProcessLister.class.getName());

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
        ProcessHandle.allProcesses().
                map(ProcessHandle::info).
                filter( info -> looksLikeJavaProcess(info) ).
                forEach(
                (info) -> debug("{0} {1}", info.user().orElse("nobody"),
                        info.command().orElse(" noname-process"))
        );
    }

}
