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
      className="flex-wrap items-center px-4 w-40 h-10 text-white text-center 
        text-base leading-8 rounded"
      style={{ backgroundColor: color }}
      to={link}
    >
      {name}
    </Link>
  );
}
