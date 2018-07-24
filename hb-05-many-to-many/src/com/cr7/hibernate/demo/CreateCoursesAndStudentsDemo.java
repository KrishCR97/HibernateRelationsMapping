package com.cr7.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cr7.hibernate.entity.Course;
import com.cr7.hibernate.entity.Instructor;
import com.cr7.hibernate.entity.InstructorDetail;
import com.cr7.hibernate.entity.Review;
import com.cr7.hibernate.entity.Student;

public class CreateCoursesAndStudentsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int id = 1;

			// associate the objects
			// start a transaction
			session.beginTransaction();
			Course couse1 = new Course("Pacman");
			// save the instructor
			//
			session.save(couse1);
			Student s1 = new Student("Amar","reddy","reddy@gamil.com");
			Student s2 = new Student("Sus","Susa","sus@gamil.com");
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			couse1.addStudent(s1);
			couse1.addStudent(s2);
			//
			session.save(s1);
			session.save(s2);
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
