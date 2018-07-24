package com.cr7.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cr7.hibernate.entity.Course;
import com.cr7.hibernate.entity.Instructor;
import com.cr7.hibernate.entity.InstructorDetail;
import com.cr7.hibernate.entity.Review;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Review.class).addAnnotatedClass(Course.class).buildSessionFactory();

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
			couse1.addReview(new Review("Good game"));
			couse1.addReview(new Review("Wowing game"));
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			session.save(couse1);
			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			session.close();
			factory.close();
		}
	}

}
