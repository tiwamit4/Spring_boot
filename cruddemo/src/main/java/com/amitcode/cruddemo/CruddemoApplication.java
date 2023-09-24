package com.amitcode.cruddemo;

import com.amitcode.cruddemo.dao.StudentDAO;
import com.amitcode.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{

			//createStudent(studentDAO);

			createMultipleStudent(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents (studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted Rows count "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id : "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based on primary key
		int studentId=1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to scooby
		System.out.println("Updating student...");
		myStudent.setFirstName("AMit");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated Student: "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents=studentDAO.findByLastName("Tiwari");

		//display list of students
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents=studentDAO.findAll();


		//display list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("Creating a new student object");
		Student tempStudent = new Student("Daffy","duck","daffy.com");

		//save the student
		System.out.println("saving the student ....");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId= tempStudent.getId();
		System.out.println("saved student. Generated id :"+theId);

		//retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: "+theId);
		Student myStudent=studentDAO.findById(theId);

		//display student
		System.out.println("Found the student : "+myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		//create multiple student
		System.out.println("Creating 3 new student Object");
		Student tempStudent1 = new Student("Amit","Tiwari","tiwamit4@gmail.com");
		Student tempStudent2 = new Student("Amit","Baba","tiwaryamit00040@gmail.com");
		Student tempStudent3 = new Student("Amit","Ranjan","tiwaryamit035@outlook.com");


		//save the student object
		System.out.println("Saving the student....... ");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);



		//
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating a new student Object");
		Student tempStudent = new Student("Amit","Tiwary","tiwamit4@gmail.com");


		//save the student object
		System.out.println("saving the student ... ");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved Student, Generated id : "+tempStudent.getId());
	}
}
