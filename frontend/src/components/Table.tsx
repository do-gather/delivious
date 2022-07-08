/* eslint-disable @typescript-eslint/no-explicit-any */
/* eslint-disable react/require-default-props */
import React from 'react';

/**
 * 어드민 페이지 오른쪽 사이드 버튼
 * @param TableNumber 테이블에 세겨진 번호
 * @param color 테이블 색상
 */
interface Props {
  TableNumber: number;
  state?: string;
  icon?: any;
  history?: string;
}

export default function Table({ TableNumber, state, icon, history }: Props) {
  return (
    <div>
      {/* {state === 'ready' && <div style={{ backgroundColor: '#435ca5' }} />}
      {state === 'done' && <div style={{ backgroundColor: '#adbdd4' }} />}
      {state !== 'ready' && state !== 'done' && <div style={{ backgroundColor: '#c4c4c4' }} />} */}
      <div
        className={`w-32 h-32 mx-8 flex-shrink-0 text-white px-2 py-2
          text-base rounded`}
        style={{ background: state === 'ready' ? '#435ca5' : '#adbdd4' }}
      >
        <div className="flex">
          {TableNumber}
          <div className="mx-2 pl-16">{icon}</div>
        </div>
        <div className="text-white text-xs py-12">{history}</div>
      </div>
    </div>
  );
}
