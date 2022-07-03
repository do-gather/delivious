import React from 'react';
import OrderHistory from '../components/OrderHistory';
// import { dts } from '../utils/types';
import constants from '../utils/constants';

export default function MyOrderlist() {
  // const [myOrder, setMyOrder] = useState(false);
  return (
    <div>
      <OrderHistory orderList={constants.ORDER} />
    </div>
  );
}
