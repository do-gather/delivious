import React from 'react';
import BasicButton from './BasicButton';

/**
 * 어드민 로그인 모달 창
 * @param onClose 닫힘 버튼을 누를 때 실행될 함수 받음
 */
interface Props {
  onClose: any;
}

export default function AdminLoginModal({ onClose }: Props) {
  return (
    <div
      className="absolute w-full h-screen top-0 -left-16 z-50"
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
        <button className="w-full flex justify-end text-right font-extrabold" type="button" onClick={onClose}>
          X
        </button>
        <div className="px-52 py-16 w-full flex flex-col justify-center">
          <div>매장명</div>
          <div className="border-b-0" />
          <div>스타벅스 강남R점</div>
          <div>비밀번호</div>
          <input className=" placeholder-slate-200 bg-black" placeholder="Password" />
          <div>해당 매장번호의 관리자 비밀번호를 입력해주세요.</div>
          <BasicButton buttonName="관리자 모드 시작하기" />
        </div>
      </div>
    </div>
  );
}
