import React, { useState } from "react";
import BasicButton from "../components/BasicButton";
import InputBox from "../components/InputBox";
import CheckBox from "../components/CheckBox";
import IdIcon from "../images/IdIcon";
import PasswordIcon from "../images/PasswordIcon";

/**
 * '/sign-up'로 연결되는 회원가입 페이지
 */

export default function SignUp() {
  const [admin, setAdmin] = useState(false);
  
  return(
    <div>
      <div className="flex justify-center">
        <div style={{ marginTop:"3.75rem", width:"30.062rem"}}>
          <div style={{ marginTop:"3.566rem", paddingBottom:"0.562rem"}}>
              <div className="text-base font-bold">아이디</div>
              <InputBox placeholder="ID" height="h-14" mode="dark" icon={<IdIcon/>}/>
          </div>
          <div style={{ marginTop:"0.5rem", paddingBottom:"0.562rem"}}>
              <div className="text-base font-bold">비밀번호</div>
              <InputBox placeholder="Password" height="h-14" mode="dark" icon={<PasswordIcon/>}/>
          </div>
          <div style={{ marginTop:"0.5rem", paddingBottom:"0.562rem"}}>
              <div className="text-base font-bold">비밀번호 재확인</div>
              <InputBox placeholder="Password Confirm" height="h-14" mode="dark"/>
          </div>
          <div style={{ marginTop:"0.5rem", paddingBottom:"0.562rem"}}>
              <div className="text-base font-bold">이름</div>
              <InputBox placeholder="Name" height="h-14" mode="dark"/>
          </div>
          <div style={{ marginTop:"0.5rem", paddingBottom:"0.562rem"}}>
              <div className="text-base font-bold">생년월일</div>
              <div className="flex justify-center space-x-2">
                <InputBox placeholder="Year" height="h-14" mode="dark"/>
                <InputBox placeholder="Month" height="h-14" mode="dark"/>
                <InputBox placeholder="Date" height="h-14" mode="dark"/>
              </div>
          </div>
          <div style={{ marginTop:"0.5rem", paddingBottom:"0.562rem"}}>
              <div className="text-base font-bold">휴대전화</div>
              <InputBox placeholder="Phone Number" height="h-14" mode="dark"/>
          </div>
          <button type="button" style={{ marginTop:"0.5rem", paddingBottom:"0.562rem"}} 
            className="text-base font-bold" onClick={()=>setAdmin(!admin)}>
              <CheckBox label="관리자 회원가입" checked={admin}/>
          </button>
          {admin && <div style={{ marginTop:"0.5rem", paddingBottom:"0.562rem"}}>
              <div className="text-base font-bold">매장명</div>
              <InputBox placeholder="Store Name" height="h-14"mode="dark"/>
          </div>}
          <div style={{ marginTop:"0.5rem", paddingBottom:"0.562rem", width:"30.062rem", display:"center"}}>
              <BasicButton buttonName="Sign Up" onClick={()=>{console.log("signup")}} height="h-14" xPadding="w-full" />
          </div>
        </div>
      </div>
    </div>
  );
}
