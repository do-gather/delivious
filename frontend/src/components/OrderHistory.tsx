import React from 'react';
// import React,{useState} from 'react';
import { dts } from '../utils/types';
import Cooking from '../images/Cooking'
// import constants from '../utils/constants';
// import MyOrder from '../components/MyOrder';

/**
 * '/admin/menu'로 연결되는 주문목록 페이지
 *
 * @param menuDto 주문목록 기록을 확인할 수 있음
 *
 */
interface Props {
  orderList: dts.orderList;
}

function Divider() {
  return <div className="border-b w-full" style={{ borderColor: '#c4c4c4' }} />;
}

export default function MyOrderlist({ orderList }: Props) {
  
  
  return (
    <div className="w-full h-full py-24 overflow-y-hidden">
      <div className="grid grid-cols-8 pl-5 space-x-10 items-center pb-8 ">
        <div className="col-span-1 font-bold text-3xl whitespace-nowrap">주문 상세</div>
      </div>
      <div
        className=" gap-4 px-10 justify-between font-semibold whitespace-nowrap
text-white h-12 text-center items-center text-2xl"
        style={{ backgroundColor: '#435CA5' }}
      >
        <div className="pt-1.5">Order History</div>
      </div>
      <div>
        <div className='font-bold col-span-1 text-2xl whitespace-nowrap py-5 pl-9 '>스타벅스</div>
        <Divider />
        {orderList.orders.map(item => (
          <div className="grid grid-cols-3 pl-11 space-x-10 items-center pb-8" key={item.menu.id}>
            {/* className="flex justify-between py-6 whitespace-nowrap text-center items-center text-base" */}
            <div>{item.menu.name}</div>
            <div className="text-center">{item.menu.price} ₩</div>
            <Cooking/>
          </div>
        ))}
        
        <Divider />
        <div className="grid grid-cols-3 py-2 whitespace-nowrap text-xs ">
          <div className="pl-10 col-span-1 font-bold text-xl whitespace-nowrap">Total</div>
          <div className="pl-20 col-span-1  text-xl">{orderList.total} ₩</div>
        </div>
      </div>
    </div>
  );
}
