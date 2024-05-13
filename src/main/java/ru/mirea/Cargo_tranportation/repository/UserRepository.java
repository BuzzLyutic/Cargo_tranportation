package ru.mirea.Cargo_tranportation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.mirea.Cargo_tranportation.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
