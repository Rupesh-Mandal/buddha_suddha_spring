package com.softkali.buddha_suddha.order.controller;

import com.softkali.buddha_suddha.order.model.AddOrder;
import com.softkali.buddha_suddha.order.model.OrderModel;
import com.softkali.buddha_suddha.order.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping(path = "addOrder")
    public Object addOrder(@RequestBody AddOrder addOrder) {
        return orderService.addOrder(addOrder);
    }

    @PostMapping(path = "acceptOrder")
    public Object acceptOrder(@RequestBody OrderModel orderModel) {
        return orderService.acceptOrder(orderModel);
    }

  @PostMapping(path = "setPickup")
    public Object setPickup(@RequestBody OrderModel orderModel) {
        return orderService.setPickup(orderModel);
    }


    @PostMapping(path = "cancelOrderBySeller")
    public Object cancelOrderBySeller(@RequestBody OrderModel orderModel) {
        return orderService.cancelOrderBySeller(orderModel);
    }


    @PostMapping(path = "cancelOrderByPickupBoy")
    public Object cancelOrderByPickupBoy(@RequestBody OrderModel orderModel) {
        return orderService.cancelOrderByPickupBoy(orderModel);
    }


    @PostMapping(path = "cancelOrderByUser")
    public Object cancelOrderByUser(@RequestBody OrderModel orderModel) {
        return orderService.cancelOrderByUser(orderModel);
    }


    @PostMapping(path = "deliverdFaildOrder")
    public Object deliverdFaildOrder(@RequestBody OrderModel orderModel) {
        return orderService.deliverdFaildOrder(orderModel);
    }


    @PostMapping(path = "findByOrderId")
    public Object findByOrderId(@RequestParam String orderId) {
        return orderService.findByOrderId(orderId);
    }

    @PostMapping(path = "findByUserId")
    public Object findByUserId(@RequestParam String userId) {
        return orderService.findByUserId(userId);
    }

    @PostMapping(path = "findByPickupBoyId")
    public Object findByPickupBoyId(@RequestParam String pickupBoyId) {
        return orderService.findByPickupBoyId(pickupBoyId);
    }

    @PostMapping(path = "findByLocation")
    public Object findByLocation(@RequestParam String location) {
        return orderService.findByLocation(location);
    }

    @PostMapping(path = "findByStatus")
    public Object findByStatus(@RequestParam String status) {
        return orderService.findByStatus(status);
    }

    @PostMapping(path = "findByPickupBoyStatus")
    public Object findByPickupBoyStatus(@RequestParam boolean pickupBoyStatus) {
        return orderService.findByPickupBoyStatus(pickupBoyStatus);
    }
}
