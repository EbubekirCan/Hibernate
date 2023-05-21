package com.hb14.entity_life_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {

    public static void main(String[] args) {

        Student14 student1 = new Student14(); // !!! Transient
        student1.setName("Kasim");
        student1.setMathGrade(55);

        Student14 student2 = new Student14(); // !!! Transient
        student2.setName("Gulsen");
        student2.setMathGrade(65);

        Configuration con = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student14.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1); // !!! persistent state

        student1.setName("hakki");

        session.evict(student1); // detached state

        student1.setName("hakki"); // bu asamada obje lif-cycle olarak hala detach asamasinda oldugu icin isim degisikligi gerceklesmez

        session.update(student1); // persistent scope
        session.merge(student1); // persistent scope


        tx.commit();
        session.close();
        sf.close();
    }
}
