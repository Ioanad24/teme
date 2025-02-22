package com.example;

import com.example.entity.Masina;
import com.example.repo.MasinaSpringDataJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
import java.util.Scanner;
@SpringBootApplication
public class TemaLabSpringDataJpaApplication implements CommandLineRunner {
    @Autowired
    MasinaSpringDataJpaRepository repository;
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    public static void main(String[] args) {
        SpringApplication.run(TemaLabSpringDataJpaApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Lista Masinilor din tabel ---");
        repository.findAll().forEach(System.out::println);
        System.out.println("\n--- Inserarea unei masini ---");
        System.out.println("Persoana: " +
                repository.save(new Masina(
                        "CS23CSF",
                        "Peugeot",
                        2003,
                        "albastru",
                        190000)) + " a fost inserata");
        System.out.println("\n--- Stergere dupa nr de inmatriculare ---");
        System.out.print("nr_inmatriculare: ");
        String nr_inmatriculare = scanner.nextLine();
        repository.deleteByNrInmatriculare(nr_inmatriculare);
        System.out.println("\n--- Cautare dupa nr de inmatriculare ---");
        System.out.print("nr_inmatriculare: ");
        nr_inmatriculare = scanner.nextLine();
        System.out.println(repository.findByNrInmatriculare(nr_inmatriculare));
        System.out.println("\n--- Nr masini cu o anumita marca ---");
        System.out.print("marca: ");
        String marca = scanner.nextLine();
        System.out.println("Nr masini cu marca " + marca + ": " + repository.countByMarca(marca));
        System.out.println("\n--- Nr masini care au sub 100000km ---");
        System.out.println("nr masini: " + repository.countByNrKilometriiLessThan(100000));
        System.out.println("\n--- Masini mai noi de 5 ani ---");
        repository.findByAnFabricatieGreaterThan(LocalDate.now().getYear()-5).forEach(System.out::println);
        logger.info("--- Lista masinilor dupa modificari ---\n {}", repository.findAll());
    }
}