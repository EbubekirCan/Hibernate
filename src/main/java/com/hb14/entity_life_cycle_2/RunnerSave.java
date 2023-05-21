package com.hb14.entity_life_cycle_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave {

    public static void main(String[] args) {

        Employee emp1 = new Employee();
        emp1.setName("Mustafa Bey");
        emp1.setSalary(25000.0);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Employee.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        System.out.println("------> session.save cagrildi");
        session.save(emp1);



        tx.commit();
        session.close();
        sf.close();


    }
}
