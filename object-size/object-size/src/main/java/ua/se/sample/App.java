package ua.se.sample;

import ua.se.sample.models.User;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        User[] cachedUsers = new User[1_000_000];

        for(int i = 0;i<1_000_000;i++){
            User tempUser = new User();
            tempUser.id = (long)i;
            tempUser.name = UUID.randomUUID().toString();
            tempUser.salary = (int)i;
            tempUser.account = (double) i;
            tempUser.isActive = Boolean.FALSE;
            cachedUsers[i] = tempUser;
        }

        while (true) {
            int a =0;
        }
    }
}
