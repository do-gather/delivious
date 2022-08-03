package com.delivious.backend.domain.orders.dto.request;

import com.delivious.backend.domain.orders.entity.InOut;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderCreateRequest {

    @NotNull
    private UUID storeId;

    @NotNull
    private UUID userId;

    @NotNull
    private InOut inOut;

    private List<OrderDetailCreateRequest> orderDetails;
}
