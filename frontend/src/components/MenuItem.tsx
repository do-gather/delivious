import React, { useState } from "react";
import getYmd10 from "../utils/utils.tsx";
import TestImage from "../images/menu_test.png";

/**
 * 사용자 메뉴 목록의 각 아이템
 * 
 * @param props 메뉴안에 들어갈 각 항목을 아래 인터페이스 형태로 묶어서 받음
 * @param type 아이템이 수정 상태인지 아닌지 입력, 기본은 'display'. 수정 시 'edit'을 전달. 새로 추가 시 'new' 전달. 전달하지 않으면 'display'로 초기화 됨
 */
interface Props {
    props?: {
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

export default function MenuItem({ props, type = 'display' }: Props) {
    const [currentDate, setCurrentDate] = useState(getYmd10())
    const [menu, setMenu] = useState(props ? props : props = {
        category: '',
        id: '-',
        name: '',
        temp: '',
        size: '',
        price: '',
        date: '',
    })

    const handleChecked = (keyword: string, label: string) => {
        return keyword.includes(label)
    };

    return (
        <div className="text-center text-base w-36">
            <div className="w-36 h-36 bg-white whitespace-nowrap items-center px-10 cursor-pointer"
                style={{}}>
                <img className="m-auto" alt='test-menu' src={TestImage}></img>
            </div>
            <div>{props.name}</div>
        </div >
    );
}
