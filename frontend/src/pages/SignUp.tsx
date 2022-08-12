import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import BasicButton from '../components/BasicButton';
import InputBox from '../components/InputBox';
import CheckBox from '../components/CheckBox';
import UserIcon from '../images/UserIcon';
import PasswordIcon from '../images/PasswordIcon';
import AuthService from '../services/AuthService';
import { dts } from '../utils/types';

/**
 * '/sign-up'로 연결되는 회원가입 페이지
 * admin의 경우 회원가입 즉시 로그인 처리 후 토큰을 받아 스토어 이름 등록 후 토큰 삭제
 */

export default function SignUp() {
  const navigate = useNavigate();
  const [admin, setAdmin] = useState(false);
  const [userInfo, setUserInfo] = useState<dts.userInfo>({
    username: '',
    password: '',
    passwordConfirm: '',
    name: '',
    phoneNum: '',
    year: '',
    month: '',
    date: '',
    type: 'user',
    storeName: '',
  });

  const sendUserInfo = (e: any) => {
    e.preventDefault();
    if (userInfo.password !== userInfo.passwordConfirm) {
      // eslint-disable-next-line no-alert
      alert('비밀번호가 일치하지 않습니다.');
      return;
    }
    const data = {
      username: userInfo.username,
      password: userInfo.password,
      name: userInfo.name,
      phoneNum: userInfo.phoneNum,
      birth: new Date(Number(userInfo.year), Number(userInfo.month), Number(userInfo.date)).toISOString().slice(0, 10),
      type: userInfo.type,
    };

    AuthService.register(data).then((res: any) => {
      if (res.status === 201) {
        if (userInfo.type === 'admin') {
          AuthService.login(userInfo.username, userInfo.password).then((response: any) => {
            if (response.status === 200) {
              const store = {
                userId: res.data.userId,
                storeName: userInfo.storeName,
              };
              window.localStorage.removeItem('adminToken');
              AuthService.store(store, response.data.token).then((storeres: any) => {
                if (storeres.status === 200) {
                  navigate('/login');
                }
              });
            }
          });
        } else {
          navigate('/mypage/login');
        }
      }
      return res;
    });
  };

  const handleChange = (e: any) => {
    const { name, value } = e.target;
    setUserInfo({ ...userInfo, [name]: value });
  };

  const changeAdmin = (checked: boolean) => {
    setUserInfo({ ...userInfo, type: checked ? 'admin' : 'user' });
    setAdmin(checked);
  };

  return (
    <div className="pt-40 px-4 mx-auto md:w-96 h-full">
      <div className="flex-col space-y-4 overflow-auto h-5/6">
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
          <button type="button" className="text-base font-bold" onClick={() => changeAdmin(!admin)}>
            {admin && <CheckBox label="관리자 회원가입" checked />}
            {!admin && <CheckBox label="관리자 회원가입" checked={false} />}
          </button>
          {admin && (
            <div>
              <div className="text-base font-bold">매장명</div>
              <InputBox placeholder="storeName" height="h-14" mode="dark" onChange={handleChange} />
            </div>
          )}
        </div>
        <div>
          <BasicButton buttonName="Sign Up" onClick={sendUserInfo} height="h-14" />
        </div>
      </div>
    </div>
  );
}
