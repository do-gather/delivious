package com.delivious.backend.domain.orders.service;

import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.repository.MenuRepository;
import com.delivious.backend.domain.orders.dto.request.OrderCreateDto;
import com.delivious.backend.domain.orders.dto.request.OrderDetailCreate;
import com.delivious.backend.domain.orders.dto.response.OrderCreateResponse;
import com.delivious.backend.domain.orders.dto.response.OrderDetailStatusResponse;
import com.delivious.backend.domain.orders.dto.response.OrderInfo;
import com.delivious.backend.domain.orders.entity.Order;
import com.delivious.backend.domain.orders.entity.OrderDetail;
import com.delivious.backend.domain.orders.entity.OrderDetailStatus;
import com.delivious.backend.domain.orders.repository.OrderDetailRepository;
import com.delivious.backend.domain.orders.repository.OrderRepository;
import com.delivious.backend.domain.users.entity.User;
import com.delivious.backend.domain.users.repository.UserRepository;
import com.delivious.backend.domain.users.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final OrderDetailRepository orderDetailRepository;
    private final MenuRepository menuRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository, MenuRepository menuRepository, UserService userService,UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.menuRepository = menuRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }


    // StoreId 랑 연결 오류...
    // 주문 하기
    @Transactional
    public OrderCreateResponse order(OrderCreateDto orderCreateDto){
        User userReference = userService.getReferenceByName(orderCreateDto.getUsername());
        //Store storeId = StoreService.getStoreIdByOrder(orderCreateDto.getStoreId());
        Order newOrder = Order.createOrder(userReference,/*orderCreateDto.getStoreId()*/ orderCreateDto.getTotalPrice(), orderCreateDto.getTotalCount());
        orderRepository.save(newOrder);


        List<OrderDetailCreate> orderDetailList = orderCreateDto.getOrderDetailList();
        for(OrderDetailCreate orderDetailCreate : orderDetailList){
            Menu menu = menuRepository.findById(orderDetailCreate.getMenuId()).orElseThrow();
            System.out.println(menu.getMenu_name());

            // 주문 목록에 메뉴 개수가 1개 초과일 경우
            if(orderDetailCreate.getCount()>1){
                for(int i=0 ; i<orderDetailCreate.getCount();i++){
                    OrderDetail detail = OrderDetail.builder()
                            .order(newOrder)
                            .menu(menu)
                            .count(i)
                            .price(menu.getMenu_price())
                            .build();
                    orderDetailRepository.save(detail);
                }
            }
            // 주문 목록에 메뉴 개수가 1개 일경우
            else{
                OrderDetail detail = OrderDetail.builder()
                        .order(newOrder)
                        .menu(menu)
                        .price(menu.getMenu_price())
                        .count(1)
                        .build();
                orderDetailRepository.save(detail);
            }
        }
        return OrderCreateResponse
                .builder()
                .orderStatus(newOrder.getOrderStatus())
                .totalCount(orderCreateDto.getTotalCount())
                .totalPrice(orderCreateDto.getTotalPrice())
                .build();

    }



    // 주문 목록 보기 - 관리자


    // 주문 상태 변경
    public OrderDetailStatusResponse changeStatus(UUID orderdetailId) throws Exception {
        OrderDetail orderdetail = (OrderDetail) orderDetailRepository
                .findById(orderdetailId)
                .orElseThrow();

        switch (orderdetail.getStatus()) {
            case COOK:
                orderdetail.cookOrderDetail();
                break;
            case SERVE:
                orderdetail.serveOrderDetail();
                break;
            case DONE:
                orderdetail.doneOrderDetail();
            default:
                throw new Exception("status error");
        }
        orderDetailRepository.save(orderdetail);
        return OrderDetailStatusResponse
                .builder()
                .status(orderdetail.getStatus())
                .orderdetailId(orderdetail.getOrderdetailId())
                .build();
    }


}
