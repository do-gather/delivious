import React from 'react';
import OrderHistory from '../components/OrderHistory';
import constants from '../utils/constants';

export default function MyOrderlist() {
  return (
    <div>
      <OrderHistory orderList={constants.ORDER} />
    </div>
  );
}
