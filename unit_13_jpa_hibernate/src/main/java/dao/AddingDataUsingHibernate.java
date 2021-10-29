package dao;

import entity.*;
import org.hibernate.Session;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddingDataUsingHibernate {

    public void initialization(Session session) {
        Calendar calendar = new GregorianCalendar();

        Course course = new Course();
        course.setName("programming");
        session.persist(course);

        Group group = new Group();
        group.setGroupCode("L-11A");
        course.addGroup(group);
        session.persist(course);
        session.persist(group);

        Student student = new Student();
        student.setName("Student 1");
        student.setGroup(group);
        session.persist(student);

        Teacher teacher = new Teacher();
        teacher.setName("Teacher 1");
        session.persist(teacher);

        Theme theme = new Theme();
        theme.setName("Theme 1");
        session.persist(theme);

        Lesson lesson = new Lesson();
        lesson.setGroup(group);
        lesson.setTeacher(teacher);
        lesson.setTheme(theme);
        calendar = new GregorianCalendar(2021, Calendar.OCTOBER, 6, 12, 35);
        lesson.setDateTime(calendar.getTime());
        session.persist(lesson);

        Lesson lesson1 = new Lesson();
        lesson1.setGroup(group);
        lesson1.setTeacher(teacher);
        lesson1.setTheme(theme);
        calendar = new GregorianCalendar(2021, Calendar.OCTOBER, 10, 10, 25);
        lesson1.setDateTime(calendar.getTime());
        session.persist(lesson1);


        Grade grade = new Grade();
        grade.setStudent(student);
        grade.setLesson(lesson1);
        grade.setGrade((byte)9);
        session.persist(grade);


    }
}
