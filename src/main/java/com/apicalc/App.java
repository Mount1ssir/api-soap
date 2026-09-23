package com.apicalc;

import jakarta.xml.ws.Endpoint;

public class App {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/calculator", new calcutator());
        System.out.println("WSDL available at: http://localhost:8080/calculator?wsdl");
    }
}