package org.example;

public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator) {
        // as-is 강결합 내부에서 선언하지 않으면 결합을 느슨하게 만들 수 있다.
        //RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        //String randomPassword = randomPasswordGenerator.generatePassword();

        // to-be 결합을 끊기 위해 interface를 선언하여 주입한다.
        String randomPassword = passwordGenerator.generatePassword();

        /**
         * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
         */
        if (randomPassword.length() >= 8 && randomPassword.length() <= 12) {
            this.password = randomPassword;
        }

    }

    public String getPassword() {
        return password;
    }
}
