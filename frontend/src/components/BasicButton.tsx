/* eslint-disable react/require-default-props */
import React from 'react';

/**
 * 기본 직사각형 버튼
 * @param buttonName 버튼에 들어갈 이름을 받음
 * @param onClick 버튼이 눌렸을 때 작동할 함수 받음
 * @param height 버튼의 높이를 받음, 기본은 h-10
 */
interface Props {
  buttonName: string;
  onClick: any;
  height?: string;
}

export default function BasicButton({ buttonName, onClick, height = 'h-10' }: Props) {
  return (
    <button
      type="button"
      className={`flex w-full justify-center whitespace-nowrap items-center rounded text-base font-bold text-white 
      text-center object-left-top ${height}`}
      style={{ backgroundColor: '#435ca5' }}
      onClick={onClick}
    >
      {buttonName}
    </button>
  );
}
