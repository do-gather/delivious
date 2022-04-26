import React, { useState } from "react";

/**
 * 중복 체크 가능한 check box
 * @param checked 현재 체크가 된 상태인지를 받음
 * @param label 체크 박스 옆에 표시될 이름
 */
interface Props {
    checked?: boolean;
    label: string;
}

export default function CheckBox({ checked = false, label }: Props) {
    const [mark, setMark] = useState(checked);

    const handleMarkChange = () => {
        setMark(!mark)
    };

    return (
        <div className="flex items-center">
            <input
                type="checkbox"
                className={`cursor-pointer mr-1 w-5 h-5 bg-white shadow-none outline-none`}
                checked={mark}
                onChange={handleMarkChange}
            />
            <label className="text-left text-base">
                {label}
            </label>
        </div>
    );
}
