import React from 'react';
import SearchBar from '../components/SearchBar';
import Tap from '../components/Tap';
import constants from '../utils/constants';
import CalendarIcon from '../images/CalendarIcon';
import BasicButton from '../components/BasicButton';
import ArrowRight from '../images/ArrowRight';

/**
 * /admin/orders으로 연결되는 페이지
 * 관리자용 메뉴버튼에서 주문을 누르고 주문을 관리하는 페이지
 */

function Divider() {
  return <div className="border-b w-full" style={{ borderColor: '#c4c4c4' }} />;
}

export default function AdminOrder() {
  return (
    <div className="w-full h-screen pl-14 pr-32 py-24 overflow-y-auto">
      <div className="grid grid-cols-8 space-x-4 items-center pb-8 justify-between">
        <div className="col-span-1 font-bold text-3xl whitespace-nowrap">주문관리</div>
        <div className="col-span-5">
          <SearchBar placeholder="2022/03/26" icon={<CalendarIcon />} iconRight={<ArrowRight />} />
        </div>
      </div>
      <div
        className="grid grid-cols-6 gap-4 px-10 font-semibold whitespace-nowrap text-white h-12
             text-center items-center text-2xl"
        style={{ backgroundColor: '#435CA5' }}
      >
        <div>Order#</div>
        <div>Time</div>
        <div>Table</div>
        <div>Order Histroy</div>
        <div> </div>
        <div>Price</div>
      </div>
      <div className="h-3/4 overflow-y-scroll">
        {constants.ORDER_ITEMS.map(orders => (
          <div key={orders.order_number}>
            <div
              className="grid grid-cols-6 gap-4 px-10 pl-10 pr-6 py-10
                            items-center text-center text-base"
            >
              <div>{orders.order_number}</div>
              <div>{orders.time}</div>
              <div>{orders.table}</div>
              <div>{orders.history}</div>
              <div>
                <BasicButton
                  state={orders.state}
                  buttonName="주문 보내기"
                  xPadding="px-6"
                  onClick={console.log('주문 보내기')}
                />
              </div>
              <div>{orders.price}</div>
            </div>
            <Divider />
          </div>
        ))}
      </div>

      <div className="flex-col space-y-8 fixed right-0 top-14">
        <Tap color="#000000" name="주문하기" link="/" />
        <Tap color="#435ca5" name="관리페이지" link="/admin" />
      </div>
    </div>
  );
}
