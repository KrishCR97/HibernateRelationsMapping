package com.cr7.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cr7.hibernate.entity.Course;
import com.cr7.hibernate.entity.Instructor;
import com.cr7.hibernate.entity.InstructorDetail;

public class DeleteCourseDemo {
	public static void main(String... args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int id = 10;

			// associate the objects
			// start a transaction
			session.beginTransaction();
			Course course = session.get(Course.class, id);
			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			
			// commit transaction
			session.delete(course);
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}

	}

}
