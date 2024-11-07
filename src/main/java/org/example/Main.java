package org.example;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        userRepository.addUser(new User(1, "Іван", "ivan@gmail.com"));
        userRepository.addUser(new User(2, "Денис", "denys@gmail.com"));

        // a. Пошук користувача за id
        Optional<User> userById = userRepository.findUserById(1);
        if (userById.isPresent()) {
            User user = userById.get();
            System.out.println("Користувач з id **" + user.getId() + "**: " + user.getName() + ", " + user.getEmail());
        } else {
            System.out.println("Користувача з таким id не знайдено.");
        }

        // b. Пошук користувача за email
        Optional<User> userByEmail = userRepository.findUserByEmail("denys@gmail.com");
        if (userByEmail.isPresent()) {
            User user = userByEmail.get();
            System.out.println("Користувач з email **" + user.getEmail() + "**: " + user.getName() + ", " + user.getId());
        } else {
            System.out.println("Користувача з таким email не знайдено.");
        }

        // c. Отримання списку всіх користувачів
        Optional<List<User>> allUsers = userRepository.findAllUsers();
        if (allUsers.isPresent()) {
            List<User> users = allUsers.get();
            System.out.println("Кількість користувачів: **" + users.size() + "**");
        } else {
            System.out.println("Список користувачів порожній.");
        }
    }
}