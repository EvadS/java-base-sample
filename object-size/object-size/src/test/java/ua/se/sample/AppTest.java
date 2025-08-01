package ua.se.sample;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;
import ua.se.sample.models.User;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @BeforeEach
    public void printLn(){
        System.out.println("--------------------------------------------");
    }
    @Test
    @DisplayName("primitive size info")
    public void testPrimitiveInSize() {
        int primitive = 3; // put here any class/object/primitive/array etc
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseInstance(primitive).toPrintable());
    }

    @Test
    @DisplayName("user size info")
    public void testUserInSize() {
        User user = new User();
        user.id  = 1l;
        user.account = 100d;
        user.isActive = true;
        user.name = "name";
        user.salary = 1000;

        int primitive = 3; // put here any class/object/primitive/array etc
       // System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseInstance(user).toPrintable());
    }
}
