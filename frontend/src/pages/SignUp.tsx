import React from "react";
import MainLogo from "../images/MainLogo";
import BasicButton from "../components/BasicButton";
import CheckBox from "../components/CheckBox";

export default function SignUp() {
  return(
    <div>
      <div className="flex justify-center">
        <div style={{ marginTop:"3.75rem"}}>
          <div className="mt-">
            <MainLogo/>
          </div>
          <div style={{ marginTop:"3.566rem", paddingBottom:"0.562rem"}}>
              <div className="text-base font-bold">아이디</div>
          </div>
          <div style={{ marginTop:"0.75rem", paddingBottom:"0.562rem"}}>
              <div className="text-base font-bold">비밀번호</div>
          </div>
          <div style={{ marginTop:"0.75rem", paddingBottom:"0.562rem"}}>
              <div className="text-base font-bold">비밀번호 재확인</div>
          </div>
          <div style={{ marginTop:"0.75rem", paddingBottom:"0.562rem"}}>
              <div className="text-base font-bold">이름</div>
          </div>
          <div style={{ marginTop:"0.75rem", paddingBottom:"0.562rem"}}>
              <div className="text-base font-bold">생년월일</div>
          </div>
          <div style={{ marginTop:"0.75rem", paddingBottom:"0.562rem"}}>
              <div className="text-base font-bold">휴대전화</div>
          </div>
          <div style={{ marginTop:"0.75rem", paddingBottom:"0.562rem"}} className="text-base font-bold">
              <CheckBox label="관리자 회원가입" />
          </div>
          <div style={{ marginTop:"0.75rem", paddingBottom:"0.562rem"}}>
              <div className="text-base font-bold">매장명</div>
          </div>
          <div style={{ marginTop:"0.75rem", paddingBottom:"0.562rem"}}>
              <BasicButton buttonName="Sign Up"/>
          </div>
        </div>
      </div>
    </div>
  );
}
