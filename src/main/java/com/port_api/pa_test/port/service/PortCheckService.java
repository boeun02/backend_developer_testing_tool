package com.port_api.pa_test.port.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.stereotype.Service;

@Service
public class PortCheckService {

    // 포트가 열려 있는지 확인하는 메서드
    public boolean isPortOpen(String ip, int port) {
        // IP와 포트 유효성 검사
        if (!isValidIp(ip)) {
            throw new IllegalArgumentException("Invalid IP address");
        }

        if (!isValidPort(port)) {
            throw new IllegalArgumentException("Invalid port number");
        }

        // 실제 포트가 열려 있는지 체크하는 로직을 구현
        try {
            InetAddress address = InetAddress.getByName(ip);
            return address.isReachable(2000); // 2초 안에 접속 가능한지 확인
        } catch (Exception e) {
            return false;
        }
    }

    // IP 주소가 유효한지 확인하는 메서드
    public boolean isValidIp(String ip) {
        try {
            InetAddress address = InetAddress.getByName(ip);
            return address != null;
        } catch (UnknownHostException e) {
            return false;
        }
    }

    // 포트가 유효한지 확인하는 메서드
    public boolean isValidPort(int port) {
        return port > 0 && port <= 65535;
    }
}
