package org.example;

public class WrongFixedPasswordGenerator implements PasswordGenerator {
    @Override
    public String generatePassword() {
        return "abcd"; // 4글자
    }
}
