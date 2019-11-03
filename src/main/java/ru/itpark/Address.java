package ru.itpark;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Address {
    public static void main(String[] args) throws UnknownHostException {

        final InetAddress address = InetAddress.getByName("ya.ru");
        System.out.println(address.getHostAddress());
    }
}
