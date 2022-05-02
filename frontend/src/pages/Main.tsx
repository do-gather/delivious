import React from 'react';
import MenuItem from '../components/MenuItem';
import constants from '../utils/constants';
import Tap from '../components/Tap';

/**
 * '/'로 연결되는 메인 페이지
 * 사용자가 보는 메뉴 목록 및 장바구니
 */

function Divider() {
  return <div className="border-b w-full" style={{ borderColor: '#c4c4c4' }} />;
}

export default function Main() {
  return (
    <div className="flex pt-12" style={{ backgroundColor: '#E5E5E5', height: '100%' }}>
      <div className="pl-12 flex-col w-44 space-y-3 text-center">
        <div className="text-base font-bold pb-2 whitespace-nowrap">스타벅스 강남R점</div>
        {constants.CATEGORIES.map(item => (
          <div className="text-sm cursor-pointer" key={item.id}>
            {item.name}
          </div>
        ))}
      </div>
      <div className="w-full h-screen pl-14 pr-80">
        <div className="flex space-x-2 items-center pb-5 text-left whitespace-nowrap">
          <div className="font-bold text-xl">Menu</div>
        </div>
        {constants.CATEGORIES.map(category => (
          <>
            <div className="text-base font-bold">{category.name}</div>
            <Divider />
            <div className="flex flex-wrap pt-5 gap-12 pb-12">
              {constants.MENU_ITEMS.map(
                menu => menu.category === category.name && <MenuItem props={menu} key={menu.id} />,
              )}
            </div>
          </>
        ))}
      </div>
      <div className="flex fixed right-0 top-16">
        <Tap color="#435ca5" name="주문하기" link="/" />
        <div className="w-64 min-h-screen bg-white" />
      </div>
    </div>
  );
}
