/* eslint-disable react/require-default-props */

import React from 'react';
import { dts } from '../utils/types';
import LinkButton from './LinkButton';
import constants from '../utils/constants';
import CountMenu from './CountMenu';
/**
 * @param props 
 * @param type 
 */
interface Props {
  props?: dts.menuDto;
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
  }
}: Props) {
  return (
    <div className="flex justify-between whitespace-nowrap text-center items-center text-base">
      
      <div className='pl-10'>{props.date}</div>
        <div className="flex justify-between py-6 whitespace-nowrap text-center items-center text-base">
          {props.name} <CountMenu orderList={constants.ORDER}/>
        </div>

      <div className="flex text-center pr-10">
      <LinkButton color="#435ca5" name="상세보기" link="/mypage/orderhistory" />
      </div>
    </div>
  );
}
