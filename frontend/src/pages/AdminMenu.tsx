import React from "react";
import AdminMenuItem from "../components/AdminMenuItem.tsx";
import constants from "../utils/constants.ts";

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
        </div>
    );
}
