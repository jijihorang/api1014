package org.example.api1014.member.domain;

// db에 string 값이 직접 들어감
public enum MemberRole {

    USER("USER"), ADMIN("ADMIN");

    String role;

    MemberRole(String role) {
        this.role = role;
    }

}
