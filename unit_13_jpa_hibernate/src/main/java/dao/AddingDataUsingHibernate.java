package dao;

import entity.*;
import org.hibernate.Session;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddingDataUsingHibernate {

    public void initialization(Session session) {
        Course course = new Course();
        course.setName("English");
        session.persist(course);

        Group group = new Group();
        group.setGroupCode("[L-11A]");
        course.addGroup(group);
        session.persist(course);
        session.persist(group);

        Teacher teacher = new Teacher();
        teacher.setName("Teacher 1");
        session.persist(teacher);

        Student student = new Student();
        student.setName("Student 1");
        student.setGroup(group);
        session.persist(student);
        student.setId(1);

        Theme theme = new Theme();
        theme.setName("Theme 1");
        session.persist(theme);

        Lesson lesson = new Lesson();
        lesson.setGroup(group);
        lesson.setTeacher(teacher);
        lesson.setTheme(theme);
        Calendar calendar = new GregorianCalendar(2021, Calendar.OCTOBER, 6, 12, 35);
        lesson.setDateTime(calendar.getTime());
        session.persist(lesson);

        Lesson lesson1 = new Lesson();
        lesson1.setGroup(group);
        lesson.setTeacher(teacher);
        lesson1.setTheme(theme);
        calendar = new GregorianCalendar(2021, Calendar.OCTOBER, 13, 12, 35);
        lesson1.setDateTime(calendar.getTime());
        session.persist(lesson1);

        Grade grade = new Grade();
        grade.setGrade((byte) 10);
        grade.setLesson(lesson);
        grade.setStudent(student);
        session.persist(grade);


    }
}
