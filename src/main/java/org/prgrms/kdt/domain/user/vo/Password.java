package org.prgrms.kdt.domain.user.vo;

import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public class Password {
    private final String password;
    private static final Pattern passwordPattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[\\W]).{8,64})");

    public Password(String password) {
        validatePassword(password);
        this.password = password;
    }

    private void validatePassword(String password) {
        if(!passwordPattern.matcher(password).matches()){
            throw new IllegalArgumentException("비밀번호는 8자 이상, 특수문자가 최소 1개 이상은 포함되야 합니다.");
        }
    }
}
