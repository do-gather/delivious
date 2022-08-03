import React from 'react';
import { Link, useLocation } from 'react-router-dom';
import MainLogo from '../images/MainLogo';

/**
 * 로고가 위치하는 헤더 컴포넌트
 * 추후, url을 읽어서 페이지에 맞는 로고로 변형되도록 구현
 */

export default function Header() {
  const url = useLocation();

  return (
    <header className="fixed w-full h-16" style={{ backgroundColor: '#E5E5E5' }}>
      <div>
        {url.pathname.includes('login') && (
          <div className=" flex justify-center mt-64 md:mx-0 mx-4">
            <MainLogo width="576" height="122.032" />
          </div>
        )}
        {url.pathname.includes('sign-up') && (
          <Link className=" flex justify-center mt-14" to="/">
            <MainLogo width="231" height="49" />
          </Link>
        )}
        {!url.pathname.includes('sign-up') && !url.pathname.includes('login') && (
          <Link className="flex w-fit mx-12 py-9" to={url.pathname.includes('mypage') ? '/mypage' : '/'}>
            <MainLogo width="118" height="25" />
          </Link>
        )}
      </div>
    </header>
  );
}
