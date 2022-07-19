import * as React from 'react';

// MinusCircle.tsx는 장바구니에서 제품수량을 설정할때 사용하는 코드로 SetNumer.tsx에서 사용

function MinusCircle() {
  return (
    <svg width={24} height={24} viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
      <path
        d="M9.505 17.595a7.129 7.129 0 1 0 0-14.258 7.129 7.129 0 0 0 0 14.258z"
        stroke="#000"
        strokeWidth={2}
        strokeMiterlimit={10}
        strokeLinecap="round"
        strokeLinejoin="round"
      />

      <path d="M6.337 10.466h6.337" stroke="#000" strokeWidth={2} strokeLinecap="round" strokeLinejoin="round" />
    </svg>
  );
}
export default MinusCircle;
