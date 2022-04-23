import React from "react";
import AdminMenuItem from "../components/AdminMenuItem.tsx";
import constants from "../utils/constants.ts";
import EditButton from "../images/EditButton.tsx";
import SideButton from "../components/SideButton.tsx";
import { Link } from 'react-router-dom';

/**
 * '/admin/menu'로 연결되는 어드민 메뉴 페이지
 * 메뉴 리스트를 보여주고 수정 및 검색이 가능
 */

function Divider() {
    return (
        <div className="border-b w-full" style={{ borderColor: "#c4c4c4" }}></div>
    );
}

export default function AdminMenu() {
    return (
        <div className="w-full h-screen px-14">
            <div className="font-bold text-3xl pb-9">메뉴관리</div>
            <div className="grid grid-cols-7 gap-4 px-10 justify-between font-semibold whitespace-nowrap text-white h-12 text-center items-center text-2xl" style={{ backgroundColor: "#435CA5" }}>
                <div>Category</div>
                <div>ID</div>
                <div>Name</div>
                <div>Ice/Hot</div>
                <div>Size</div>
                <div>Price</div>
                <div>Date</div>
            </div>
            {constants.MENU_ITEMS.map((menu, index) => (
                <div key={index}>
                    <AdminMenuItem props={menu} />
                    <Divider />
                </div>
            ))}
            <div className="flex-col space-y-8 fixed right-0 top-14">
                <SideButton color="#000000" name="주문하기" link="/" />
                <SideButton color="#435ca5" name="관리페이지" link="/admin" />
            </div>
            <Link className="fixed left-11 bottom-11" to='/admin/menu/edit'>
                <EditButton />
            </Link>
        </div>
    );
}
