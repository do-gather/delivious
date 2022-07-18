package com.delivious.backend.domain.orders.dto.request;

import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.entity.Size;
import com.delivious.backend.domain.orders.entity.InOut;
import com.delivious.backend.domain.orders.entity.Order;
import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Data
public class OrderRequest {

    @NotNull
    private UUID menuId;

    private UUID userId;

    private UUID storeId;

    private int count;

    private Size size;

    private String Tempature;

    private InOut inOut;



}
