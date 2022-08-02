/* eslint-disable react/require-default-props */
import React from 'react';

/**
 * 기본 직사각형 버튼
 * @param buttonName 버튼에 들어갈 이름을 받음
 * @param onClick 버튼이 눌렸을 때 작동할 함수 받음
 * @param height 버튼의 높이를 받음, 기본은 h-10
 * @param color 버튼의 색상을 받음, 기본은 '#435ca5'
 */
interface Props {
  buttonName: string;
  onClick: any;
  height?: string;
  state?: string;
  xPadding?: string;
}

export default function BasicButton({
  buttonName,
  state = 'ready',
  onClick,
  xPadding = 'px-10',
  height = 'h-10',
}: Props) {
  return (
    <button
      type="button"
      className={`whitespace-nowrap items-center rounded text-base font-bold text-white text-center 
        ${xPadding} object-left-top ${height} `}
      style={{ backgroundColor: state === 'ready' ? '#435ca5' : '#c4c4c4' }}
      onClick={onClick}
    >
      {buttonName}
    </button>
  );
}
