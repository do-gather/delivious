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

export default function LinkButton({ color, link, name }: Props) {
  return (
    <Link
      className="flex flex-wrap items-center px-5 w-24 h-11 text-white text-center 
        text-base leading-8"
      style={{ backgroundColor: color }}
      to={link}
    >
      {name}
    </Link>
  );
}
