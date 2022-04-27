import React from "react";
import MenuItem from "../components/MenuItem.tsx";
import constants from "../utils/constants.ts";
import EditButton from "../images/EditButton.tsx";
import SearchBar from "../components/SearchBar.tsx";
import Tap from "../components/Tap.tsx";
import { Link } from 'react-router-dom';

/**
 * '/'로 연결되는 메인 페이지
 * 사용자가 보는 메뉴 목록 및 장바구니
 */

function Divider() {
    return (
        <div className="border-b w-full" style={{ borderColor: "#c4c4c4" }}></div>
    );
}

export default function Main() {
    return (
        <div>
            <div className="w-full h-screen pl-14 pr-32">
                <div className="flex space-x-2 items-center pb-5 text-left whitespace-nowrap">
                    <div className="font-bold text-xl">Menu</div>
                    <div className="text-sm"> /커피</div>
                </div>
                <div className="text-base font-bold">Ice coffee</div>
                <Divider />
                <div className="grid grid-cols-4 pt-5">
                    {constants.MENU_ITEMS.map((menu, index) => (
                        <MenuItem props={menu} key={index} />
                    ))}
                </div>

                <Link className="fixed left-11 bottom-11" to='/admin/menu/edit'>
                    <EditButton />
                </Link>
            </div>
            <div className="flex fixed right-0 top-16">
                <Tap color="#435ca5" name="주문하기" link="/" />
                <div className="w-64 min-h-screen bg-white"></div>
            </div>
        </div>);
}
