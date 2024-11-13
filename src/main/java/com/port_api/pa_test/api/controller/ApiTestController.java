package com.port_api.pa_test.api.controller;

import com.port_api.pa_test.api.exception.InvalidRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")  // 프론트엔드 URL을 명시적으로 지정
@RestController
@RequestMapping("/api")
public class ApiTestController {

    // GET 요청 처리
    @GetMapping("/test")
    public ResponseEntity<String> getTest() {
        String response = "200 OK GET 요청이 성공적으로 처리되었습니다.";
        return ResponseEntity.ok(response);
    }

    // POST 요청 처리
    @PostMapping("/test")
    public ResponseEntity<String> postTest(@RequestBody(required = false) String requestBody) {
        if (requestBody == null || requestBody.isEmpty()) {
            throw new InvalidRequestException("POST 요청 실패: 요청 본문이 비어 있습니다.");
        }
        String response = "200 OK POST 요청이 성공적으로 처리되었습니다. 요청 본문: " + requestBody;
        return ResponseEntity.ok(response);
    }

    // PUT 요청 처리
    @PutMapping("/test")
    public ResponseEntity<String> putTest(@RequestBody String requestBody) {
        if (requestBody == null || requestBody.isEmpty()) {
            throw new InvalidRequestException("PUT 요청 실패: 요청 본문이 비어 있습니다.");
        }
        String response = "200 OK PUT 요청이 성공적으로 처리되었습니다. 요청 본문: " + requestBody;
        return ResponseEntity.ok(response);
    }

    // DELETE 요청 처리
    @DeleteMapping("/test")
    public ResponseEntity<String> deleteTest() {
        String response = "200 OK DELETE 요청이 성공적으로 처리되었습니다.";
        return ResponseEntity.ok(response);
    }
}
