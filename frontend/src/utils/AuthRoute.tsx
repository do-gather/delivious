/* eslint-disable react/no-unused-prop-types */
/* eslint-disable react/require-default-props */
import React, { ReactElement, useEffect } from 'react';
import { Outlet, useNavigate } from 'react-router-dom';
import checkToken from './checkToken';
import useAuth from './store';
import { dts } from './types';

/**
 * 라우터를 감싸는 권한 확인을 위한 컴포넌트
 * @param authentication
 */

export function AuthRoute(): ReactElement | null {
  const { removeAccess } = useAuth();
  const navigate = useNavigate();
  const url = window.location.pathname;

  useEffect(() => {
    (async () => {
      const token: dts.tokenDto = checkToken();
      if (!token.activation && url.includes('/admin')) {
        navigate('/login');
        alert('로그인이 필요합니다.');
        removeAccess();
      } else if (!token.activation) {
        navigate('/mypage/login');
        alert('로그인이 필요합니다.');
        removeAccess();
      } else if (token.activation && token.type === 'user' && url.includes('/admin')) {
        navigate('/admin');
        alert('관리자만 접근 가능합니다.');
        removeAccess();
      }
    })();
  }, []);
  return <Outlet />;
}

export default AuthRoute;
