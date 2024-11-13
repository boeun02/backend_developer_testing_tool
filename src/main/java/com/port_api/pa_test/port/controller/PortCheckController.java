package com.port_api.pa_test.port.controller;

import com.port_api.pa_test.port.service.PortCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")  // 프론트엔드 URL을 명시
public class PortCheckController {

    private final PortCheckService portCheckService;

    @Autowired
    public PortCheckController(PortCheckService portCheckService) {
        this.portCheckService = portCheckService;
    }

    @GetMapping("/checkPort")
    public String checkPort(@RequestParam String ip, @RequestParam int port) {
        try {
            boolean isPortOpen = portCheckService.isPortOpen(ip, port);
            return isPortOpen ? "포트가 열려 있습니다." : "포트가 닫혀 있습니다.";
        } catch (IllegalArgumentException e) {
            return "존재하지 않는 IP/포트 번호입니다.";
        } catch (Exception e) {
            return "포트를 확인할 수 없습니다.";
        }
    }
}
