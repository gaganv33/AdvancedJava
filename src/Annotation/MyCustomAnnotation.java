package Annotation;

import java.lang.annotation.*;

@Repeatable(MyCustomAnnotations.class)
public @interface MyCustomAnnotation {
    String category();
}
