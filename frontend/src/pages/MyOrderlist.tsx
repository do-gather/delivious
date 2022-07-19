import React from 'react';
import SearchBar from '../components/SearchBar';
import constants from '../utils/constants';
import MyOrder from '../components/MyOrder';

/**
 * '/admin/menu'로 연결되는 주문목록 페이지
 *
 * @param menuDto 주문목록 기록을 확인할 수 있음
 */
function Divider() {
  return <div className="border-b w-full" style={{ borderColor: '#c4c4c4' }} />;
}

export default function MyOrderlist() {
  return (
    <div className="w-full h-full py-24 overflow-y-hidden">
      <div className="grid grid-cols-8 pl-5 space-x-10 items-center pb-8 ">
        <div className="col-span-1 font-bold text-3xl whitespace-nowrap pr-3">주문목록</div>
        <SearchBar barWidth='18rem' placeholder="Year/ Month/ Date" />
      </div>
      <div
        className=" gap-4 px-10 justify-between font-semibold whitespace-nowrap
text-white h-12 text-center items-center text-2xl"
        style={{ backgroundColor: '#435CA5' }}
      >
        <div className='pt-1.5'>Menu</div>
      </div>
      <div className="h-5/6 overflow-y-scroll">
        {constants.MENU_ITEMS.map(menu => (
          <div key={menu.id}>
            <MyOrder props={menu}/>
            <Divider />
          </div>
        ))}
      </div>
    </div>
  );
}
