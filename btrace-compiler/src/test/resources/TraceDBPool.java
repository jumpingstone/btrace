import static org.openjdk.btrace.core.BTraceUtils.*;

import org.openjdk.btrace.core.annotations.BTrace;
import org.openjdk.btrace.core.annotations.OnMethod;
import org.openjdk.btrace.core.annotations.Sampled;
import org.openjdk.btrace.core.annotations.Self;

/** @author Jaroslav Bachorik */
@BTrace
public class TraceDBPool {
    @OnMethod(clazz = "com.zaxxer.hikari.pool.HikariPool", method = "getConnection")
    public static void args(@Self Object self) {
        String state = getHikariPoolState(self);
        println("dbpool state = " + state);
    }
}