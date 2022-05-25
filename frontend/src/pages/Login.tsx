import React from 'react';
import { Link } from 'react-router-dom';
import BasicButton from '../components/BasicButton';
import InputBox from '../components/InputBox';
import UserIcon from '../images/UserIcon';
import PasswordIcon from '../images/PasswordIcon';

/**
 * '/login'으로 연결되는 로그인 페이지
 */

export default function Login() {

  return (
    <div className="flex-col justify-center" style={{marginTop:"25.125rem"}}>
      <div className="w-full text-center text-3xl font-bold" style={{paddingTop:"1.373rem"}}>
        관리자 로그인
      </div>
      <div className="flex justify-center pt-16">
        <div className="flex-col space-y-4 pr-4" style={{width:"30rem"}}>
          <InputBox placeholder="ID" icon={<UserIcon/>} iconLeft height="h-16" />
          <InputBox placeholder="Password" height="h-16" icon={<PasswordIcon/>} iconLeft/>
          <div className="flex justify-center space-x-32 pt-1.5"  style={{ fontSize:"0.875rem"}}>
            <Link to="/sign-up">Create Account</Link>
            <Link to="/">Contact Delivious</Link>
          </div>
        </div>
        <BasicButton buttonName="Log in" onClick={()=>{console.log("click")}} height="h-36"/>
      </div>
    </div>
  )
}
