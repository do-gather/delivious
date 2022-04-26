import React from "react";

/**
 * 검색 입력 창
 * @param placeholder 플레이스 홀더에 들어갈 말을 변수로 받음
 */
interface Props {
    placeholder: string;
}

export default function BasicButton(props: Props) {
    return (
        <div className='rounded text-sm text-center py-2.5 object-left-top h-10' style={{ backgroundColor: '#435ca5' }}>
            편집 완료
        </div>
    );
}
