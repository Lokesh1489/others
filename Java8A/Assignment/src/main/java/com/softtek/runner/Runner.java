package com.softtek.runner;
/**
 * 
 * @author sanjay.bannigol
 *
 */
import java.time.LocalDate;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.softtek.entity.Order;
import com.softtek.entity.Product;
import com.softtek.repo.ProductRepo;
import com.softtek.service.ShopService;

@Component
public class Runner implements CommandLineRunner {
	@Autowired
	private ShopService service;

	@Autowired
	private ProductRepo ProdRepo;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

		System.out.println("$$$$$$$$$$$$$-Question 1-$$$$$$$$$$$$$$$$$$$");
		List<Product> listOfProduct1 = service.listOfProduct();
		List<Product> collect1 = listOfProduct1.stream()
				.filter(ls -> ls.getCategory().equalsIgnoreCase("books") && ls.getPrice() > 100)
				.collect(Collectors.toList());
		collect1.forEach(c -> System.out.println(c));
		

		System.out.println("$$$$$$$$$$$$$-Question 2-$$$$$$$$$$$$$$$$$$$");


		List<Order> listOfOrders = service.listOfOrders();
		List<Order> collect = listOfOrders.stream()
				.filter(order -> order.getProducts().stream()
						.anyMatch(product -> product.getCategory().equalsIgnoreCase("Baby")))
				.collect(Collectors.toList());
		System.out.println(collect);

		
		System.out.println("$$$$$$$$$$$$$-Question 3-$$$$$$$$$$$$$$$$$$$");

		List<Product> listOfProduct2 = service.listOfProduct();
		List<Product> collect2 = listOfProduct2.stream().filter(l -> l.getCategory().equalsIgnoreCase("Toys"))
				.map(p -> {
					p.setPrice(p.getPrice() - (p.getPrice() * 0.10));
					return p;
				}).collect(Collectors.toList());
		collect2.forEach(p -> System.out.println(p.toString()));
		

		System.out.println("$$$$$$$$$$$$$-Question 4-$$$$$$$$$$$$$$$$$$$");

		List<Order> listOfOrders4 = service.listOfOrders();
		List<Order> collect4 = listOfOrders4.stream()
				.filter(c -> c.getCustomer().getTier() == 2 && c.getOrderDate().isAfter(LocalDate.of(2021, 02, 01))
						&& c.getDeliveryDate().isBefore(LocalDate.of(2021, 04, 01)))
				.collect(Collectors.toList());
		System.out.println(collect4);
		

		System.out.println("$$$$$$$$$$$$$-Question 5-$$$$$$$$$$$$$$$$$$$");

		List<Product> listOfProduct3 = service.listOfProduct();
		Optional<Product> filter = listOfProduct3.stream().filter(p -> p.getCategory().equalsIgnoreCase("Books"))
				.min(Comparator.comparing(Product::getPrice));
		System.out.println(filter);
		

		System.out.println("$$$$$$$$$$$$$-Question 6-$$$$$$$$$$$$$$$$$$$");
		List<Order> listOfOrders2 = service.listOfOrders();
		List<Order> collect3 = listOfOrders2.stream().sorted(Comparator.comparing(Order::getOrderDate).reversed())
				.limit(3).collect(Collectors.toList());
		collect3.forEach((p) -> {
			System.out.println(p.toString());
		});
		

		System.out.println("$$$$$$$$$$$$$-Question 7-$$$$$$$$$$$$$$$$$$$");

		List<Order> listOfOrders7 = service.listOfOrders();

		listOfOrders7.stream().filter(x -> x.getOrderDate().isEqual(LocalDate.parse("2021-03-15")))

				.map(p -> p.getProducts()).forEach(System.out::println);
		

		System.out.println("$$$$$$$$$$$$$-Question 8-$$$$$$$$$$$$$$$$$$$");

		List<Order> listOfOrders8 = service.listOfOrders();
		long count3 = listOfOrders8.stream().filter(f -> f.getOrderDate().isEqual(LocalDate.of(2021, 02, 01)))
				.map(m -> m.getOrder_id()).collect(Collectors.toList()).stream().count();
		System.out.println(count3);

		System.out.println("$$$$$$$$$$$$$-Question 9-$$$$$$$$$$$$$$$$$$$");

		DoubleSummaryStatistics collect9 = service.listOfOrders().stream()
				.filter(x -> x.getOrderDate().isEqual(LocalDate.parse("2021-03-14")))
				.flatMap(i -> i.getProducts().stream()).mapToDouble(P -> P.getPrice()).summaryStatistics();
		System.out.println("Order average payment placed on 14-Mar-2021 : " + collect9.getAverage());

		System.out.println("$$$$$$$$$$$$$-Question 10-$$$$$$$$$$$$$$$$$$$");
		List<Product> listOfProduct10 = service.listOfProduct();
		DoubleSummaryStatistics stat = listOfProduct10.stream().filter(ls -> ls.getCategory().equalsIgnoreCase("books"))
				.mapToDouble(x -> x.getPrice()).summaryStatistics();
		System.out.println("Addition  : " + stat.getSum());
		System.out.println("Average : " + stat.getAverage());
		System.out.println("Maximum : " + stat.getMax());
		System.out.println("Minimum : " + stat.getMin());
		System.out.println("Count : " + stat.getCount());

		System.out.println("$$$$$$$$$$$$$-Question 11-$$$$$$$$$$$$$$$$$$$");
		listOfOrders.stream().collect(Collectors.toMap(i -> i.getOrder_id(), o -> o.getProducts().size())).entrySet()
				.stream()

				.toList().forEach(System.out::println);

		System.out.println("$$$$$$$$$$$$$-Question 12-$$$$$$$$$$$$$$$$$$$");
		listOfOrders.stream().collect(Collectors.groupingBy(Order::getCustomer)).entrySet().stream().toList()
				.forEach(System.out::println);

		System.out.println("$$$$$$$$$$$$$-Question 13-$$$$$$$$$$$$$$$$$$$");
		listOfOrders.stream()
				.collect(Collectors.toMap(i -> i, o -> o.getProducts().stream().mapToDouble(i -> i.getPrice()).sum()))
				.entrySet().stream().toList().forEach(System.out::println);

		System.out.println("$$$$$$$$$$$$$-Question 14-$$$$$$$$$$$$$$$$$$$");
		listOfProduct2.stream().collect(Collectors.groupingBy(i -> i.getCategory())).entrySet().stream()
				.forEach(System.out::println);

		System.out.println("$$$$$$$$$$$$$-Question 15-$$$$$$$$$$$$$$$$$$$");
		listOfProduct1.stream()
				.collect(Collectors.groupingBy(Product::getCategory,
						Collectors.maxBy(Comparator.comparing(Product::getPrice))))
				.forEach((category, product) -> System.out.println(category + " :: " + product.get().getPrice()));

	}

}
