/* eslint-disable react/no-unused-prop-types */
/* eslint-disable react/require-default-props */
import React, { ReactElement, useEffect } from 'react';
import { Outlet, useNavigate } from 'react-router-dom';
import checkToken from './checkToken';
import useAuth from './store';

interface PrivateRouteProps {
  children?: ReactElement; // Router.tsx에서 PrivateRoute가 감싸고 있는 Componet Element
  authentication: boolean; // true :인증을 반드시 해야하만 접속가능, false : 인증을 반디스 안해야만 접속 가능
}

export function AuthRoute({ authentication }: PrivateRouteProps): React.ReactElement | null {
  const { removeAccess } = useAuth();
  const navigate = useNavigate();

  useEffect(() => {
    (async () => {
      const token = checkToken();
      if (!token && authentication) {
        navigate('/login');
        alert('로그인이 필요합니다.');
        removeAccess();
      }
    })();
  }, []);

  return <Outlet />;
}

export default AuthRoute;
