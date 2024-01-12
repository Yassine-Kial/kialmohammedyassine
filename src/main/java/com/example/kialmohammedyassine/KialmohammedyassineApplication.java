package com.example.kialmohammedyassine;

import com.example.kialmohammedyassine.entity.*;
import com.example.kialmohammedyassine.repository.*;
import com.example.kialmohammedyassine.type.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class KialmohammedyassineApplication {

	public static void main(String[] args) {
		SpringApplication.run(KialmohammedyassineApplication.class, args);
	}



	@Autowired
	CashRepository cashRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderDetailRepository orderDetailRepository;


	@Autowired
	ItemRepository itemRepository;

	@Autowired
	OrderRepository orderRepository;





	@Bean
	CommandLineRunner coucou() {
		return  args -> {

			Customer customer = new Customer("mohamed","safi");
			Order order = new Order(new Date(500000), Status.CONFIRMED);

			Item item = new Item(500,"iphone");
			OrderDetail orderDetail = new OrderDetail(1,"20%");

			Cash cash = new Cash(8999,10000.25f);
			item.addOrderDetail(orderDetail);
			order.addOrderDetail(orderDetail);
			order.addPayment(cash);
			customer.addOrder(order);

			customerRepository.save(customer);
			orderRepository.save(order);
			cashRepository.save(cash);
			itemRepository.save(item);
			orderDetailRepository.save(orderDetail);








		};
	}

}
