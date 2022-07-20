package com.delivious.backend.domain.orders.dto.response;

import com.delivious.backend.domain.menu.entity.Size;
import com.delivious.backend.domain.orders.entity.InOut;
import com.delivious.backend.domain.orders.entity.Temparature;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
public class OrderDetailResponse {
        private UUID orderdetailId;
        private UUID menuId;
        private int count;
        private float price;
        private Size size;
        private InOut inOut;
        private Temparature temparature;

        @Builder
        public OrderDetailResponse(UUID orderdetailId, UUID menuId, int count, float price, Size size, InOut inOut, Temparature temparature) {
            this.orderdetailId = orderdetailId;
            this.menuId = menuId;
            this.count = count;
            this.price = price;
            this.size = size;
            this.inOut = inOut;
            this.temparature = temparature;
        }

}
