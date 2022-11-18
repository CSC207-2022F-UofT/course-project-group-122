package Main;

import entities.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("BananaAnna", "Anna Banana");
        System.out.println(user.getId());
    }
}
