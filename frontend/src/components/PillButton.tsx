import React from 'react';

/**
 * 기본 둥근 모서리 버튼 (메뉴 담는 과정에서 쓰임)
 * @param buttonTitle 버튼에 들어갈 이름을 받음
 * @param onClick 버튼 클릭 시 실행될 함수 받음
 * @param activeColor 버튼 클릭 시 바뀔 배경 색상 받음
 */
interface Props {
  buttonTitle: string;
  onClick: any;
  // eslint-disable-next-line react/require-default-props
  activeColor?: string;
}

export default function PillButton({ buttonTitle, onClick, activeColor = 'active:bg-indigo-900' }: Props) {
  return (
    <button
      type="button"
      className={`flex whitespace-nowrap justify-center items-center rounded-3xl text-base text-center 
        px-2 h-7 bg-white ${activeColor} active:text-white text-black `}
      onClick={onClick}
    >
      {buttonTitle}
    </button>
  );
}
