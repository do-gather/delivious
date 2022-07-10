import React, { useState } from 'react';
import AddCircle from '../images/AddCircle';
import MinusCircle from '../images/MinusCircle'

// SetNumber.tsx는 장바구니에서 제품수량을 설정하기 위한 코드로 ShopingCart.tsx에서 사용
export default function SetNumber() {
  const [count, setCount] = useState(0);
  const minusClicked = () => {
    if (count > 0) setCount(count - 1);
  };
  const plusClicked = () => {
    setCount(count + 1);
  };
  return (
    <div className="flex space-x-2 items-center text-left">
      <button onClick={minusClicked} type="button">
        <MinusCircle />
      </button>
      <p>{count}</p>
      <button onClick={plusClicked} type="button">
        <AddCircle />
      </button>
    </div>
  );
}
