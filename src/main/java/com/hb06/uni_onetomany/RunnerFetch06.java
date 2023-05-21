package com.hb06.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch06 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session =  sf.openSession();
        Transaction tx = session.beginTransaction();

        // !!! get
//        Student06 student = session.get(Student06.class,1001);
//        System.out.println(student);

        // !!! HQL ile id si 101 olan kitabı getirelim
//        String hqlQuery = "FROM Book06 b where b.id =101";
//        Book06 book1 =  session.createQuery(hqlQuery, Book06.class).uniqueResult();
//        System.out.println(book1);

        // !!! HQL , bir ogrencinin kitaplarini ogrencinin id sine gore getirelim (1001)
        String hqlQuery2 = "SELECT b.id, b.name FROM Student06 s INNER JOIN s.bookList b WHERE s.id=1001";
        List<Object[]> resultList1 =  session.createQuery(hqlQuery2).getResultList();
        resultList1.forEach(oa->System.out.println(Arrays.toString(oa)));

        // !!! aynisini get metodu ile yazalim
        Student06 student2 = session.get(Student06.class,1001);
        System.out.println(student2.getBookList());


        tx.commit();
        session.close();
        sf.close();
    }
}
