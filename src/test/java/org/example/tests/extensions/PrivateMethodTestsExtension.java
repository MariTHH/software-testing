package org.example.tests.extensions;

import org.junit.jupiter.api.extension.*;

import java.lang.reflect.Method;
import java.util.*;

public class PrivateMethodTestsExtension implements BeforeEachCallback {
    @Override
    public void beforeEach(ExtensionContext context) {
        context.getTestMethod().ifPresent(testMethod -> {
            TestPrivateMethod annotation = testMethod.getAnnotation(TestPrivateMethod.class);
            if (annotation != null) {
                invokePrivateMethod(annotation);
            }
        });
    }

    private void invokePrivateMethod(TestPrivateMethod annotation) {
        try {
            Class<?> clazz = Class.forName(annotation.className());
            Object instance = clazz.getConstructor().newInstance();
            Method method = clazz.getDeclaredMethod(annotation.methodName(), annotation.paramTypes());
            method.setAccessible(true);

            List<Integer> nodeList = new ArrayList<>();
            Set<Integer> visitedSet = new HashSet<>();

            Object result = method.invoke(instance, 0, nodeList, visitedSet);

            System.out.println("Invocation result of " + annotation.methodName() + ": " + result);
        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke private method", e);
        }
    }
}
