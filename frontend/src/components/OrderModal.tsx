import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { dts } from '../utils/types';
import BasicButton from './BasicButton';
import ToggleButton from './ToggleButton';

/**
 * 주문하기 창
 * @param onClose 닫힘 버튼을 누를 때 실행될 함수 받음
 */
interface Props {
  onClose: any;
  orderList: dts.orderList;
}

export default function OrderModal({ onClose, orderList }: Props) {
  const navigate = useNavigate();
  const [step, setStep] = useState(1);
  const [finish, setFinish] = useState(false);

  useEffect(() => {
    if (finish) navigate('/admin');
  }, [finish, navigate]);

  return (
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
        <button
          className="w-fit float-right my-3 mr-6 text-gray-600 hover:text-red-600"
          type="button"
          onClick={onClose}
        >
          close
        </button>
        <div className="px-48 pt-10 pb-16 w-full flex flex-col whitespace-nowrap font-bold ">
          <div className="text-xl">구매 내역</div>
          <div className="border-b mt-1 w-full border-zinc-300" />
          <div className="flex py-2 justify-between whitespace-nowrap text-xs">
            <div>음료</div>
            <div>수량</div>
            <div>가격</div>
          </div>
          {orderList.orders.map(item => (
            <div className="flex py-2 justify-between whitespace-nowrap text-xs" key={item.menu.id}>
              <div>{item.menu.name}</div>
              <div className="font-normal">{item.quantity}</div>
              <div>{item.menu.price} ₩</div>
            </div>
          ))}
          <div className="border-b my-3 w-full border-zinc-300" />
          <div className="flex justify-between text-xs">
            <div>총</div>
            <div>{orderList.total} ₩</div>
          </div>
          <div className="flex w-full my-8">
            <ToggleButton option1="매장 안에서" option2="테이크 아웃" clickedOption={1} />
          </div>

          <div className="px-4 place-self-center">
            <BasicButton buttonName="결제 완료" onClick={() => (step === 1 ? setStep(step + 1) : setFinish(true))} />
          </div>
        </div>
      </div>
    </div>
  );
}
