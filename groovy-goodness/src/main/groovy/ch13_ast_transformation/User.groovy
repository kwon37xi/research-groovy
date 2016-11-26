package ch13_ast_transformation

import groovy.transform.PackageScope

// groovy는 Java 의 package private 스코프를 모두 public 혹은 property로 변환해버린다.
// 따라서 진짜로 package private이 필요할 때는 @PackageScope를 사용해야한다.
// class field, method 에서 사용할 수 있다.

class User {
    private String username
    User(final String username) {
        this.username = username
    }

    @PackageScope
    void changeUsername(final String newUsername) {
        this.username = username
    }

    String getUsername() {
        username
    }
}
