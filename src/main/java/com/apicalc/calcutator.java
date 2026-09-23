package com.apicalc;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@WebService(serviceName = "CalculatorService")
public class calcutator {

    private final Map<String, String> store = new ConcurrentHashMap<>();

    @WebMethod(operationName = "createCmd")
    public String createCmd(@WebParam(name = "operation") String operation,
                             @WebParam(name = "a") double a,
                             @WebParam(name = "b") double b) {
        double result = switch (operation) {
            case "add" -> a + b;
            case "sub" -> a - b;
            case "mul" -> a * b;
            case "div" -> a / b;
            default -> throw new IllegalArgumentException("Unknown operation: " + operation);
        };
        String id = UUID.randomUUID().toString();
        store.put(id, operation + "(" + a + "," + b + ") = " + result);
        return id;
    }

    @WebMethod(operationName = "getCmd")
    public String getCmd(@WebParam(name = "id") String id) {
        return store.getOrDefault(id, "NOT_FOUND");
    }

    @WebMethod(operationName = "cancelCmd")
    public boolean cancelCmd(@WebParam(name = "id") String id) {
        return store.remove(id) != null;
    }
    @WebMethod(operationName = "createOrder")
    public String createOrder(@WebParam(name = "order") Order order) {
        if (order == null || order.getIdClient() == null) {
            throw new IllegalArgumentException("order and idClient are required");
        }
        String id = UUID.randomUUID().toString();
        store.put(id, "Order[client=" + order.getIdClient()
                + ", montant=" + order.getMontant()
                + ", adresse=" + order.getAdresse() + "]");
        return id;
    }
}