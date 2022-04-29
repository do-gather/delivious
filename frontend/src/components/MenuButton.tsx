import React from "react";

/**
 * 기본 둥근 모서리 버튼 (메뉴 담는 과정에서 쓰임)
 * @param buttonName 버튼에 들어갈 이름을 받음
 */
interface Props {
    buttonName: string;
    textColor: string;
    bgColor: string;
}

export default function MenuButton(props: Props) {
    return (
        <div className={`flex whitespace-nowrap justify-center items-center rounded-3xl text-base text-center px-2 h-7 cursor-pointer ${props.textColor}`} style={{ backgroundColor: props.bgColor }}>
            {props.buttonName}
        </div>
    );
}
