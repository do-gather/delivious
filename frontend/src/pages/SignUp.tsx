import React, { useState } from "react";
import BasicButton from "../components/BasicButton";
import InputBox from "../components/InputBox";
import CheckBox from "../components/CheckBox";
import UserIcon from "../images/UserIcon";
import PasswordIcon from "../images/PasswordIcon";

/**
 * '/sign-up'로 연결되는 회원가입 페이지
 */

export default function SignUp() {
  const [admin, setAdmin] = useState(false);
  
  return(
    <div className="flex justify-center mt-36">
      <div className="flex-col space-y-4">
        <div>
          <div className="text-base font-bold">아이디</div>
          <InputBox placeholder="ID" height="h-14" mode="dark" icon={<UserIcon/>}/>
        </div>
        <div>
          <div className="text-base font-bold">비밀번호</div>
          <InputBox placeholder="Password" height="h-14" mode="dark" icon={<PasswordIcon/>}/>
        </div>
        <div>
          <div className="text-base font-bold">비밀번호 재확인</div>
          <InputBox placeholder="Password Confirm" height="h-14" mode="dark"/>
        </div>
        <div>
          <div className="text-base font-bold">이름</div>
          <InputBox placeholder="Name" height="h-14" mode="dark"/>
        </div>
        <div>
          <div className="text-base font-bold">생년월일</div>
          <div className="flex justify-center space-x-2">
            <InputBox placeholder="Year" height="h-14" mode="dark"/>
            <InputBox placeholder="Month" height="h-14" mode="dark"/>
            <InputBox placeholder="Date" height="h-14" mode="dark"/>
          </div>
        </div>
        <div>
          <div className="text-base font-bold">휴대전화</div>
          <InputBox placeholder="Phone Number" height="h-14" mode="dark"/>
        </div>
        <div>
          <button type="button" className="text-base font-bold" onClick={()=>setAdmin(!admin)}>
            <CheckBox label="관리자 회원가입" checked={admin}/>
          </button>
          {admin && <div>
            <div className="text-base font-bold">매장명</div>
            <InputBox placeholder="Store Name" height="h-14"mode="dark"/>
          </div>}
        </div>
        <div>
          <BasicButton buttonName="Sign Up" onClick={()=>{console.log("signup")}} height="h-14" xPadding="w-full" />
        </div>
      </div>
    </div>
  );
}
