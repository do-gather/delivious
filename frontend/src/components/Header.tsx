import React from 'react';
import { Link, useLocation } from 'react-router-dom';
import MainLogo from '../images/MainLogo';

/**
 * 로고가 위치하는 헤더 컴포넌트
 * 추후, url을 읽어서 페이지에 맞는 로고로 변형되도록 구현
 */
//  function logo {
//   "login":{<Link className=" flex justify-center mt-64" to="/login">
//     <MainLogo width="576" height="122.032"/>},
//   "sign-up" : { (<Link className="flex w-fit mx-12 py-9" to="/">
//     <MainLogo width="118" height="25" /> </Link>)}
//   }
//   return 

export default function Header() {
  const url = useLocation();
  
  return (
    <header className="fixed w-full h-16" style={{ backgroundColor: '#E5E5E5' }}>
    <div>
      {url.pathname.includes("login") && 
      <Link className=" flex justify-center mt-64" to="/login"><MainLogo width="576" height="122.032"/></Link>}
      {url.pathname.includes("sign-up") && 
      <Link className=" flex justify-center mt-14" to="/sign-up"><MainLogo width="231" height="49"/></Link>}
      {(!url.pathname.includes("sign-up") && !url.pathname.includes("login")) && 
      <Link className="flex w-fit mx-12 py-9" to="/"><MainLogo width="118" height="25" /></Link>}
    </div>
    </header>
  );
}
