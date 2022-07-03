import React from 'react';
// import React,{useState} from 'react';
import { dts } from '../utils/types';
/**
 * '/admin/menu'로 연결되는 주문목록 페이지
 *
 * @param menuDto 주문목록 기록을 확인할 수 있음
 *
 */
interface Props {
  orderList: dts.orderList;
}

export default function CountMenu({ orderList }: Props) {
  
  return (
      <div>
        {/* {orderList.orders.map(item => ( */}
          <div className="flex justify-between py-6 whitespace-nowrap text-center items-center text-base" >
              {orderList.orders.length===1 ? (<div>{}</div>)
              : (<div>외 {orderList.orders.length}건</div> )}
            {/* <div>외 {orderList.orders.length}건</div>  */}
          </div>
        {/* ))} */}
      </div>
  );
}
