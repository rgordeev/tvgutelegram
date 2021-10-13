package ru.tversu.telegram.rpository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tversu.telegram.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
