import React, { useState } from "react";

/**
 * 메뉴 수정 시 input box
 * @param placeholder 플레이스 홀더에 들어갈 말을 변수로 받음
 * @param text input box에 채워져 있어야 할 텍스트를 변수로 받음
 */
interface Props {
    placeholder: string;
    text?: string;
}

export default function EditBox({ placeholder, text = '' }: Props) {
    const [value, setValue] = useState(text);

    const handleTextChange = (e: any) => {
        setValue(e.target.value)
    };

    return (
        <input
            type="text"
            className={`bg-white text-base text-center placeholder-gray-500 py-2.5 h-10 w-36`}
            placeholder={placeholder}
            value={value}
            onChange={handleTextChange}
        />
    );
}
