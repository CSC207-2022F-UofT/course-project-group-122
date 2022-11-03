package entities;

public interface UserFactoryInterface {
    User create(String type, String username, String name);
}
