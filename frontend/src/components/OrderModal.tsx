import React, { useState } from 'react';
import { dts } from '../utils/types';
import BasicButton from './BasicButton';
import InputBox from './InputBox';
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
  const [step, setStep] = useState(1);

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
            {orderList.orders.map(item => (
              <div className="grid grid-cols-3 py-2 whitespace-nowrap text-xs" key={item.menu.id}>
                <div>{item.menu.name}</div>
                <div className="font-normal text-center ">{item.quantity}</div>
                <div className="text-right">{item.menu.price} ₩</div>
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
              <BasicButton buttonName="결제 완료" onClick={() => setStep(step + 1)} />
            </div>
          </div>
        ) : (
          <div className="px-48 pt-10 text-center text-xl pb-16 w-full flex flex-col whitespace-nowrap font-bold ">
            <div>들리버스 앱으로 주문을 확인하려면,</div>
            <div>가입한 전화번호를 입력해주세요.</div>
            <div className="flex w-full my-8 text-xs">
              <InputBox placeholder="전화번호 입력" text="010-" mode="dark" />
            </div>
            <div className="px-4 place-self-center">
              <BasicButton buttonName="완료하기" onClick={() => window.location.replace('/')} />
            </div>
          </div>
        )}
      </div>
    </div>
  );
}
