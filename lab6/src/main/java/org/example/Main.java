package org.example;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Angajat mapper = new Angajat();
        try {
            mapper.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private record JavaTimeModule() {
    }
}
