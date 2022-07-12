package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Employee;
import Model.Post;
import Model.Student;
import Service.Emp_Services;
import Service.PostService;
import Service.Student_Service;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class Controller {
	
	@Autowired
	private Student_Service studentservice;
	
	@Autowired
	private PostService postservice;
	
	@Autowired
	private Emp_Services empservice;
	
	@PostMapping("save-employee")
	public boolean saveEmployee(@RequestBody Employee emp) {
		System.out.println(emp);
		boolean status = empservice.saveEmp(emp);
		System.out.println(status);
		return status;
	}
	
	@PostMapping("save-student")
	public boolean saveStudent(@RequestBody Student student) {
		boolean status = studentservice.saveStudent(student);
		System.out.println(status);
		return status;
	}
	
	@PostMapping("save-post")
	public boolean saveStudent(@RequestBody Post post) {
		 return postservice.savePost(post);
		
	}
	
	@GetMapping("students-list")
	public List<Student> allstudents() {
		 return studentservice.getStudents();
	}
	
	@GetMapping("posts-list")
	public List<Post> allPosts() {
		 return postservice.getPosts();
	}
	
	
	@DeleteMapping("delete-student/{student_id}")
	public boolean deleteStudent(@PathVariable("student_id") int student_id,Student student) {
		student.setStudent_id(student_id);
		return studentservice.deleteStudent(student);
	}
	
	@DeleteMapping("delete-post/{id}")
	public boolean deletePost(@PathVariable("id") int id,Post post) {
		post.setId(id);
		return postservice.deletePost(post);
	}

	@GetMapping("student/{student_id}")
	public List<Student> allstudentByID(@PathVariable("student_id") int student_id,Student student) {
		 student.setStudent_id(student_id);
		 return studentservice.getStudentByID(student);
		
	}
	
	@GetMapping("post/{id}")
	public List<Post> allpostByID(@PathVariable("id") int id,Post post) {
		 post.setId(id);
		 return postservice.getPostByID(post);
		
	}
	
	
	@PostMapping("update-student/{student_id}")
	public boolean updateStudent(@RequestBody Student student,@PathVariable("student_id") int student_id) {
		student.setStudent_id(student_id);
		return studentservice.updateStudent(student);
	}
	
	@PostMapping("update-post/{id}")
	public boolean updatePost(@RequestBody Post post,@PathVariable("id") int id) {
		post.setId(id);
		return postservice.updatePost(post);
	}
	
	
	
}
