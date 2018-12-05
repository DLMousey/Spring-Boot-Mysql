package hello;

import org.springframework.data.repository.CrudRepository;

import hello.User;

// This interface will have it's methods auto-magically populated by Spring
public interface UserRepository extends CrudRepository<User, Integer> {

}
