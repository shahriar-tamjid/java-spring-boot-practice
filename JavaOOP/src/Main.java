import HumanBeing.Human;

public class Main {
    // using static variables
    static String GLOBAL_NAME;
    // A static variable in Java is a class-level variable that is shared by all objects of the class and exists only once in memory, regardless of how many instances are created.

    // single line comment
    /* multi line comment */
    /** syntax for documentation */

    public static void main(String[] args) {
        Human human = new Human();
        System.out.println(human.sayHello());;

        GLOBAL_NAME = "Shahriar";
        System.out.println("Global Name: " +GLOBAL_NAME);
    }

}
