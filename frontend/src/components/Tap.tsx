import React from 'react';
import { Link } from 'react-router-dom';

/**
 * 어드민 페이지 오른쪽 사이드 버튼
 * @param name 버튼에 표시되는 이름
 * @param color 버튼 색
 * @param link 버튼이 연결될 링크
 */
interface Props {
  name: string;
  color: string;
  link: string;
}

export default function Tap({ color, link, name }: Props) {
  return (
    <Link
      className="flex flex-wrap items-center px-4 w-12 h-56 text-white text-center 
        text-base leading-8 rounded-l"
      style={{ backgroundColor: color }}
      to={link}
    >
      {name}
    </Link>
  );
}
