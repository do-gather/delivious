import React from "react";
import Logo from "../images/delivious_logo.png";
import { Link } from 'react-router-dom';

/**
 * 로고가 위치하는 헤더 컴포넌트
 * 추후, url을 읽어서 페이지에 맞는 로고로 변형되도록 구현
 */

export default function Header() {
    return (
        <>
            <div>
                <Link className="w-28" to='/'>
                    <img className="mx-14 py-9 w-28" alt='main-logo' src={Logo}></img>
                </Link>
            </div>
        </>);
}
