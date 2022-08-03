import React, { useState } from 'react';
import ShoppingCartIcon from '../images/ShoppingCart';
import BasicButton from './BasicButton';
import CartItem from './CartItem';
// ShopingCart.tsx는 Main화면에서 장바구니를 구현하는 코드로 Main.tsx에서 사용

/**
 * 사용자 메뉴 목록의 각 아이템
 *
 * @param menuDto 메뉴안에 들어갈 각 항목을 아래 인터페이스 형태로 묶어서 받음
 */

interface Order {
  count: number;
  menuId: string;
  menuName: string;
  price: number;
  size: string;
  temperature: string;
}
interface Props {
  orderList: {
    orders: Array<Order>;
    totalPrice: number;
    inOut: string;
  };
  onSubmit: any;
  updateCart: any;
}

export default function ShopingCart({ orderList, onSubmit, updateCart }: Props) {
  const [cartList, setCartList] = useState(orderList);

  const updateItem = (order: Order) => {
    const newOrderList = cartList.orders.filter((item: Order) => item.menuId !== order.menuId);
    if (order.count !== 0) {
      setCartList({ ...cartList, orders: [...newOrderList, order] });
    } else {
      setCartList({ ...cartList, orders: newOrderList });
      updateCart({ ...cartList, orders: newOrderList });
    }
  };

  const submitCart = () => {
    onSubmit(cartList);
  };

  return (
    <div className="flex w-64 min-h-screen bg-white flex-col">
      <div className="flex pt-5 pl-5 space-x-2 whitespace-nowrap">
        <ShoppingCartIcon />
        <div className="text-lg font-bold pb-2 cursor-pointer">장바구니</div>
      </div>
      <div className="text-center text-xs">
        {orderList.orders.map(
          item => item.count !== 0 && <CartItem key={item.menuId} order={item} onSubmit={updateItem} />,
        )}
      </div>
      <div className="absolute px-14 pb-2 place-self-center bottom-2">
        <BasicButton buttonName="결제" onClick={submitCart} />
      </div>
    </div>
  );
}
