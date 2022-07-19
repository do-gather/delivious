/* eslint-disable react/require-default-props */
import React, { useState } from 'react';

/**
 * 직사각형 토글 버튼
 * @param option1 첫 번째 토글 버튼에 들어갈 이름을 받음
 * @param option2 두 번째 토글 버튼에 들어갈 이름을 받음
 * @param clickedOption 선택된 토글 버튼의 순서를 숫자로 받음
 */
interface Props {
  option1: string;
  option2: string;
  clickedOption: number;
}

export default function ToggleButton({ option1, option2, clickedOption }: Props) {
  const [clicked, setClicked] = useState(clickedOption);
  return (
    <div className="flex -space-x-1 w-full">
      <button
        type="button"
        className={`flex w-full whitespace-nowrap items-center rounded-l text-base font-bold text-white text-center 
        ${clicked === 1 && 'rounded-r z-50'} justify-center px-10 h-10`}
        style={{ backgroundColor: clicked === 1 ? '#000000' : '#c4c4c4' }}
        onClick={() => {
          setClicked(1);
        }}
      >
        {option1}
      </button>
      <button
        type="button"
        className={`flex w-full whitespace-nowrap items-center  rounded-r text-base font-bold text-white text-center 
        ${clicked === 2 && 'rounded-l'}  justify-center px-10 h-10`}
        style={{ backgroundColor: clicked === 2 ? '#000000' : '#c4c4c4' }}
        onClick={() => {
          setClicked(2);
        }}
      >
        {option2}
      </button>
    </div>
  );
}
