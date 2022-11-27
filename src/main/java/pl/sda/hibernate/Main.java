package main.java.pl.sda.hibernate;

import pl.sda.hibernate.model.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.INSTANCE.getSessionFactory().openSession();

    }
}
