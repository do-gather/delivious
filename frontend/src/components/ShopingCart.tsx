import React, { useState } from 'react';
import AddCircle from '../images/AddCircle';

/**
 * 사용자 메뉴 목록의 각 아이템
 *
 * @param props 메뉴안에 들어갈 각 항목을 아래 인터페이스 형태로 묶어서 받음
 */
interface Props {
  props: {
    category: string;
    id: string;
    name: string;
    temp: string;
    size: string;
    price: string;
    date: string;
  };
}

export default function ShopingCart({ props }: Props) {
  const [count, setCount] = useState(0);

  const minusClicked = () => {
    if (count > 0) setCount(count - 1);
  };
  const plusClicked = () => {
    setCount(count + 1);
  };

  return (
    <div className="text-center text-xs">
      <div>
        <div
          className="w-36 h-36 bg-white whitespace-nowrap items-center bg-contain bg-center"
          style={{
            backgroundImage: 'url(https://myauto.shinhancard.com/conts/images/event/evt_181001_02_gift04.png)',
          }}
        >
          <div className="fixed text-left right-8">
            <div>
              {props.name}/{props.temp}
              <br />
              size {props.size}
              <br />
              price {props.price}
            </div>
            <div className="flex space-x-2 items-center text-left">
              <button onClick={minusClicked} type="button">
                <AddCircle />
              </button>
              <p>{count}</p>
              <button onClick={plusClicked} type="button">
                <AddCircle />
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
