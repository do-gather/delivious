/* eslint-disable react/require-default-props */
import React from 'react';

/**
 * 기본 직사각형 버튼
 * @param buttonName 버튼에 들어갈 이름을 받음
 * @param onClick 버튼이 눌렸을 때 작동할 함수 받음
 * @param xPadding 버튼 안쪽의 좌우 패딩을 변수로 받아 셋팅, 기본은 px-10
 * @param height 버튼의 높이를 받음, 기본은 h-10
 * @param state 버튼의 상태를 받는 변수, 기본은 파란버튼
 */
interface Props {
  buttonName: string;
  onClick: any;
  xPadding?: string;
  height?: string;
  state?: string;
}

export default function BasicButton({ buttonName, state, onClick, xPadding = 'px-10', height = 'h-10' }: Props) {
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
