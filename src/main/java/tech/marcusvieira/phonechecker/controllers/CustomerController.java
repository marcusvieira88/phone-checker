package tech.marcusvieira.phonechecker.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.marcusvieira.phonechecker.dtos.Customer;
import tech.marcusvieira.phonechecker.dtos.Filter;
import tech.marcusvieira.phonechecker.enums.Country;
import tech.marcusvieira.phonechecker.enums.PhoneStatus;
import tech.marcusvieira.phonechecker.services.CustomerService;
import tech.marcusvieira.phonechecker.utils.PaginationUtils;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/")
    public String getCustomers(Model model, Country country, PhoneStatus status, Integer page, Integer size) {

        int currentPage = Optional.ofNullable(page).orElse(1);
        int pageSize = Optional.ofNullable(size).orElse(5);

        Page<Customer> customersPage = customerService
            .getCustomers(country, status, PageRequest.of(currentPage - 1, pageSize));

        final List<Integer> pageNumbers = PaginationUtils.buildPageNumbers(customersPage);

        model.addAttribute("filter", new Filter(country, status));
        model.addAttribute("customersPage", customersPage);
        model.addAttribute("pageNumbers", pageNumbers);

        return "home";
    }
}