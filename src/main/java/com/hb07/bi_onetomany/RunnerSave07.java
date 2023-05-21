package com.hb07.bi_onetomany;

import com.hb06.uni_onetomany.Book06;
import com.hb06.uni_onetomany.Student06;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave07 {

    public static void main(String[] args) {

        Student07 student1 = new Student07();
        student1.setId(1001);
        student1.setName("Fatih Bey");
        student1.setGrade(65);

        Student07 student2 = new Student07();
        student2.setId(1002);
        student2.setName("Cemil Bey");
        student2.setGrade(68);

        Student07 student3 = new Student07();
        student3.setId(1003);
        student3.setName("Ahmet Bey");
        student3.setGrade(55);

        Book07 book1 = new Book07();
        book1.setId(101);
        book1.setName("Math Book");

        Book07 book2 = new Book07();
        book2.setId(102);
        book2.setName("Java Book");

        Book07 book3 = new Book07();
        book3.setId(103);
        book3.setName("Art Book");

        Book07 book4= new Book07();
        book4.setId(104);
        book4.setName("A Book");

        Book07 book5= new Book07();
        book5.setId(105);
        book5.setName("B Book");

        book1.setStudent(student1);
        book2.setStudent(student1);
        book3.setStudent(student2);
        book4.setStudent(student2);
        book5.setStudent(student2);

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session =  sf.openSession();
        Transaction tx = session.beginTransaction();

        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(book1);
        session.save(book2);
        session.save(book3);
        session.save(book4);
        session.save(book5);




        tx.commit();
        session.close();
        sf.close();
    }
}
