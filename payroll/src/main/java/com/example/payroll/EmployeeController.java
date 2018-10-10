package com.example.payroll;

import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
public class EmployeeController {
    private final EmployeeRepository repository;

    EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    /**
     * 增加
     *
     * @param employee
     * @return
     */
    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee employee) {
        return repository.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable long id) {
        repository.deleteById(id);
    }

    /**
     * 修改，不存在则保存
     * @param newEmployee
     * @param id
     * @return
     */
    @PutMapping("/employees/{id}")
    Employee remplateEmployee(@RequestBody Employee newEmployee, @PathVariable long id) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("/employees")
    public List<Employee> all() {
        return repository.findAll();
    }

    /**
     * 查询单个
     *
     * @param id
     * @return
     */
    @GetMapping("/employees/{id}")
    Resource<Employee> one(@PathVariable Long id) {
         Employee employee =  repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
         return new Resource<>(employee,
                 linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
                 linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
    }
}
