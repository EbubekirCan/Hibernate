package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch04 {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student04.class).addAnnotatedClass(Diary04.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction tx = session.beginTransaction();
        // belli id li student getirelim
        Student04 student = session.get(Student04.class, 1001);

        // diary getirelim
        Diary04 diary = session.get(Diary04.class, 101);
        System.out.println(student);
        System.out.println("****************");
        System.out.println(diary);
        System.out.println("*******************");
        System.out.println("Diary uzerinden student objesine ulasalim : " + diary.getStudent());
        System.out.println("************************");
        System.out.println("Student uzerinden diary objesine ulasalim : "+ student.getDiary());

        // !!! Task : Kesisim kumesini bana getirin ( INNER JOIN )
//        String hqlQuery = "SELECT s.name , d.name FROM Student04 s INNER JOIN FETCH Diary04 d on s.id=d.student" ;
//        List<Object[]> resultList =  session.createQuery(hqlQuery).getResultList();
////        for (Object[] object: resultList) {
////            System.out.println(Arrays.toString(object));
////        }
//
//        // lambda expression ile yazalim
//        resultList.forEach(oa ->{
//            System.out.println(Arrays.toString(oa));
//        });

        // !!! task 2 : HQL LEFT JOIN *****************
        String hqlQuery2 = "SELECT s.name , d.name FROM Student04 s LEFT JOIN FETCH Diary04 d on s.id=d.student";
        List<Object[]> resultList2 =  session.createQuery(hqlQuery2).getResultList();
        resultList2.forEach(oa ->{
            System.out.println(Arrays.toString(oa));
        });

        // !!! HQL Right Join ***************************
        // Task 3 : Butun gunlukler ve varsa gunlugu olan ogrenciler gelsin
        String hqlQuery3 = "SELECT s.name, d.name FROM Student04 s RIGHT JOIN FETCH Diary04 d on s.id = d.student";
        List<Object[]> resultList3 =  session.createQuery(hqlQuery3).getResultList();
        resultList3.forEach( oa -> {
            System.out.println(Arrays.toString(oa));
        });

        // !!! HQL Full Join **************************
         // Kisaca : butun student ve diary bilgilerini getirelim
        String hqlQuery4 = "SELECT s.name, d.name FROM Student04 s FULL JOIN FETCH Diary04 d on s.id=d.student.id";
        List<Object[]> resultList4 = session.createQuery(hqlQuery4).getResultList();
        resultList4.forEach( oa -> {
            System.out.println(Arrays.toString(oa));
        });




        tx.commit();
        session.close();
        sf.close();
    }
}
