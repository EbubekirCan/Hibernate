package com.hb10.idgeneration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave10 {
    public static void main(String[] args) {

        Student10 student1 = new Student10();
        student1.setName("Ahmet");
        student1.setGrade(90);

        Student10 student2 = new Student10();
        student2.setName("Mehmet");
        student2.setGrade(90);

        Student10 student3 = new Student10();
        student3.setName("Mehmet");
        student3.setGrade(90);

        Student10 student4 = new Student10();
        student4.setName("Mehmet");
        student4.setGrade(90);

        Student10 student5 = new Student10();
        student5.setName("Mehmet");
        student5.setGrade(90);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student10.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

//        session.save(student1);
//        session.save(student2);
//        session.save(student3);
//        session.save(student4);
//        session.save(student5);

        tx.commit();
        session.close();
        sf.close();

    }
}
