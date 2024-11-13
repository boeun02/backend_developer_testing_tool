package com.port_api.pa_test.port.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PortCheckService {

    private static final Map<Integer, String> portNames = new HashMap<>();

    static {
        portNames.put(80, "HTTP");
        portNames.put(443, "HTTPS");
        portNames.put(21, "FTP");
        portNames.put(22, "SSH");
        portNames.put(25, "SMTP");
        portNames.put(110, "POP3");
        portNames.put(143, "IMAP");
        portNames.put(3306, "MySQL");
        portNames.put(8080, "HTTP Alternative");
        portNames.put(587, "SMTP (Mail Submission)");
        portNames.put(53, "Google DNS");
        portNames.put(3389, "RDP");
        portNames.put(27017, "MongoDB");
        portNames.put(1521, "Oracle DB");
        portNames.put(161, "SNMP");
        portNames.put(5900, "VNC");
        portNames.put(179, "BGP");
        portNames.put(25565, "Minecraft");
        portNames.put(27015, "Steam");
    }

    // 포트 상태를 확인하고 결과를 반환하는 메서드
    public String checkPortStatus(String ip, int port) {
        // IP와 포트 유효성 검사
        if (!isValidIp(ip)) {
            return "존재하지 않는 IP 주소입니다.";
        }

        if (!isValidPort(port)) {
            return "존재하지 않는 포트 번호입니다.";
        }

        // 실제 포트가 열려 있는지 체크하는 로직
        try {
            // IP 주소와 포트로 소켓 연결 시도
            Socket socket = new Socket();
            InetSocketAddress address = new InetSocketAddress(ip, port);

            // 2000ms (2초) 내에 포트에 연결 가능한지 확인
            socket.connect(address, 2000);
            socket.close();

            // 포트가 열려 있으면 해당 포트 이름과 함께 메시지 반환
            String portName = portNames.getOrDefault(port, "알 수 없는 포트");
            return "포트가 열려 있습니다. (" + portName + ")";

        } catch (IOException e) {
            // 예외가 발생하면 포트가 닫혀 있다고 반환
            return "포트가 닫혀 있습니다.";
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