import React from 'react';
import { dts } from '../utils/types';
import SetNumber from './SetNumber'
// ShopingCart.tsx는 Main화면에서 장바구니를 구현하는 코드로 Main.tsx에서 사용

/**
 * 사용자 메뉴 목록의 각 아이템
 *
 * @param menuDto 메뉴안에 들어갈 각 항목을 아래 인터페이스 형태로 묶어서 받음
 */
interface Props {
  orderList: dts.orderList;
}

export default function ShopingCart({ orderList }: Props) {
  
  return (
    <div className="text-center text-xs">
      <div>
        <div>
          {orderList.orders.map(item => (
            <div className="flex">
              <div
                className="w-36 h-36 bg-white whitespace-nowrap items-center bg-contain bg-center"
                style={{
                  backgroundImage: 'url(https://myauto.shinhancard.com/conts/images/event/evt_181001_02_gift04.png)',
                }}
              />
              <div className="flex text-left">
                <div className="py-5 text-xs " key={item.menu.id}>
                  <div className="font-bold px-12"> </div>
                  <div className="font-bold pb-1.5">{item.menu.name}</div>
                  <div className="flex justify-between pb-0.5 whitespace-nowrap">
                    <div>size</div>
                    <div>{item.menu.size}</div>
                  </div>
                  <div className="flex justify-between pb-1.5 whitespace-nowrap">
                    <div>price</div>
                    <div> {item.menu.price} ₩</div>
                  </div>
                  <SetNumber/>
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}
