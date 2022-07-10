/* eslint-disable react/require-default-props */
import React, { useState } from 'react';
import InputBox from './InputBox';
import { dts } from '../utils/types';
import BasicButton from './BasicButton';
// import OrderModal from './OrderModal';
import OrderHistory from './OrderHistory'
import constants from '../utils/constants';

/**
 * @param props 
 * @param type 
 */
interface Props {
  props?: dts.menuDto;
  type?: string;
}

export default function MyOrder({
  props = {
    category: '',
    id: '-',
    name: '',
    temp: '',
    size: '',
    price: '',
    date: '',
  },
  type = 'display',
}: Props) {
  const [orderHistory, setOrderHistory] = useState(false);
  return type !== 'display' ? (
    <div className="grid grid-cols-7 gap-4 py-6 whitespace-nowrap text-center items-center text-base pl-10">
      <InputBox placeholder="카테고리" text={props.category} />
      {type === 'new' ? <div>-</div> : <div>{props.id}</div>}
      <InputBox placeholder="메뉴 이름" text={props.name} />
    </div>
  ) : (
    <div className="flex justify-between py-6 whitespace-nowrap text-center items-center text-base">
      {/* <div className='flex justify-between whitespace-nowrap text-xs'> */}
      
      <div className='pl-10'>{props.date}</div>
      <div>{props.name}</div>

      <div className="flex text-center pr-10">
        <BasicButton buttonName="상세보기" onClick={() => setOrderHistory(true)} xPadding="px-14" />
      </div>

      {orderHistory && <OrderHistory orderList={constants.ORDER} onClose={() => setOrderHistory(false)} />}
    </div>
  );
}
