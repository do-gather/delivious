import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import BasicButton from '../components/BasicButton';
import InputBox from '../components/InputBox';
import UserIcon from '../images/UserIcon';
import PasswordIcon from '../images/PasswordIcon';
import AuthService from '../services/AuthService';

/**
 * '/login'으로 연결되는 로그인 페이지
 */

export default function Login() {
  const navigate = useNavigate();
  // const [admin, setAdmin] = useState(false);
  const [userInfo, setUserInfo] = useState({
    username: '',
    password: '',
    type: 'user',
  });

  const handleChange = (e: any) => {
    const { name, value } = e.target;
    setUserInfo({ ...userInfo, [name]: value });
  };

  const sendUserInfo = (e: any) => {
    e.preventDefault();

    AuthService.login(userInfo.username, userInfo.password).then((res: any) => {
      console.log(res);
      if (res.status === 200) {
        console.log(res.data);
        navigate('/');
      }
    });
  };

  return (
    <div className="flex-col justify-center px-4" style={{ marginTop: '25.125rem' }}>
      <div className="w-full text-center text-3xl font-bold" style={{ paddingTop: '1.373rem' }}>
        관리자 로그인
      </div>
      <div className="flex justify-center pt-16">
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
          <div className="flex justify-center space-x-32 pt-1.5" style={{ fontSize: '0.875rem' }}>
            <Link to="/sign-up">Create Account</Link>
            <Link to="/">Contact Delivious</Link>
          </div>
        </div>
        <BasicButton buttonName="Log in" onClick={sendUserInfo} height="h-36" />
      </div>
    </div>
  );
}
