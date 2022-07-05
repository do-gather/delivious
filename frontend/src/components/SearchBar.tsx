/* eslint-disable react/require-default-props */

import React from 'react';
import SearchIcon from '../images/SearchIcon';

/**
 * 검색 입력 창
 * @param placeholder 플레이스 홀더에 들어갈 말을 변수로 받음
 * @param barWidth
 */
interface Props {
  placeholder: string;
  barWidth?: string;
}

export default function SearchBar({ placeholder, barWidth = '28.75rem'}: Props) {
  return (
    <div className="relative h-10" style={{ width: barWidth }}>
      <div className="absolute left-3.5 top-3">
        <SearchIcon />
      </div>
      <input
        type="text"
        className="rounded-3xl bg-white pl-10 text-sm placeholder-gray-500 py-2.5 object-left-top h-10"
        style={{ width: barWidth }}
        placeholder={placeholder}
      />
    </div>
  );
}
