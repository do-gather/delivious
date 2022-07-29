/* eslint-disable no-unused-vars */
/* eslint-disable react/require-default-props */
/* eslint-disable @typescript-eslint/no-explicit-any */
import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import SearchIcon from '../images/SearchIcon';

/**
 * 검색 입력 창
 * @param placeholder 플레이스 홀더에 들어갈 말을 변수로 받음
 * @param icon search bar에 아이콘을 받음
 * @param iconRight search bar에 오른쪽에 값이 있을때 아이콘을 받음
 */
interface Props {
  placeholder: string;
  icon?: any;
  iconRight?: any;
  barWidth?: string;
  onAddKeyword?: any;
}

export default function SearchBar({
  barWidth = '18rem',
  placeholder,
  icon = <SearchIcon />,
  iconRight = false,
  onAddKeyword,
}: Props) {
  const [text, setText] = useState('');
  const navigate = useNavigate();

  const handleKeyword = (e: any) => {
    setText(e.target.value);
  };

  const handleEnter = (e: any) => {
    if (text && e.keyCode === 13) {
      onAddKeyword(text);
      setText('');
    }
  };

  const handleClearKeyword = () => {
    setText('');
  };

  return (
    <div className="relative h-10" style={{ width: '28.75rem' }}>
      <div className="absolute left-3.5 top-3"> {icon} </div>
      <div className={`absolute" ${iconRight ? 'right-3.5 top-2' : 'left-3.5 top-3'}`} />
      <input
        type="text"
        className="rounded-3xl bg-white pl-10 text-sm placeholder-gray-500 py-2.5 object-left-top h-10"
        style={{ width: barWidth }}
        placeholder={placeholder}
        onChange={handleKeyword}
        onKeyDown={handleEnter}
      />
    </div>
  );
}
