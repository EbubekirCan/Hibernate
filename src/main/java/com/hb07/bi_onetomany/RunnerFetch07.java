package com.hb07.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch07 {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session =  sf.openSession();
        Transaction tx = session.beginTransaction();

        // !!! get
//        Student07 student = session.get(Student07.class,1001);
//        System.out.println(student);

        // !!! SQL ile öğrenci bilgilerini ( Inner Join )  alalım ( öğrenci ismi ve kitap ismi )
//        String sqlQuery =
//                "SELECT s.student_name,b.name FROM student07 s INNER JOIN book07 b ON s.id=b.student_id";
//        List<Object[]> resulList1 = session.createSQLQuery(sqlQuery).getResultList();
//        for (Object[] object : resulList1) {
//            System.out.println(Arrays.toString(object));
//        }

        // !!! yukardaki sorguyu HQL ile yazalım
//        String hqlQuery =
//                "SELECT s.name,b.name FROM Student07 s INNER JOIN FETCH Book07 b ON s.id=b.student.id";
//        List<Object[]> resultList2 = session.createQuery(hqlQuery).getResultList();
//        resultList2.forEach(oa -> System.out.println(Arrays.toString(oa)));

        // !!! Delete islemi SQL
//        String sqlQuery1 = "DELETE FROM book07";
//        int numOfDeletedRecords = session.createSQLQuery(sqlQuery1).executeUpdate();
//        System.out.println("Silinen kayit sayisi : " + numOfDeletedRecords);

//        String sqlQuery2 = "DELETE FROM student07";
//        int numOfDeletedRecords2 = session.createSQLQuery(sqlQuery2).executeUpdate();
//        System.out.println("Silinen kayit sayisi : " + numOfDeletedRecords2);

        // !!! Delete HQL
//        String hqlQuery2 = "DELETE FROM Book07";
//        int numOfDeletedRecords3 = session.createQuery(hqlQuery2).executeUpdate();
//        System.out.println("Silinen kayit sayisi : " + numOfDeletedRecords3);

//        String hqlQuery3 = "DELETE FROM Student07";
//        int numOfDeletedRecords4 = session.createQuery(hqlQuery3).executeUpdate();
//        System.out.println("Silinen kayit sayisi : " + numOfDeletedRecords4);

        //!!! Kitap ismi A Book olan kitabi HQL ile siliniz
//        String hqlQuery4 = "DELETE FROM Book07 b WHERE b.name='A Book'";
//        int numOfDeletedRecords5 = session.createQuery(hqlQuery4).executeUpdate();
//        System.out.println("Silinen kayit sayisi : " + numOfDeletedRecords5);

        // !!! Kitab bilgisi olan bir ogrenciyi silmek istersek
            // 1.yol ) once Book tablosunda iliskili oldugu booklar silinir daha sonra istenen student objesi silinebilir
            // 2.yol ) Student classina Cascade / orphanRemoval

        // !!! 1001 id li student objemi delete metodu ile silelim
//        Student07 student2 = session.get(Student07.class, 1001);
//        session.delete(student2);

         // student2.getBookList().set(0,null);  // 101 , 102 --> null , 102

        // !!! book ismi içinde "Book" geçen student kayıtlarını alalım ( HQL )
        String hqlQuery4 = "SELECT s FROM Student07 s JOIN s.bookList b WHERE b.name LIKE '%Book%'";
        List<Student07> resultList4 = session.createQuery(hqlQuery4, Student07.class).getResultList();
        for (Student07 student07: resultList4) {
            System.out.println(student07);
        }

        tx.commit();
        session.close();
        sf.close();
    }
}
