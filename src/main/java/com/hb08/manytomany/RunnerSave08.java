package com.hb08.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class RunnerSave08 {
    public static void main(String[] args) {
        Student08 student1 = new Student08();
        student1.setId(1001);
        student1.setName("Ahmet");
        student1.setGrade(50);

        Student08 student2 = new Student08();
        student2.setId(1002);
        student2.setName("Mehmet");
        student2.setGrade(50);

        Student08 student3 = new Student08();
        student3.setId(1003);
        student3.setName("Suna");
        student3.setGrade(50);

        Book08 book1 = new Book08();
        book1.setId(101);
        book1.setName("Art Book");

        Book08 book2 = new Book08();
        book2.setId(102);
        book2.setName("Math Book");

        List<Book08> bookList1 = new ArrayList<>();
        bookList1.add(book1);
        bookList1.add(book2);
        student1.setBookList(bookList1);

        List<Book08> bookList2 = new ArrayList<>();
        bookList2.add(book1);
        bookList2.add(book2);
        student2.setBookList(bookList2);

        List<Book08> bookList3 = new ArrayList<>();
        bookList3.add(book1);
        student3.setBookList(bookList3);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).addAnnotatedClass(Book08.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(book1);
        session.save(book2);


        tx.commit();

        session.close();
        sf.close();



    }
}
