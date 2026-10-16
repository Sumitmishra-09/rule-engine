import com.act21.rule.engine.dsl.expression.runtime.HelperFunctions;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/** Characterizes the actual dependency-free 1.0.43 helper source. Not a full DSL test. */
public class HelperSemanticsProbe {
    private static int checks;
    private static void check(String name, Object expected, Object actual) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionError(name + ": expected " + expected + ", got " + actual);
        }
        checks++;
        System.out.println(name + " = " + actual);
    }
    private static void fails(String name, Class<? extends Throwable> expected, Runnable action) {
        try { action.run(); }
        catch (Throwable t) {
            if (!expected.isInstance(t)) throw new AssertionError(name, t);
            checks++;
            System.out.println(name + " = " + t.getClass().getSimpleName());
            return;
        }
        throw new AssertionError(name + " did not throw");
    }
    public static void main(String[] args) {
        check("decimal equality ignores scale", true, HelperFunctions.equals(new BigDecimal("1.0"), new BigDecimal("1.00")));
        check("scalar membership preserves decimal scale", false, HelperFunctions.in((Object) new BigDecimal("1.0"), new BigDecimal("1.00")));
        check("list membership ignores decimal scale", true, HelperFunctions.in(Arrays.asList(new BigDecimal("1.0")), new BigDecimal("1.00")));
        check("contains uses any candidate", true, HelperFunctions.contains("abc", "x", "b"));
        check("contains rejects empty candidate", false, HelperFunctions.contains("abc", ""));
        check("containsIgnoreCase accepts empty candidate", true, HelperFunctions.containsIgnoreCase("abc", ""));
        check("null equality", true, HelperFunctions.equals(null, null));
        fails("null case-insensitive lhs", NullPointerException.class, () -> HelperFunctions.equalsIgnoreCase(null, "x"));
        fails("Long to Integer conversion", ClassCastException.class, () -> HelperFunctions.convertToInt(1L));
        check("Integer to decimal conversion", null, HelperFunctions.convertToBigDecimal(Integer.valueOf(1)));
        check("division result and scale", new BigDecimal("0.50000000000000000000"), HelperFunctions.divide(1L, 2L));
        check("average counts null argument in divisor", new BigDecimal("5.00"), HelperFunctions.avg(10L, null));
        check("average rounds to two decimal places", new BigDecimal("12.33"), HelperFunctions.avg(10L, 12L, 15L));
        check("list output appends", Arrays.asList("existing", "new"), HelperFunctions.addAll(new ArrayList<>(Arrays.asList("existing")), "new"));
        check("date difference is first minus second", 2L, HelperFunctions.diffDays(HelperFunctions.convertToDate("03/01/2026"), HelperFunctions.convertToDate("01/01/2026")));
        System.out.println("PASS " + checks + " helper checks; parser and engine execution not covered");
    }
}
