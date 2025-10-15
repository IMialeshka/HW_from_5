package by.vadarod.homework.service;

import by.vadarod.homework.entity.SignUp;
import by.vadarod.homework.repository.SignUpRepository;

public class SignUpService {
    private SignUpRepository signUpRepository = new SignUpRepository();

    public void addSignUp(SignUp signUp)
    {
        signUpRepository.addSignUp(signUp);
    }
}
