package com.skdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
public class Main {
    private CustomerRepository customerRepository;
    private TodoRepository todoRepository;

    public Main(CustomerRepository customerRepository, TodoRepository todoRepository) {
        this.customerRepository = customerRepository;
        this.todoRepository = todoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/health")
    public HealthCheck greet() {
        return new HealthCheck("SUCCESS", "API is working fine!!");
    }

    @GetMapping("/api/v1/customer")
    public List<Customer> listOfCustomers(){
        return this.customerRepository.findAll();
    }

    @PostMapping("/api/v1/customer")
    public void addCustomer(@RequestBody NewCustomer request) {
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);
    }

    @DeleteMapping("/api/v1/customer/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int id){
      customerRepository.deleteById(id);
    }

    @PutMapping("/api/v1/customer/{customerId}")
    public void updateCustomer(@PathVariable("customerId") int id, @RequestBody Customer customer) {
        Optional<Customer> uCustomer = customerRepository.findById(id);
        if(uCustomer.isPresent()) {
            Customer existingCustomer = uCustomer.get();
            existingCustomer.setAge(customer.getAge());
            customerRepository.save(existingCustomer);
        }else {
            throw new RuntimeException("Customer not found with id:" + id);
        }
    }

   // Todo Endpoints

    @GetMapping("/api/v1/todos")
    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }

    @PostMapping("/api/v1/todos")
    public void createTodo(@RequestBody Todo todo) {
        Todo cTodo = new Todo();
        cTodo.setText(todo.getText());
        cTodo.setDone(false);
        todoRepository.save(cTodo);
    }

    @DeleteMapping("/api/v1/todos/{todoId}")
    public void deleteTodo(@PathVariable("todoId") int id) {
        todoRepository.deleteById(id);
    }

    @PutMapping("/api/v1/todos/{todoId}")
    public void updateTodo(@PathVariable("todoId") int id, @RequestBody Todo todo) {
        Optional<Todo> uTodo = todoRepository.findById(id);
        if(uTodo.isPresent()) {
            Todo exTodo = uTodo.get();
            System.out.println(todo.toString());
            exTodo.setDone(todo.isDone());
            todoRepository.save(exTodo);
        }else {
            throw new RuntimeException("Todo not found!!");
        }
    }

    record HealthCheck(String STATUS_RESPONSE, String STATUS_MESSAGE){}
    record NewCustomer(String name, String email, int age) {}
    record UpdateCustomer(String name, String email, int age) {}
}
