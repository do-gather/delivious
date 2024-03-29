import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import BasicButton from '../components/BasicButton';
import InputBox from '../components/InputBox';
import UserIcon from '../images/UserIcon';
import PasswordIcon from '../images/PasswordIcon';
import AuthService from '../services/AuthService';
import { useAuth, useUserInfo } from '../utils/store';

/**
 * '/login' 또는 '/mypage/login' 으로 연결되는 로그인 페이지
 * url에 mypage 포함 여부에 따라 관리자 로그인 또는 일반 사용자 로그인으로 구분
 */

export default function Login() {
  const navigate = useNavigate();
  const type = window.location.pathname.includes('mypage') ? 'user' : 'admin';

  const [userInfo, setUserInfo] = useState({
    username: '',
    password: '',
  });

  const { setAccess } = useAuth();
  const { setStoreName, setUserId, setUserName, setUserType } = useUserInfo();

  const getStoreInfo = (username: string, token: string) => {
    AuthService.getStore(username, token).then((res: any) => {
      if (res.status === 200) {
        setStoreName(res.data.storeName);
        navigate('/');
      }
    });
  };

  const getInfo = (token: string) => {
    AuthService.getUserInfo(token, userInfo.username).then((userRes: any) => {
      setUserId(userRes.data?.id);
      setUserName(userInfo.username);
      setUserType(userRes.data?.type);
      if (type === 'user') navigate('/mypage');
    });
  };

  const handleChange = (e: any) => {
    const { name, value } = e.target;
    setUserInfo({ ...userInfo, [name]: value });
  };

  const sendUserInfo = (e: any) => {
    e.preventDefault();
    AuthService.login(userInfo.username, userInfo.password).then((res: any) => {
      if (res.status === 200) {
        setAccess(res.data.token);
        getInfo(res.data.token);
        if (type === 'admin') {
          getStoreInfo(userInfo.username, res.data.token);
        }
      }
    });
  };

  return (
    <div className="mx-auto pt-60 h-full px-4">
      <div className="flex-col justify-center h-4/5 overflow-auto">
        {type !== 'user' && <div className="w-full text-center text-3xl font-bold">관리자 로그인</div>}
        <div className="flex justify-center pt-12">
          <div className="flex-col space-y-4 pr-4" style={{ width: '30rem' }}>
            <InputBox
              text={userInfo.username}
              onChange={handleChange}
              placeholder="username"
              icon={<UserIcon />}
              iconLeft
              height="h-16"
            />
            <InputBox
              text={userInfo.username}
              onChange={handleChange}
              placeholder="password"
              height="h-16"
              icon={<PasswordIcon />}
              iconLeft
            />
            <div className="flex whitespace-nowrap justify-between space-x-16 pt-1.5" style={{ fontSize: '0.875rem' }}>
              <Link to="/sign-up">Create Account</Link>
              {type === 'user' ? (
                <Link to="/login">관리자 모드 로그인</Link>
              ) : (
                <Link to="/mypage/login">일반 사용자 로그인</Link>
              )}
            </div>
          </div>
          <div className="w-24">
            <BasicButton buttonName="Log in" onClick={sendUserInfo} height="h-36" />
          </div>
        </div>
      </div>
    </div>
  );
}
