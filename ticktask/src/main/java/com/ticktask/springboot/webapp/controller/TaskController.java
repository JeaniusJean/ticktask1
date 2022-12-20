package com.ticktask.springboot.webapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ticktask.springboot.webapp.entity.Task;
import com.ticktask.springboot.webapp.repositories.TaskRepository;
import com.ticktask.springboot.webapp.service.TaskService;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TaskController {
	
	public TaskController(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}
	
	private TaskRepository taskRepository;
	
	@GetMapping("task-list")
	public String listAllTasks(ModelMap model) {
		String username =getLoggedinUsername(model);
		List<Task> tasks = taskRepository.findByUsername(username);
		model.addAttribute("tasks", tasks);
		
		return "taskList";
	}
	
	@GetMapping("add-task")
	public String showNewTaskPage(ModelMap model) {
		String username =getLoggedinUsername(model);
		Task task = new Task(1, username, "", "", LocalDate.now().plusMonths(4), false);
		model.put("task", task);
		return "task";
	}
	
	@PostMapping("adding-task")
	public String addNewTask(ModelMap model,@Valid Task task, BindingResult result) {
	
//	if(result.hasErrors()) {
//		return "task";
//	}
	
	String username =getLoggedinUsername(model);
	task.setUsername(username);
	taskRepository.save(task);
	
	return "redirect:task-list";
}
	
	
	@PostMapping("delete-task")
	public String deleteTask(@RequestParam int id) {
		taskRepository.deleteById(id);
	
		return "redirect:task-list";
	}
	
	@GetMapping("edit-task")
	public String showUpdateTaskPage(@RequestParam int id, ModelMap model) {
		Task task = taskRepository.findById(id).get();
		model.addAttribute("task", task);
		return "task";
	}
	
	@PostMapping("editing-task")
	public String updateTask(ModelMap model,@Valid Task task, BindingResult result) {
		if(result.hasErrors()) {
			return "task";
		}
		String username =getLoggedinUsername(model);
		task.setUsername(username);
		taskRepository.save(task);
		return "redirect:task-list";
	}
	
	
	private String getLoggedinUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	
	}

}

