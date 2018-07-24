package com.cr7.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cr7.hibernate.entity.Course;
import com.cr7.hibernate.entity.Instructor;
import com.cr7.hibernate.entity.InstructorDetail;

public class GetInstructorCourseDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int id = 1;
			Course tempCourse1 = new Course("CBSE");
			Course tempCourse2 = new Course("ICSE");

			// associate the objects
			// start a transaction
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, id);
			instructor.add(tempCourse1);
			instructor.add(tempCourse2);
            // save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			session.save(tempCourse1);
			session.save(tempCourse2);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
