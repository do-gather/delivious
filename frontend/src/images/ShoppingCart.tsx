import * as React from 'react';

function ShoppingCart() {
  return (
    <svg width={30} height={30} fill="none" xmlns="http://www.w3.org/2000/svg">
      <path
        d="M21.25 26.25a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5ZM10 26.25a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5Z"
        stroke="#000"
        strokeWidth={3}
        strokeLinecap="round"
        strokeLinejoin="round"
      />
      <path
        d="M3.75 3.75h1.49c.589 0 1.098.412 1.222.988l3.326 15.524a1.25 1.25 0 0 0 1.223.988H21.25"
        stroke="#000"
        strokeWidth={3}
        strokeLinecap="round"
        strokeLinejoin="round"
      />
      <path
        d="M7.5 7.5h17.088a1.25 1.25 0 0 1 1.201 1.596l-2.163 7.5a1.25 1.25 0 0 1-1.201.904H9.663"
        stroke="#000"
        strokeWidth={3}
        strokeLinecap="round"
        strokeLinejoin="round"
      />
    </svg>
  );
}

export default ShoppingCart;
