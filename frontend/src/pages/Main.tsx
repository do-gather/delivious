import React, { useState } from 'react';
import MenuItem from '../components/MenuItem';
import constants from '../utils/constants';
import Tap from '../components/Tap';
import AdminLogin from '../images/AdminLogin';
import AdminLoginModal from '../components/AdminLoginModal';
import ShopingCart from '../components/ShopingCart';
import OrderModal from '../components/OrderModal';
import { useUserInfo } from '../utils/store';

/**
 * '/'로 연결되는 메인 페이지
 * 사용자가 보는 메뉴 목록 및 장바구니
 */

function Divider() {
  return <div className="border-b w-full" style={{ borderColor: '#c4c4c4' }} />;
}

export default function Main() {
  // 어드민 로그인 모달 띄우는 기능을 위한 상태관리
  const [adminLogin, setAdminLogin] = useState(false);
  const [orderModal, setOrderModal] = useState(false);
  const [orderList, setOrderList] = useState({
    orders: [{ count: 0, menuName: '', menuId: '13947839', price: 0, size: '', temperature: '' }],
    totalPrice: 0,
    inOut: 'IN',
  });
  const { storeName } = useUserInfo();

  const addToCart = (order: any) => {
    setOrderList({
      ...orderList,
      orders: [...orderList.orders, order],
    });
  };

  const submitCart = (cartList: any) => {
    setOrderList(cartList);
    setOrderModal(true);
  };

  const updateCart = (cartList: any) => {
    setOrderList(cartList);
  };

  return (
    <div className="flex pt-28 pb-2 gap-12 overflow-y-hidden h-full">
      <div className="pl-12 flex-col w-44 space-y-3 text-center">
        <div className="text-base font-bold pb-2 whitespace-nowrap">{storeName}</div>
        {constants.CATEGORIES.map(item => (
          <div className="text-sm cursor-pointer" key={item.id}>
            {item.name}
          </div>
        ))}
      </div>
      <div className="w-full">
        <div className="flex space-x-2 items-center pb-5 text-left whitespace-nowrap">
          <div className="font-bold text-xl">Menu</div>
        </div>
        <div className="h-4/5 overflow-y-auto">
          {constants.CATEGORIES.map(category => (
            <div className="text-base font-bold" key={category.id}>
              {category.name}
              <Divider />
              <div className="flex flex-wrap pt-5 gap-12 pb-12">
                {constants.MENU_ITEMS.map(
                  menu =>
                    menu.category === category.name && <MenuItem props={menu} onSubmit={addToCart} key={menu.id} />,
                )}
              </div>
            </div>
          ))}
        </div>
      </div>
      <button type="button" className="absolute right-12 top-10" onClick={() => setAdminLogin(true)}>
        <AdminLogin />
      </button>
      <div className="flex right-0 top-16">
        <Tap color="#435ca5" name="주문하기" link="/" />
        <ShopingCart orderList={orderList} onSubmit={submitCart} updateCart={updateCart} />
      </div>
      {adminLogin && <AdminLoginModal onClose={() => setAdminLogin(false)} />}
      {orderModal && <OrderModal orderList={orderList} onClose={() => setOrderModal(false)} />}
    </div>
  );
}
