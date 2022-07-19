import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import useAuth from '../utils/store';
import AuthService from '../services/AuthService';
import BasicButton from './BasicButton';

/**
 * 로그아웃 모달 창
 * @param onClose 닫힘 버튼을 누를 때 실행될 함수 받음
 */
interface Props {
  onClose: any;
}

export default function LogoutModal({ onClose }: Props) {
  const navigate = useNavigate();
  const [move, setMove] = useState(false);
  const d = new Date();
  const { removeAccess } = useAuth();
  const url = window.location.pathname.includes('mypage') ? '/mypage/login' : '/login';

  useEffect(() => {
    if (move) navigate(url);
  }, [move, navigate, url]);

  return (
    <div
      className="w-full h-screen top-0 z-50"
      style={{ backgroundColor: 'rgba(1,1,1,0.5)', position: 'fixed', overflow: 'hidden' }}
    >
      <div
        className="rounded"
        style={{
          backgroundColor: '#f0f0f0',
          position: 'absolute',
          top: '50%',
          left: '50%',
          transform: 'translate(-50%, -50%)',
        }}
      >
        <button
          className="w-fit float-right my-3 mr-6 text-gray-600 hover:text-red-600"
          type="button"
          onClick={onClose}
        >
          close
        </button>
        <div
          className="px-4 md:px-44 pt-10 pb-24 w-full 
        flex flex-col text-center whitespace-nowrap text-2xl space-y-3"
        >
          {d.toLocaleDateString()}
          &nbsp; &nbsp;
          {d.toLocaleTimeString()}
          <div className="pt-4 pb-12">로그아웃 하시겠습니까? </div>
          <BasicButton
            buttonName="로그아웃"
            onClick={() => {
              removeAccess();
              AuthService.logout();
              setMove(true);
            }}
          />
          <BasicButton buttonName="취소" onClick={() => onClose()} />
        </div>
      </div>
    </div>
  );
}
