package Annotation;

public class Main {
    public static void main(String[] args) {
        Class<Player> playerClass = Player.class;
        MyCustomAnnotation[] customAnnotations = playerClass.getAnnotationsByType(MyCustomAnnotation.class);
        for (MyCustomAnnotation customAnnotation : customAnnotations) {
            System.out.println(customAnnotation.category());
        }
    }
}
