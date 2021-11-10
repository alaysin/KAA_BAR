package level.up.kaabar.dao;

import level.up.kaabar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
    List<User> findUserByLogin(String login);
}
