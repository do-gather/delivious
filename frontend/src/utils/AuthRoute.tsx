/* eslint-disable react/no-unused-prop-types */
/* eslint-disable react/require-default-props */
import React, { ReactElement, useEffect } from 'react';
import { Outlet, useNavigate } from 'react-router-dom';
import checkToken from './checkToken';
import useAuth from './store';
import { dts } from './types';

/**
 * 라우터를 감싸는 권한 확인을 위한 컴포넌트
 * @param pageType 페이지 타입에 따라 접근 가능한 유저를 구분하기 위해 string으로 페이지 타입을 받음
 * 권한 없을 시 알맞은 알림 및 페이지 이동
 */

interface Props {
  pageType: string;
}

export function AuthRoute({ pageType }: Props): ReactElement | null {
  const { removeAccess } = useAuth();
  const navigate = useNavigate();

  useEffect(() => {
    (async () => {
      const token: dts.tokenDto = checkToken();
      if (!token.activation && pageType === 'admin') {
        navigate('/login');
        alert('로그인이 필요합니다.');
        removeAccess();
      } else if (!token.activation) {
        navigate('/mypage/login');
        alert('로그인이 필요합니다.');
        removeAccess();
      } else if (token.activation && token.type === 'user' && pageType === 'admin') {
        navigate('/login');
        alert('관리자만 접근 가능합니다.');
        removeAccess();
      } else if (token.activation && token.type === 'admin' && pageType === 'user') {
        navigate('/mypage/login');
        alert('일반 사용자 계정으로만 접근 가능합니다.');
        removeAccess();
      }
    })();
  }, []);
  return <Outlet />;
}

export default AuthRoute;
