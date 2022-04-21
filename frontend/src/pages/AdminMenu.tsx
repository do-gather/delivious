import React from "react";

export default function AdminMenu() {
    return (
        <div className="w-full h-screen">
            <div>메뉴관리 및 검색바</div>
            <div className="flex mx-14 justify-between whitespace-nowrap text-white" style={{ backgroundColor: "#435CA5" }}>
                <div>Category</div>
                <div>ID</div>
                <div>Name</div>
                <div>Ice/Hot</div>
                <div>Size</div>
                <div>Price</div>
                <div>Date</div>
            </div>
        </div>
    );
}
