package com.apicalc;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "idClient", "montant", "adresse" })
public class Order {

    private String idClient;
    private double montant;
    private String adresse;

    // JAXB requires a no-arg constructor
    public Order() {
    }

    public Order(String idClient, double montant, String adresse) {
        this.idClient = idClient;
        this.montant = montant;
        this.adresse = adresse;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}