package pl.sda.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.hibernate.model.HibernateUtil;
import pl.sda.hibernate.model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main_dodajStudenta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Podaj imie:");
        String imie = scanner.nextLine();

        System.out.println("Podaj nazwisko:");
        String nazwisko = scanner.nextLine();

        System.out.println("Podaj rok rozpoczecia studiow:");
        int rokRozpoczecia = Integer.parseInt(scanner.nextLine());

        Student student = Student.builder()
                .imie(imie)
                .nazwisko(nazwisko)
                .rokRozpoczeciaStudiow(rokRozpoczecia)

                .build();
        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();


            session.persist(student);

            transaction.commit();
        } catch (Exception e) {
            System.err.println("Błąd dodawania studenta do bazy: ");
        }
    }
}