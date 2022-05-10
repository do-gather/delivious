/* eslint-disable react/require-default-props */
import React, { useState } from 'react';

/**
 * input box
 * @param placeholder 플레이스 홀더에 들어갈 말을 변수로 받음
 * @param text input box에 채워져 있어야 할 텍스트를 변수로 받음, 기본은 ''
 * @param icon input box에 아이콘이 있다면 아이콘을 받음
 * @param mode input box 색상 테마를 받음 기본은 normal, 어두운 것은 dark
 */
interface Props {
  placeholder: string;
  text?: string;
  icon?: any;
  mode?: string;
}

export default function InputBox({ placeholder, icon = 'none', text = '', mode = 'normal' }: Props) {
  const [value, setValue] = useState(text);

  const handleTextChange = (e: any) => {
    setValue(e.target.value);
  };

  return (
    <div className="w-full">
      {icon === 'none' ? (
        <input
          className={
            mode === 'dark'
              ? 'placeholder-gray-400 text-white bg-black h-9 w-full my-1 px-2 rounded'
              : 'bg-white text-base text-center placeholder-gray-500 py-2.5 h-10 w-36'
          }
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
