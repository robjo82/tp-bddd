package com.tp.bddd.service;

import com.tp.bddd.model.Material;
import com.tp.bddd.model.Member;
import com.tp.bddd.model.Order;
import com.tp.bddd.model.enums.Status;
import com.tp.bddd.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberService memberService;
    private final MaterialService materialService;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }

    public Iterable<Order> getOrdersByDate(LocalDate startDate, LocalDate endDate) {
        return orderRepository.findByDateBetween(startDate, endDate);
    }

    public Iterable<Order> getOrdersByClient(String clientId) {
        return orderRepository.findByClientId(clientId);
    }

    public Iterable<Order> getOrdersBySeller(String sellerId) {
        return orderRepository.findBySellerId(sellerId);
    }

    public Iterable<Order> getOrdersByMaterial(String materialQuery) {

        return orderRepository.findByMaterialQuery(materialQuery);
    }

    public List<Order> generateRandomOrders(int amount) {
        List<Order> generatedOrders = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < amount; i++) {
            Order order = new Order();
            order.setDate(LocalDate.now());
            setRandomClient(order, random);
            setRandomSeller(order, random);
            setRandomMaterial(order, random);

            order.setTotal(order.getMaterials().stream().mapToDouble(Material::getPrice).sum());

            generatedOrders.add(saveOrder(order));
        }

        return generatedOrders;
    }

    private void setRandomClient(Order order, Random random) {
        List<Member> clients = memberService.getAllMembersByStatus(Status.CLIENT);
        order.setClient(clients.get(random.nextInt(clients.size())));
    }

    private void setRandomSeller(Order order, Random random) {
        List<Member> sellers = memberService.getAllMembersByStatus(Status.SELLER);
        order.setSeller(sellers.get(random.nextInt(sellers.size())));
    }

    private void setRandomMaterial(Order order, Random random) {
        List<Material> materials = (List<Material>) materialService.getAllMaterials();
        order.setMaterials(List.of(materials.get(random.nextInt(materials.size()))));
    }
}
