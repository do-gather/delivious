import React, { useState } from 'react';
import BasicButton from '../components/BasicButton';
import InputBox from '../components/InputBox';
import CheckBox from '../components/CheckBox';
import UserIcon from '../images/UserIcon';
import PasswordIcon from '../images/PasswordIcon';

/**
 * '/sign-up'로 연결되는 회원가입 페이지
 */

export default function SignUp() {
  const [admin, setAdmin] = useState(false);
  const [userInfo, setUserInfo] = useState({
    username: '',
    password: '',
    passwordConfirm: '',
    name: '',
    phoneNum: '',
    year: '',
    month: '',
    date: '',
    type: 'USER',
  });

  const handleChange = (e: any) => {
    const { name, value } = e.target;
    setUserInfo({ ...userInfo, [name]: value });
    console.log(userInfo);
  };

  return (
    <div className="flex justify-center mt-36">
      <div className="flex-col space-y-4">
        <div>
          <div className="text-base font-bold">아이디</div>
          <InputBox
            text={userInfo.username}
            onChange={handleChange}
            placeholder="username"
            height="h-14"
            mode="dark"
            icon={<UserIcon />}
          />
        </div>
        <div>
          <div className="text-base font-bold">비밀번호</div>
          <InputBox
            text={userInfo.password}
            onChange={handleChange}
            placeholder="password"
            height="h-14"
            mode="dark"
            icon={<PasswordIcon />}
          />
        </div>
        <div>
          <div className="text-base font-bold">비밀번호 재확인</div>
          <InputBox
            text={userInfo.passwordConfirm}
            onChange={handleChange}
            placeholder="passwordConfirm"
            height="h-14"
            mode="dark"
          />
        </div>
        <div>
          <div className="text-base font-bold">이름</div>
          <InputBox text={userInfo.name} onChange={handleChange} placeholder="name" height="h-14" mode="dark" />
        </div>
        <div>
          <div className="text-base font-bold">생년월일</div>
          <div className="flex justify-center space-x-2">
            <InputBox text={userInfo.year} onChange={handleChange} placeholder="year" height="h-14" mode="dark" />
            <InputBox text={userInfo.month} onChange={handleChange} placeholder="month" height="h-14" mode="dark" />
            <InputBox text={userInfo.date} onChange={handleChange} placeholder="date" height="h-14" mode="dark" />
          </div>
        </div>
        <div>
          <div className="text-base font-bold">휴대전화</div>
          <InputBox text={userInfo.phoneNum} onChange={handleChange} placeholder="phoneNum" height="h-14" mode="dark" />
        </div>
        <div>
          <button
            type="button"
            className="text-base font-bold"
            onClick={() => {
              setAdmin(!admin);
              setUserInfo({ ...userInfo, type: admin ? 'ADMIN' : 'USER' });
            }}
          >
            <CheckBox label="관리자 회원가입" checked={admin} />
          </button>
          {admin && (
            <div>
              <div className="text-base font-bold">매장명</div>
              <InputBox placeholder="Store Name" height="h-14" mode="dark" />
            </div>
          )}
        </div>
        <div>
          <BasicButton
            buttonName="Sign Up"
            onClick={() => {
              console.log('signup');
            }}
            height="h-14"
            xPadding="w-full"
          />
        </div>
      </div>
    </div>
  );
}
