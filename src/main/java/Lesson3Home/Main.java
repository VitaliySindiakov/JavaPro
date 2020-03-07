package Lesson3Home;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException {
        Container container = new Container();
        Class<?> reflection = container.getClass();
        if (reflection.isAnnotationPresent(SaveTo.class)) {
            SaveTo saveTo = reflection.getAnnotation(SaveTo.class);
            Method[] methods = reflection.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Saver.class)) {
                    try {
                        method.invoke(container, saveTo.path());
                        break;
                    }catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }else System.out.println("No such Annotation");
                continue;
            }

        } else {
            System.out.println("No such Annotation");
            return;
        }
    }

}
