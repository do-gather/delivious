import React, { useState } from "react";
import getYmd10 from "../utils/utils.tsx";
import AddCheck from "../images/AddCheck.tsx";
import MenuButton from "./MenuButton.tsx";

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
        <div className="text-center text-xs w-36">
            <div className={`w-36 h-36 bg-white whitespace-nowrap items-center ${type === "display" && "cursor-pointer"} bg-contain bg-center`}
                style={{ backgroundImage: "url(https://myauto.shinhancard.com/conts/images/event/evt_181001_02_gift04.png)" }} >
                {type === "temp" && <div className="flex justify-center items-center space-x-2 bg-zinc-500/50 w-full h-full">
                    <MenuButton buttonName="Hot" textColor="text-black" bgColor="#ffffff" />
                    <MenuButton buttonName="Ice" textColor="text-black" bgColor="#ffffff" />
                </div>}
                {type === "size" && <div className="flex flex-col justify-center items-center space-y-3.5 bg-zinc-500/50 w-full h-full">
                    <MenuButton buttonName="Tall" textColor="text-black" bgColor="#ffffff" />
                    <MenuButton buttonName="Grande" textColor="text-black" bgColor="#ffffff" />
                    <MenuButton buttonName="Venti" textColor="text-black" bgColor="#ffffff" />
                </div>}
                {type === "add" && <div className="flex justify-center items-center bg-zinc-500/50 w-full h-full">
                    <AddCheck />
                </div>}
            </div>
            <div className="mt-3">{props.name}</div>
        </div >
    );
}
