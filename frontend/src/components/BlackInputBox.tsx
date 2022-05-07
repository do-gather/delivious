/* eslint-disable react/require-default-props */
import React, { useState } from 'react';

/**
 * 메뉴 수정 시 input box
 * @param placeholder 플레이스 홀더에 들어갈 말을 변수로 받음
 * @param icon input box에 아이콘이 있다면 아이콘을 받음
 */
interface Props {
  placeholder: string;
  icon?: any;
}

export default function BlackInputBox({ placeholder, icon = 'none' }: Props) {
  const [value, setValue] = useState('');

  const handleTextChange = (e: any) => {
    setValue(e.target.value);
  };

  return (
    <div className="w-full">
      {icon === 'none' ? (
        <input
          className="h-9 w-full my-1 px-2 rounded placeholder-gray-400 text-white bg-black"
          placeholder={placeholder}
          value={value}
          onChange={handleTextChange}
        />
      ) : (
        <div className="relative my-1">
          <div className="absolute right-2 top-2.5">{icon}</div>
          <input
            className="pl-2 pr-7 h-9 w-full rounded placeholder-gray-400 text-white bg-black  object-left-top"
            placeholder={placeholder}
            value={value}
            onChange={handleTextChange}
          />
        </div>
      )}
    </div>
  );
}
