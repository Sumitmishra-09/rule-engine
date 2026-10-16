import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import com.act21.rule.engine.dsl.expression.runtime.HelperFunctions;

public class RuntimeClasspathProbe {
    public static void main(String[] args) throws Exception {
        System.out.println("HelperFunctions loaded from: "
                + HelperFunctions.class.getProtectionDomain().getCodeSource().getLocation());
        System.out.println("appendList signature: "
                + HelperFunctions.class.getMethod("appendList", List.class, List.class));
        for (var resource : Collections.list(Thread.currentThread().getContextClassLoader().getResources(
                "com/act21/rule/engine/dsl/expression/runtime/HelperFunctions.class"))) {
            System.out.println("HelperFunctions resource: " + resource);
        }
        Class<?> testClass = Class.forName("com.act21.impaktapps.rule.engine.test.RegisteredFunctionsTest");
        System.out.println("Test loaded from: " + testClass.getProtectionDomain().getCodeSource().getLocation());
        var method = testClass.getDeclaredMethod("cleanAndGetCodesDoesNotAppendTheSameListTwice");
        method.setAccessible(true);
        try {
            method.invoke(testClass.getDeclaredConstructor().newInstance());
        } catch (InvocationTargetException failure) {
            throw new IllegalStateException("Existing Eclipse-compiled test failed", failure.getCause());
        }
        System.out.println("PASS: cleanAndGetCodesDoesNotAppendTheSameListTwice using existing Eclipse output.");
    }
}
