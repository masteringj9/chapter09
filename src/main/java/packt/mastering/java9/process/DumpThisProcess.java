package packt.mastering.java9.process;

import java.lang.ProcessHandle.Info;
import java.time.Duration;
import java.time.Instant;

import static packt.mastering.java9.process.DemoOutput.out;

public class DumpThisProcess {
    public static void main(String[] args) {
        ProcessHandle me = ProcessHandle.current();
        Info info = me.info();
        out("Command: {0}", info.command().orElse("??"));
        out("Command Line: {0}", info.commandLine().orElse("not present"));
        out("Arguments: {0}", String.join(" ", info.arguments().orElse(new String[0])));
        out("Number of arguments: {0}", info.arguments().orElse(new String[0]).length);
        out("CPU: {0}", info.totalCpuDuration().orElse(Duration.ZERO));
        out("Start time: {0}", info.startInstant().orElse(Instant.EPOCH));
        out("User: {0}", info.user().orElse("??"));
        out("Pid: {0,number,#}", me.getPid());
        out("Children","");
        me.children().forEach( child -> out("child pid:",child.getPid()));
        out("Descendants","");
        me.descendants().forEach( descendant -> out("descendant pid:",descendant.getPid()));
        out("toString {0}",me.info().toString());
    }
}
