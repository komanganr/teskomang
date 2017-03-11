package com.example.service;

import java.util.ArrayList;
import java.util.List;
import com.example.model.Student;

public class InMemoryStudentService implements StudentService {
	private static List<Student> studentList = new ArrayList<Student>();

	@Override
	/*menerima NPM mahasiswa
	dan mengembalikan object Student dengan NPM tersebut*/
	public Student selectStudent(String npm) {
		for(int i = 0; i < studentList.size(); i++){
			if(studentList.get(i).getNpm().equals(npm)){
				return studentList.get(i);
			}
		}
		return null;
	}

	@Override
	public List<Student> selectAllStudents() {
		return studentList;
	}

	@Override
	public void addStudent(Student student) {
		studentList.add(student);
	}
}