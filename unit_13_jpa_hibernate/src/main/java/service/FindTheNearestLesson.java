package service;

import entity.Lesson;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;

public class FindTheNearestLesson {

    public void findTheNearestLessonByStudentId(Integer studentID) {
        Configuration configuration = new Configuration().configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            try {
                session.beginTransaction();
                Query query = session.createQuery("select l from Lesson l join Group g on l.group.id=g.id join Student s on s.group.id = g.id where s.id = :studentId" + " order by l.dateTime");
                query.setParameter("studentId", studentID);
                query.setMaxResults(1);
                session.getTransaction().commit();
                Lesson theNearestLesson = (Lesson) query.getSingleResult();
                Student student = session.find(Student.class, studentID);
                System.out.println("\nNecessary information about the nearest lesson of student \"" + student.getName() + "\":\n" +
                        "Date and time: " + theNearestLesson.getDateTime() + "\n" +
                        "Teacher: " + theNearestLesson.getTeacher().getName() + "\n" +
                        "Theme: " + theNearestLesson.getTheme().getName() + "\n");

            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RuntimeException(e);
            }
        }
    }
}
