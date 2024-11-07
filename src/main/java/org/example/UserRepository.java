package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class UserRepository {
    private List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
    }

    public Optional<User> findUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public Optional<User> findUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public Optional<List<User>> findAllUsers() {
        if (users.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(users);
    }

    public void addUser(User user) {
        users.add(user);
    }
}