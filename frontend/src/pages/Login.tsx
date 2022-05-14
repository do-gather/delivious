import React from 'react';
import { Link } from 'react-router-dom';
import BasicButton from '../components/BasicButton';
import InputBox from '../components/InputBox';
import IdIcon from '../images/IdIcon';
import PasswordIcon from '../images/PasswordIcon';

/**
 * '/login'으로 연결되는 로그인 페이지
 */

export default function Login() {
  return (
    <div className="justify-center" style={{marginTop:"25.125rem"}}>      
      <div className="flex justify-center text-3xl font-bold" style={{paddingTop:"1.373rem"}} >
          관리자 로그인
      </div>
      <div className="flex justify-center" style={{ marginTop:"4.125rem"}}>
        <div style={{width:"30rem"}}>
          <div style={{paddingBottom:"0.51rem"}}>
            <InputBox placeholder="ID" icon={<IdIcon/>} iconLeft height="h-16" />
          </div>
          <div>
            <InputBox placeholder="Password" height="h-16" icon={<PasswordIcon/>} iconLeft/>
          </div>
          <div className="flex justify-center mt-8" style={{ fontSize:"0.875rem"}}>
            <div style={{paddingRight:"3.281rem"}}>
              <Link to="/sign-up">Create Account</Link>
            </div>
            <div style={{paddingLeft:"3.281rem"}}>
              <Link to="/">Contact Delivious</Link>
            </div>
          </div>
        </div>
        <div style={{width:"6.188rem", marginLeft:"0.938rem", marginTop:"0.25rem"}}>
          <BasicButton buttonName="Log in" onClick={()=>{console.log("click")}} height="h-36"/>
        </div>
      </div>
    </div>
  );
}
