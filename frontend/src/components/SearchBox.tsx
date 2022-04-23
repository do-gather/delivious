import React from "react";
import SearchIcon from "../images/SearchIcon.tsx";

/**
 * 어드민 메뉴 목록의 각 아이템
 * @param placeholder 메뉴안에 들어갈 각 항목을 아래 인터페이스 형태로 묶어서 받음
 */
interface Props {
    placeholder: string;
}

export default function SearchBox(props: Props) {
    return (
        <div className={`relative h-10`} style={{ width: "28.75rem" }}>
            <div className="absolute left-3.5 top-3">
                <SearchIcon />
            </div>
            <input
                type="text"
                className={`rounded-3xl bg-white pl-10 text-sm placeholder-gray-500 py-2.5 object-left-top h-10`} style={{ width: "28.75rem" }}
                placeholder={props.placeholder}
            />
        </div>
    );
}
