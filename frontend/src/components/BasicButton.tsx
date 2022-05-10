/* eslint-disable react/require-default-props */
import React from 'react';

/**
 * 기본 직사각형 버튼
 * @param buttonName 버튼에 들어갈 이름을 받음
 * @param onClick 버튼이 눌렸을 때 작동할 함수 받음
 * @param xPadding 버튼 안쪽의 좌우 패딩을 변수로 받아 셋팅, 기본은 px-10
 */
interface Props {
  buttonName: string;
  onClick: any;
  xPadding?: string;
}

export default function BasicButton({ buttonName, onClick, xPadding = 'px-10' }: Props) {
  return (
    <button
      type="button"
      className={`flex whitespace-nowrap items-center rounded text-base font-bold text-white text-center 
        ${xPadding} object-left-top h-10`}
      style={{ backgroundColor: '#435ca5' }}
      onClick={onClick}
    >
      {buttonName}
    </button>
  );
}
