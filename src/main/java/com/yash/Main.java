package com.yash;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Student s1=new Student();
        s1.setId(1);
        s1.setName("S1");
        s1.setTech("JAVA");

        Configuration config = new Configuration();
        config.addAnnotatedClass(com.yash.Student.class);
        config.configure("hibernate.cfg.xml");

        SessionFactory factory=config.buildSessionFactory();

        Session session=factory.openSession();

        Transaction tx=session.beginTransaction();

        session.persist(s1);

        tx.commit();

    }
}
