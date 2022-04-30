import React from 'react';
import { Link } from 'react-router-dom';
import MainLogo from '../images/MainLogo';

/**
 * 로고가 위치하는 헤더 컴포넌트
 * 추후, url을 읽어서 페이지에 맞는 로고로 변형되도록 구현
 */

export default function Header() {
  return (
    <div className="px-14 py-9">
      <Link className="flex w-fit" to="/">
        <MainLogo />
      </Link>
    </div>
  );
}
