package Entities;

public interface UserFactoryInterface {
    User create(String type, String username, String name) throws Exception;
}
