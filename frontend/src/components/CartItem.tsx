import React, { useEffect, useState } from 'react';
import AddCircle from '../images/AddCircle';
import SubtractCircle from '../images/SubtractCircle';

// CartItem.tsx은 장바구니 아이템 관리를 위한 코드로 ShopingCart.tsx에서 사용

interface Props {
  order: {
    count: number;
    menuId: string;
    menuName: string;
    price: number;
    size: string;
    temperature: string;
  };
  onSubmit: any;
}

export default function CartItem({ order, onSubmit }: Props) {
  const [item, setItem] = useState(order);
  const [count, setCount] = useState(order.count);

  const minusClicked = () => {
    if (count > 0) {
      setItem({ ...item, count: count - 1 });
      setCount(count - 1);
    }
  };
  const plusClicked = () => {
    setItem({ ...item, count: count + 1 });
    setCount(count + 1);
  };

  useEffect(() => {
    onSubmit(item);
  }, [item]);

  return (
    <div key={order.menuId} className="flex">
      <div
        className="w-36 h-36 bg-white whitespace-nowrap items-center bg-contain bg-center"
        style={{
          backgroundImage: 'url(https://myauto.shinhancard.com/conts/images/event/evt_181001_02_gift04.png)',
        }}
      />
      <div className="flex text-left">
        <div className="py-5 text-xs " key={order.menuId}>
          <div className="font-bold px-12"> </div>
          <div className="font-bold pb-1.5">{order.menuName}</div>
          <div className="flex justify-between pb-0.5 whitespace-nowrap">
            <div>size</div>
            <div>{order.size}</div>
          </div>
          <div className="flex justify-between pb-1.5 whitespace-nowrap">
            <div>price</div>
            <div> {order.price} ₩</div>
          </div>
          <div className="flex space-x-2 items-center text-left">
            <button onClick={minusClicked} type="button">
              <SubtractCircle />
            </button>
            <p>{count}</p>
            <button onClick={plusClicked} type="button">
              <AddCircle />
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}
