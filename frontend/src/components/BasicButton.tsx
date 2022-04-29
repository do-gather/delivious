import React from "react";

/**
 * 기본 직사각형 버튼
 * @param buttonName 버튼에 들어갈 이름을 받음
 */
interface Props {
    buttonName: string;
}

export default function BasicButton(props: Props) {
    return (
        <div className='flex whitespace-nowrap items-center rounded text-base font-bold text-white text-center px-10 object-left-top h-10' style={{ backgroundColor: '#435ca5' }}>
            {props.buttonName}
        </div>
    );
}
