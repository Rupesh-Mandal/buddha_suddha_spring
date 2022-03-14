package com.softkali.buddha_suddha.order.service;

import com.softkali.buddha_suddha.order.model.AddOrder;
import com.softkali.buddha_suddha.order.model.OrderModel;
import com.softkali.buddha_suddha.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {
    private final String serverKey = "AAAAII8dniY:APA91bEVV8AFEHi8LvP5ckTGNK1bzvvhQgoIs84Z3KYihsCdWAfLRiYzi64Iy1tedIURM7Ejfj1F3lIoX1loFY8-zJwX_FXTCBDEcGgt3psSN93SUVDhrc7MrQefPbOS1jBoGs2ml3Te";
    private final OrderRepository orderRepository;


    public Object addOrder(AddOrder addOrder) {
        JSONObject jsonObject = new JSONObject();

        String orderId= UUID.randomUUID().toString();
        String status = "1";
        String statusMassege = "Pending to Accept";

        OrderModel orderModel =new OrderModel(orderId,addOrder.getUserId(),"",false,true, addOrder.getName(),
                addOrder.getPhoneNumber(),addOrder.getProductDeliverAddress(),addOrder.getLocation(),
                addOrder.getOrderData(),addOrder.getTotalRate(), status,statusMassege, LocalDateTime.now());

        orderRepository.save(orderModel);

        jsonObject.put("status", true);
        jsonObject.put("messag", "Successfully Ordered");
        sendNotification("New Order", addOrder.getProductDeliverAddress(), "/topics/" + orderModel.getLocation());

        return jsonObject;


    }

    public Object acceptOrder(OrderModel orderModel) {
        String status = "2";
        String statusMassege = "Order Accepted";

        JSONObject jsonObject = new JSONObject();

        orderModel.setStatus(status);
        orderModel.setStatusMessage(statusMassege);
        orderRepository.save(orderModel);
        if (orderRepository.save(orderModel).getStatus().equals("2")) {
            jsonObject.put("status", true);
            jsonObject.put("messag", "Order Accepted");
            sendNotification("Order Accepted", "", "/topics/" + orderModel.getUserId());
            return jsonObject;
        }

        jsonObject.put("status", false);
        jsonObject.put("messag", "something went wrong");
        return jsonObject;
    }


    public Object setPickup(OrderModel orderModel) {
        JSONObject jsonObject = new JSONObject();

        orderRepository.save(orderModel);
        sendNotification("Order Accepted", "", "/topics/" + orderModel.getPickupBoyId());
        jsonObject.put("status", true);
        jsonObject.put("messag", "onification sent to pickup boy");
        return jsonObject;
    }


    public Object cancelOrderBySeller(OrderModel orderModel) {
        String status = "0";
        String statusMassege = "Order Cancel by Seller";

        JSONObject jsonObject = new JSONObject();

        orderModel.setStatus(status);
        orderModel.setStatusMessage(statusMassege);
        orderRepository.save(orderModel);
        if (orderRepository.save(orderModel).getStatus().equals("0")) {
            jsonObject.put("status", true);
            jsonObject.put("messag", "Cancel Successfully");
            sendNotification("Order Cancel by Seller", " ", "/topics/" + orderModel.getUserId());
            sendNotification("Order Cancel by Seller", " ", "/topics/" + orderModel.getPickupBoyId());

            return jsonObject;
        }

        jsonObject.put("status", false);
        jsonObject.put("messag", "something went wrong");
        return jsonObject;
    }



    public Object cancelOrderByPickupBoy(OrderModel orderModel) {
        String status = "0";
        String statusMassege = "Order Cancel by Pickup Boy";

        JSONObject jsonObject = new JSONObject();

        orderModel.setStatus(status);
        orderModel.setStatusMessage(statusMassege);
        orderRepository.save(orderModel);
        if (orderRepository.save(orderModel).getStatus().equals("0")) {
            jsonObject.put("status", true);
            jsonObject.put("messag", "Cancel Successfully");
            sendNotification("Order Cancel by Pickup Boy", " ", "/topics/" + orderModel.getUserId());
            sendNotification("Order Cancel by Pickup Boy", " ", "/topics/" + orderModel.getLocation());

            return jsonObject;
        }

        jsonObject.put("status", false);
        jsonObject.put("messag", "something went wrong");
        return jsonObject;
    }




    public Object cancelOrderByUser(OrderModel orderModel) {
        String status = "0";
        String statusMassege = "Order Cancel by User";

        JSONObject jsonObject = new JSONObject();

        orderModel.setStatus(status);
        orderModel.setStatusMessage(statusMassege);
        orderRepository.save(orderModel);
        if (orderRepository.save(orderModel).getStatus().equals("0")) {
            jsonObject.put("status", true);
            jsonObject.put("messag", "Cancel Successfully");
            sendNotification("Order Cancel by User", " ", "/topics/" + orderModel.getPickupBoyId());
            sendNotification("Order Cancel by User", " ", "/topics/" + orderModel.getLocation());

            return jsonObject;
        }

        jsonObject.put("status", false);
        jsonObject.put("messag", "something went wrong");
        return jsonObject;
    }




    public Object deliverdFaildOrder(OrderModel orderModel) {
        String status = "0";
        String statusMassege = "Delivery Faild";

        JSONObject jsonObject = new JSONObject();

        orderModel.setStatus(status);
        orderModel.setStatusMessage(statusMassege);
        orderRepository.save(orderModel);
        if (orderRepository.save(orderModel).getStatus().equals("0")) {
            jsonObject.put("status", true);
            jsonObject.put("messag", "Cancel Successfully");
            sendNotification("Delivery Faild", " ", "/topics/" + orderModel.getUserId());
            sendNotification("Delivery Faild", " ", "/topics/" + orderModel.getLocation());

            return jsonObject;
        }

        jsonObject.put("status", false);
        jsonObject.put("messag", "something went wrong");
        return jsonObject;
    }



    public Object findByOrderId(String orderId) {
        return orderRepository.findByOrderId(orderId).get();
    }

    public Object findByUserId(String userId) {
        return orderRepository.findByUserId(userId).get();
    }

    public Object findByPickupBoyId(String pickupBoyId) {
        return orderRepository.findByPickupBoyId(pickupBoyId).get();
    }

    public Object findByLocation(String location) {
        return orderRepository.findByLocation(location).get();
    }

    public Object findByStatus(String status) {
        return orderRepository.findByStatus(status).get();
    }

    public Object findByPickupBoyStatus(boolean pickupBoyStatus) {
        return orderRepository.findByPickupBoyStatus(pickupBoyStatus).get();
    }



    @Async
    void sendNotification(String title, String body, String to) {
        JSONObject jsonObject = new JSONObject();
        JSONObject dataObject = new JSONObject();
        dataObject.put("title", title);
        dataObject.put("body", body);
        jsonObject.put("to", to);

        jsonObject.put("data", dataObject);

        String url = "https://fcm.googleapis.com/fcm/send";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "key="+serverKey);

// build the request
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(jsonObject, headers);

// send POST request
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        System.out.println(response.toString());
    }

}
