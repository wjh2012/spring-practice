package practice.domain.user;

public interface UserRepository {

    Long add(String name);

    User read(Long id);
}
