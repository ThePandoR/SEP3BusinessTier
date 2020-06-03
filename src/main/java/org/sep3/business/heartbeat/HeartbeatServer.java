package org.sep3.business.heartbeat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Scope("singleton")
@Slf4j
public class HeartbeatServer {

    private DatagramSocket socket;

    private boolean running;

    public HeartbeatServer(@Value("${sep3heartbeatPort}") int port) throws SocketException {
        socket = new DatagramSocket(port);
        socket.setReuseAddress(true);

        log.info("Started heartbeat server on port " + port);

    }

    @Async
    public void run() {
        log.info("Listening for requests...");

        try {
            running = true;

            byte[] buffer = new byte[1];

            while(running) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                log.info(String.format("Received heartbeat request from %s [%d]", packet.getAddress(), packet.getData()[0]));

                packet = new DatagramPacket(buffer, buffer.length,
                        packet.getAddress(), packet.getPort());
                socket.send(packet);
            }
        } catch(IOException e) {
            log.info("Shutting down HeartbeatServer");
        } finally {
            if(!socket.isClosed())
                socket.close();
        }
    }

    @PreDestroy
    public void close() {
        log.info("Closing heartbeat server");
        running = false;
        socket.close();
    }

}

