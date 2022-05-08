import React from 'react';
import BasicButton from '../components/BasicButton';
import MainLogo from '../images/MainLogo';

/**
 * '/ligin'으로 연결되는 로그인 페이지
 */

export default function Login() {
  return (
    <div>
      <div className='flex justify-center'>
        <div className="flex justify-center mt-64">
          <MainLogo width='576' height='122.016'/>
        </div>
      </div>
      
      <div className='flex justify-center'>
        <div className="flex justify-center text-3xl font-bold" style={{paddingTop:"1.373rem"}} >관리자 로그인</div>
      </div>
      <div className='flex justify-center'>
        <div>
          <BasicButton buttonName='Log in'/>
        </div>
      </div>
    </div>
  );
}
