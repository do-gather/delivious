import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import BasicButton from './BasicButton';
import InputBox from './InputBox';
import PasswordIcon from '../images/PasswordIcon';

/**
 * 어드민 로그인 모달 창
 * @param onClose 닫힘 버튼을 누를 때 실행될 함수 받음
 */
interface Props {
  onClose: any;
}

export default function AdminLoginModal({ onClose }: Props) {
  const navigate = useNavigate();
  const [move, setMove] = useState(false);

  useEffect(() => {
    if (move) navigate('/admin');
  }, [move, navigate]);

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
        <div className="px-52 pt-10 pb-16 w-full flex flex-col text-center whitespace-nowrap font-bold text-xl">
          <div>매장명</div>
          <div className="border-b my-3 w-full border-zinc-300" />
          <div>스타벅스 강남R점</div>

          <div className="w-full text-xs text-left my-8 place-self-center">
            <div className="pl-1">비밀번호</div>
            <InputBox placeholder="Password" icon={<PasswordIcon width={15} height={15} />} mode="dark" />
            <div className="pl-1 pr-3">해당 매장의 관리자 비밀번호를 입력해주세요.</div>
          </div>

          <div className="px-4 place-self-center">
            <BasicButton
              buttonName="관리자 모드 시작하기"
              onClick={() => {
                setMove(true);
              }}
            />
          </div>
        </div>
      </div>
    </div>
  );
}
