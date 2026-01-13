package com.api.ast.authservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
        "jwt.secret=YS12ZXJ5LWxvbmctYW5kLXNlY3VyZS1zZWNyZXQta2V5LWZvci10ZXN0aW5nCg==",
        "jwt.access-token-validity-in-seconds=86400",
        "jwt.refresh-token-validity-in-seconds=86400"
})
class AuthServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
