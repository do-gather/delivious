import React, { useEffect, useState } from 'react';
import BasicButton from './BasicButton';
import InputBox from './InputBox';
import ToggleButton from './ToggleButton';

/**
 * 주문하기 창
 * @param onClose 닫힘 버튼을 누를 때 실행될 함수 받음
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
  onClose: any;
}

export default function OrderModal({ onClose, orderList }: Props) {
  const [step, setStep] = useState(1);
  const [totalPrice, setTotalPrice] = useState(0);
  const [finalOrder, setFinalOrder] = useState(orderList);

  useEffect(() => {
    let price = 0;
    // eslint-disable-next-line no-return-assign
    orderList.orders.map(item => item.price * item.count).forEach(item => (price += item));
    setTotalPrice(price);
  }, []);

  const setInOut = (inOut: number) => {
    setFinalOrder({ ...finalOrder, inOut: inOut === 1 ? 'IN' : 'OUT' });
  };

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
        {step === 1 ? (
          <div className="px-48 pt-10 pb-16 w-full flex flex-col whitespace-nowrap font-bold ">
            <div className="text-xl">구매 내역</div>
            <div className="border-b mt-1 w-full border-zinc-300" />
            <div className="flex py-2 justify-between whitespace-nowrap text-xs">
              <div>음료</div>
              <div>수량</div>
              <div>가격</div>
            </div>
            {orderList.orders.map(
              item =>
                item.count !== 0 && (
                  <div className="grid grid-cols-3 py-2 whitespace-nowrap text-xs" key={item.menuId}>
                    <div>{item.menuName}</div>
                    <div className="font-normal text-center ">{item.count}</div>
                    <div className="text-right">{item.price} ₩</div>
                  </div>
                ),
            )}
            <div className="border-b my-3 w-full border-zinc-300" />
            <div className="flex justify-between text-xs">
              <div>총</div>
              <div>{totalPrice} ₩</div>
            </div>
            <div className="flex w-full my-8">
              <ToggleButton option1="매장 안에서" option2="테이크 아웃" clickedOption={1} onClick={setInOut} />
            </div>

            <div className="place-self-center w-40">
              <BasicButton buttonName="결제 완료" onClick={() => setStep(step + 1)} />
            </div>
          </div>
        ) : (
          <div className="px-48 pt-10 text-center text-xl pb-16 w-full flex flex-col whitespace-nowrap font-bold ">
            <div>들리버스 앱으로 주문을 확인하려면,</div>
            <div>가입한 아이디를 입력해주세요.</div>
            <div className="flex w-full my-8 text-xs">
              <InputBox placeholder="아이디 입력" text="" mode="dark" />
            </div>
            <div className="place-self-center w-40">
              <BasicButton buttonName="완료하기" onClick={() => window.location.replace('/')} />
            </div>
          </div>
        )}
      </div>
    </div>
  );
}
