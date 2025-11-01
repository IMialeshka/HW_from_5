package by.vadarod.homework.service;

import by.vadarod.homework.entity.User;
import by.vadarod.homework.repository.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository = new UserRepository();

    public List<User> findBetweenAgeService(int startYear, int endYear) {
        return userRepository.findBetweenAge(startYear, endYear);
    }
}
