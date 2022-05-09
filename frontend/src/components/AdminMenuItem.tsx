/* eslint-disable react/require-default-props */
import React from 'react';
import CheckBox from './CheckBox';
import WhiteInputBox from './WhiteInputBox';
import AddCircle from '../images/AddCircle';
import TrashCan from '../images/TrashCan';
import getYmd10 from '../utils/utils';
import { dts } from '../utils/types';

/**
 * 어드민 메뉴 목록의 각 아이템
 * 수정 모드일 경우 수정 전 메뉴 아이템 값이 기본으로 들어가 있게 됨
 * @param props 메뉴안에 들어갈 각 항목을 아래 인터페이스 형태로 묶어서 받음
 * @param type 아이템이 수정 상태인지 아닌지 입력, 기본은 'display'. 수정 시 'edit'을 전달.
 *              새로 추가 시 'new' 전달. 전달하지 않으면 'display'로 초기화 됨
 */
interface Props {
  props?: dts.menuDto;
  type?: string;
}

export default function AdminMenuItem({
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
  const currentDate = getYmd10();
  // const [menu, setMenu] = useState(props || ({
  //     category: '',
  //     id: '-',
  //     name: '',
  //     temp: '',
  //     size: '',
  //     price: '',
  //     date: '',
  // }))

  const handleChecked = (options: string, label: string) => {
    return options.includes(label);
  };

  return type !== 'display' ? (
    <div className="grid grid-cols-7 gap-4 py-6 whitespace-nowrap text-center items-center text-base pl-10">
      <WhiteInputBox placeholder="카테고리" text={props.category} />
      {type === 'new' ? <div>-</div> : <div>{props.id}</div>}
      <WhiteInputBox placeholder="메뉴 이름" text={props.name} />
      <div className="flex justify-center space-x-3">
        <CheckBox label="Hot" checked={handleChecked(props.temp, 'Hot')} />
        <CheckBox label="Ice" checked={handleChecked(props.temp, 'Ice')} />
      </div>
      <div className="flex-col justify-center space-y-1">
        <CheckBox label="Tall" checked={handleChecked(props.size, 'Tall')} />
        <CheckBox label="Grande" checked={handleChecked(props.size, 'Grande')} />
        <CheckBox label="Venti" checked={handleChecked(props.size, 'Venti')} />
      </div>
      <WhiteInputBox placeholder="가격" text={props.price} />
      <div className="flex justify-between px-5">
        {type === 'new' ? <div>{currentDate}</div> : <div>{props.date}</div>}
        <div className="cursor-pointer">
          {type === 'edit' && <TrashCan />}
          {type === 'new' && <AddCircle />}
        </div>
      </div>
    </div>
  ) : (
    <div className="grid grid-cols-7 gap-4 py-6 whitespace-nowrap text-center items-center text-base px-10">
      <div>{props.category}</div>
      <div>{props.id}</div>
      <div>{props.name}</div>
      <div>{props.temp}</div>
      <div>{props.size}</div>
      <div>{props.price}</div>
      <div>{props.date}</div>
    </div>
  );
}
