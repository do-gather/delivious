import React from "react";
import CheckBox from "./CheckBox.tsx";
import EditBox from "./EditBox.tsx";

/**
 * 어드민 메뉴 목록의 각 아이템
 * @param props 메뉴안에 들어갈 각 항목을 아래 인터페이스 형태로 묶어서 받음
 */
interface Props {
    props: {
        category: string;
        id: string;
        name: string;
        temp: string;
        size: string;
        price: string;
        date: string;
    }
    type?: string;
}

export default function AdminMenuItem({ props, type = "" }: Props) {

    return (
        <div className="grid grid-cols-7 px-10 gap-4 py-6 justify-between whitespace-nowrap text-center items-center text-base">
            {type === 'edit' ? <EditBox placeholder="카테고리" text={props.category} /> : <div>{props.category}</div>}
            <div>{props.id}</div>
            {type === 'edit' ? <EditBox placeholder="메뉴 이름" text={props.name} /> : <div>{props.name}</div>}
            {type === 'edit' ?
                <div className="flex justify-center space-x-3">
                    <CheckBox label="Hot" checked={true} />
                    <CheckBox label="Ice" checked={true} />
                </div> :
                <div>{props.temp}</div>}
            {type === 'edit' ?
                <div className="flex-col justify-center space-y-1">
                    <CheckBox label="Tall" checked={true} />
                    <CheckBox label="Grande" checked={true} />
                    <CheckBox label="Venti" checked={true} />
                </div> :
                <div>{props.size}</div>}
            {type === 'edit' ? <EditBox placeholder="가격" text={props.price} /> : <div>{props.price}</div>}
            <div>{props.date}</div>
        </div>
    );
}
