package com.hb09.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        Student09 student = session.get(Student09.class,1002);
//        System.out.println(student.getBookList());

//         Book09 book1 = session.get(Book09.class, 101);
//        for (Book09 book: student.getBookList()) { // lAZY
//            System.out.println(book);
//        }


        tx.commit();

        session.close();

        for (Book09 book: student.getBookList()) { // lAZY
            System.out.println(book);
        }

        sf.close();

    }
}














