package pl.sda.hibernate.model;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class Main_selectById {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj id studenta");
        String idStudenta = scanner.nextLine();
        Long id = Long.parseLong(idStudenta);

        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Student szukanyStudent = session.get(Student.class, id);
            if (szukanyStudent != null) {
               //to zapytaj o wartosc oceny
                System.out.println("Podaj ocenę:");
                String dodawanaOcena = scanner.nextLine();
                double wartoscOceny = Double.parseDouble(dodawanaOcena);
           //stworz obiekt oceny i przypisz do oceny studenta
                Ocena nowaOcena = Ocena.builder()
                   .uczen(szukanyStudent)
                   .wartosc(wartoscOceny)
                   .build();
           //zapisz ocene
           session.persist(nowaOcena);
            } else {
                System.err.println("Taki student nieistnieje");
            }


            transaction.commit();
        } catch (Exception e) {
            System.err.println("Błąd ");
        }
    }
}