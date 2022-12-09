package entities;

public interface UserFactoryInterface {
    User create(int id, String type, String username, String name);
}
