package com.cg.controller;


import com.cg.model.Customer;
import com.cg.service.CustomerService;
import com.cg.service.HibernateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

//    @Autowired
//    private HibernateCustomerService hibernateCustomerService;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ModelAndView showCustomerListPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/list");

//        List<Customer> customerList = hibernateCustomerService.findAll();

        List<Customer> customerList = customerService.findAll();

        modelAndView.addObject("customers", customerList);

        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showCustomerByIdPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/info");

//        Customer customer = hibernateCustomerService.findById(id);

        Optional<Customer> customer = customerService.findById(id);

        if (!customer.isPresent()) {
            modelAndView.setViewName("customer/error");
            return modelAndView;
        }

        modelAndView.addObject("customer", customer.get());

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/create");

        Customer customer = new Customer();
        modelAndView.addObject("customer", customer);

        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView showSearchResultPage(@RequestParam String search) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer/list");

        search = "%" + search + "%";

//        List<Customer> customerList = customerService.findByFullNameLike(search);

//        List<Customer> customerList = customerService.findByFullNameLikeOrEmailLikeOrPhoneLikeOrAddressLike(search, search, search, search);

        List<Customer> customerList = customerService.findAllBySearchKey(search);

        modelAndView.addObject("customers", customerList);


        return modelAndView;
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute Customer customer) {
//        hibernateCustomerService.save(customer);

        customer.setId(0L);
        customerService.save(customer);
        return "redirect:/customers";
    }


    @PostMapping("/update")
    public String doUpdate(@ModelAttribute Customer customer) {
//        hibernateCustomerService.save(customer);

        customerService.save(customer);

        return "redirect:/customers";
    }


}
