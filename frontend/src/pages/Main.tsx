import React, { useState } from 'react';
import MenuItem from '../components/MenuItem';
import constants from '../utils/constants';
import Tap from '../components/Tap';
import AdminLogin from '../images/AdminLogin';
import AdminLoginModal from '../components/AdminLoginModal';
import ShopingCart from '../components/ShopingCart';
import ShoppingCart from '../images/ShoppingCart';
import BasicButton from '../components/BasicButton';
import OrderModal from '../components/OrderModal';

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
  const [modal, setModal] = useState(false);

  return (
    <div className="flex pt-28 pb-2 gap-12 overflow-y-hidden h-full">
      <div className="pl-12 flex-col w-44 space-y-3 text-center">
        <div className="text-base font-bold pb-2 whitespace-nowrap">스타벅스 강남R점</div>
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
                  menu => menu.category === category.name && <MenuItem props={menu} key={menu.id} />,
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
        <div className="w-64 min-h-screen bg-white">
          <div className="flex space-x-2 top-11 items-center text-left whitespace-nowrap">
            <ShoppingCart />
            <div className="text-lg font-bold pb-2 cursor-pointer">장바구니</div>
          </div>
          {constants.MENU_ITEMS.map(menu => (
            <ShopingCart props={menu} key={menu.id} />
          ))}
        </div>
      </div>
      {adminLogin && <AdminLoginModal onClose={() => setAdminLogin(false)} />}
      <div className="flex fixed text-center right-14 bottom-16">
        <BasicButton buttonName="결제" onClick={() => setModal(true)} xPadding="px-14" />
      </div>
      {modal && <OrderModal onClose={() => setModal(false)} />}
    </div>
  );
}
