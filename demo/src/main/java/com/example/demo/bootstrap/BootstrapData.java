package com.example.demo.bootstrap;

import com.example.demo.dao.CartItemRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    private final CartItemRepository cartItemRepository;


    public BootstrapData(CustomerRepository customerRepository, CartItemRepository cartItemRepository) {
        this.customerRepository = customerRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //if the repository has more than 1 customer already present add 5 new customers
        if (!(this.customerRepository.count() > 1)) {
            this.bootStrapCustomers();
        }
    }

    private void bootStrapCustomers() {
//        //test
//        CartItem ci = new CartItem();
//        ci.set;
//        ci.setVacation_id(1L);

//        this.cartItemRepository.save(ci);

        Customer customer1 = new Customer();
        Customer customer2 = new Customer();
        Customer customer3 = new Customer();
        Customer customer4 = new Customer();
        Customer customer5 = new Customer();

        //set all Ids
        customer1.setId(10L);
        customer2.setId(11L);
        customer3.setId(13L);
        customer4.setId(14L);
        customer5.setId(12L);

        //set all first names;
        customer1.setFirstName("Bill");
        customer2.setFirstName("Jim");
        customer3.setFirstName("Luna");
        customer4.setFirstName("Lily");
        customer5.setFirstName("Emily");

        //set all last names
        customer1.setLastName("Jones");
        customer2.setLastName("Mcgill");
        customer3.setLastName("Bean");
        customer4.setLastName("Bug");
        customer5.setLastName("Mcdonald");

        //set all address
        customer1.setAddress("923 Hulana St");
        customer2.setAddress("46 Kriswood Dr");
        customer3.setAddress("200 Charter Ln");
        customer4.setAddress("212 N Easterling St");
        customer5.setAddress("35 Old Mill Rd");

        //set all postal codes
        customer1.setPostal_code("30741");
        customer2.setPostal_code("30731");
        customer3.setPostal_code("31210");
        customer4.setPostal_code("30721");
        customer5.setPostal_code("30125");

        //set all phone numbers
        customer1.setPhone("4234649495");
        customer2.setPhone("4231201546");
        customer3.setPhone("8937651029");
        customer4.setPhone("9018279474");
        customer5.setPhone("7469019273");

        //


        //add all customer to set
        Set<Customer> customers = new HashSet<Customer>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);

        //add all to repository
        this.customerRepository.saveAll(customers);

    }

    private Division createDivision(Division division) {
        Division div = new Division();

        div.setId(division.getId());
        div.setDivision_name(division.getDivision_name());
        div.setCountry_id(division.getCountry_id());

        div.setCountry(division.getCountry());
        div.setCustomers(division.getCustomers());


        return div;
    }
}
