import React  from 'react';
import { dts } from '../utils/types';
import BasicButton from './BasicButton';

/**
 * 주문하기 창
 * @param onClose 닫힘 버튼을 누를 때 실행될 함수 받음
 */
interface Props {
  onClose: any;
  orderList: dts.orderList;
}

export default function OrderHistory({ onClose, orderList }: Props) {

  return (
    // <BasicButton buttonName="확인 완료" onClick={() => window.location.replace('/mypage/orderlist')} />
    <div
      className="w-full h-screen top-0 z-50"
      style={{ backgroundColor: 'rgba(1,1,1,0.5)', position: 'fixed', overflow: 'hidden' }}
    >
      <div
        className="rounded"
        style={{
          backgroundColor: '#f0f0f0',
          position: 'absolute',
          top: '50%',
          left: '50%',
          transform: 'translate(-50%, -50%)',
        }}
      >
        
        
        <div className="px-24 pb-10 w-full flex flex-col whitespace-nowrap font-bold ">
            <div className="text-xl pt-12 pb-2">구매 내역</div>
            <div className="border-b mt-1 w-full border-zinc-300" />
            <div className="flex py-2 justify-between whitespace-nowrap text-xs">
              <div className="px-10">음료</div>
              <div className="px-10">수량</div>
              <div className="px-10">가격</div>
            </div>
            {orderList.orders.map(item => (
              <div className="grid grid-cols-3 py-2 whitespace-nowrap text-xs" key={item.menu.id}>
                <div>{item.menu.name}</div>
                <div className="font-normal text-center ">{item.quantity}</div>
                <div className="text-center">{item.menu.price} ₩</div>
              </div>
            ))}
            <div className="border-b my-5 w-full border-zinc-300" />
            <div className="px-6 flex justify-between text-xs">
              <div className="pl-5">총</div>
              <div>{orderList.total} ₩</div>
            </div>

            <div className="px-4 pt-8 place-self-center">
              <BasicButton buttonName="확인 완료" onClick={onClose} />
            </div>
          </div>
      </div>
    </div>
  );
}

