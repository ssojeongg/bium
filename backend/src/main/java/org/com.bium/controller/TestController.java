package org.com.bium.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class TestController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/test")
    public String test() {
        return "Spring + Maven + MyBatis 세팅 완료! 🎉";
    }

    @GetMapping("/db-test")
    public String dbTest() {
        try (Connection conn = dataSource.getConnection()) {
            return "✅ DB 연결 성공! 현재 DB: " + conn.getCatalog();
        } catch (Exception e) {
            return "❌ DB 연결 실패: " + e.getMessage();
        }
    }
}