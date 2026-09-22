package com.yash;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        // -------------------------------
        // Hibernate Configuration
        // -------------------------------

        Configuration config = new Configuration();

        config.addAnnotatedClass(Student.class);

        config.configure("hibernate.cfg.xml");

        SessionFactory factory = config.buildSessionFactory();


        // =====================================================
        // CREATE
        // =====================================================

        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Student s1 = new Student();

        s1.setId(3);
        s1.setName("Yash");
        s1.setTech("Java");

        session.persist(s1);

        tx.commit();

        session.close();

        System.out.println("Student created successfully");


        // =====================================================
        // FETCH ONE
        // =====================================================

        session = factory.openSession();

        Student student = session.find(Student.class, 3);

        System.out.println("Fetched Student:");
        System.out.println(student);

        session.close();


        // =====================================================
        // FETCH INDIVIDUAL VALUES
        // =====================================================

        session = factory.openSession();

        student = session.find(Student.class, 3);

        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Tech: " + student.getTech());

        session.close();


        // =====================================================
        // UPDATE
        // =====================================================

        session = factory.openSession();

        tx = session.beginTransaction();

        student = session.find(Student.class, 3);

        student.setName("Yash Raghuwanshi");
        student.setTech("Spring Boot");

        tx.commit();

        session.close();

        System.out.println("Student updated successfully");


        // =====================================================
        // FETCH AFTER UPDATE
        // =====================================================

        session = factory.openSession();

        student = session.find(Student.class, 3);

        System.out.println("After Update:");
        System.out.println(student);

        session.close();


        // =====================================================
        // DELETE
        // =====================================================

        session = factory.openSession();

        tx = session.beginTransaction();

        student = session.find(Student.class, 3);

        if (student != null) {
            session.remove(student);
        }

        tx.commit();

        session.close();

        System.out.println("Student deleted successfully");


        // =====================================================
        // CLOSE FACTORY
        // =====================================================

        factory.close();
    }
}