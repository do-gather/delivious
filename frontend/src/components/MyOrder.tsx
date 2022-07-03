/* eslint-disable react/require-default-props */
import React from 'react';
import InputBox from './InputBox';
import { dts } from '../utils/types';
import Tap1 from './Tap1';

import constants from '../utils/constants';
import CountMenu from './CountMenu';

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
  return type !== 'display' ? (
    <div className="grid grid-cols-7 gap-4 py-6 whitespace-nowrap text-center items-center text-base pl-10">
      <InputBox placeholder="카테고리" text={props.category} />
      {type === 'new' ? <div>-</div> : <div>{props.id}</div>}
      <InputBox placeholder="메뉴 이름" text={props.name} />
    </div>
  ) : (
    <div className="flex justify-between whitespace-nowrap text-center items-center text-base">
      
      <div className='pl-10'>{props.date}</div>
        <div className="flex justify-between py-6 whitespace-nowrap text-center items-center text-base">
          {props.name} <CountMenu orderList={constants.ORDER}/>
        </div>

      <div className="flex text-center pr-10">
      <Tap1 color="#435ca5" name="상세보기" link="/mypage/orderhistory" />
      </div>
    </div>
  );
}
