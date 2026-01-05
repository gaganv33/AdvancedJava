package Annotation;

@MyCustomAnnotation(category = "Category - 1")
@MyCustomAnnotation(category = "Category - 2")
@MyCustomAnnotation(category = "Category - 3")
public class Player {
    private final String name;
    private final String teamName;

    public Player(String name, String teamName) {
        this.name = name;
        this.teamName = teamName;
    }
}
