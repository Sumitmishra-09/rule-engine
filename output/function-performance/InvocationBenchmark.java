package local.benchmark;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.*;
import com.act21.rule.engine.dsl.expression.functions.FunctionRegistry;

/** Narrow call-overhead experiment, not a decision-grid throughput benchmark. */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class InvocationBenchmark {
    public static class Functions {
        public Long add(Long a, Long b) { return a + b; }
    }

    private Functions functions;
    private FunctionRegistry registry;
    private Method reflected;
    private MethodHandle bound;
    private final Long[] values = new Long[256];
    private final Long increment = 3L;
    private int cursor;

    @Setup
    public void setup() throws Exception {
        functions = new Functions();
        registry = FunctionRegistry.builder()
                .register("add", functions, "add", Long.class, Long.class).build();
        reflected = Functions.class.getMethod("add", Long.class, Long.class);
        bound = MethodHandles.lookup().unreflect(reflected).bindTo(functions);
        for (int i = 0; i < values.length; i++) values[i] = 1000L + i;
    }

    private Long next() { return values[cursor++ & 255]; }

    @Benchmark
    public Long directCall() {
        return functions.add(next(), increment);
    }

    @Benchmark
    public Long currentRegistry() {
        return (Long) registry.invoke("add", new Object[]{next(), increment});
    }

    @Benchmark
    public Long cachedReflection() throws Exception {
        return (Long) reflected.invoke(functions, new Object[]{next(), increment});
    }

    @Benchmark
    public Long boundHandleExact() throws Throwable {
        return (Long) bound.invokeExact(next(), increment);
    }

    @Benchmark
    public Long boundHandleGeneric() throws Throwable {
        return (Long) bound.invokeWithArguments(next(), increment);
    }
}
