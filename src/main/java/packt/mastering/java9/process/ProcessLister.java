package packt.mastering.java9.process;

import java.lang.ProcessHandle.Info;

import static packt.mastering.java9.process.DemoOutput.out;

public class ProcessLister {

    private static boolean looksLikeJavaProcess(Info info) {
        return info.command().isPresent() &&
                info.command().get().toLowerCase().indexOf("java") != -1;
    }

    public static void main(String[] args) {
        ProcessHandle.allProcesses().
                map(ProcessHandle::info).
                filter(info -> looksLikeJavaProcess(info)).
                forEach(
                        (info) -> out("{0} {1}", info.user().orElse("nobody"),
                                info.command().orElse(" noname-process"))
                );
    }

}
