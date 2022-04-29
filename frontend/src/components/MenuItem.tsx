import React, { useState } from "react";
import getYmd10 from "../utils/utils.tsx";
import AddCheck from "../images/AddCheck.tsx";
import PillButton from "./PillButton.tsx";

/**
 * 사용자 메뉴 목록의 각 아이템
 * 
 * @param props 메뉴안에 들어갈 각 항목을 아래 인터페이스 형태로 묶어서 받음
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
}

export default function MenuItem({ props }: Props) {
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
    const [step, setStep] = useState(0)

    // 메뉴에 있는 옵션만 화면에 보여주기 위한 함수
    const handleCheckLabel = (keyword: string, label: string) => {
        return keyword.includes(label)
    };

    const handleClicked = () => {
        if (step === 3)
            setStep(0)
        else
            setStep(step + 1)
    }

    return (
        <div className="text-center text-xs w-36">
            {step === 0 ? <div className={`w-36 h-36 bg-white whitespace-nowrap items-center cursor-pointer bg-contain bg-center`}
                style={{ backgroundImage: "url(https://myauto.shinhancard.com/conts/images/event/evt_181001_02_gift04.png)" }}
                onClick={handleClicked}> </div> :
                <div className={`w-36 h-36 bg-white whitespace-nowrap items-center bg-contain bg-center`}
                    style={{ backgroundImage: "url(https://myauto.shinhancard.com/conts/images/event/evt_181001_02_gift04.png)" }}
                >
                    {step === 1 && <div className="flex justify-center items-center space-x-2 bg-zinc-500/50 w-full h-full" >
                        {handleCheckLabel(props.temp, "Hot") && <PillButton buttonTitle="Hot" activeColor="active:bg-rose-900" onClick={handleClicked} />}
                        {handleCheckLabel(props.temp, "Ice") && <PillButton buttonTitle="Ice" activeColor="active:bg-indigo-800" onClick={handleClicked} />}
                    </div>}
                    {step === 2 && <div className="flex flex-col justify-center items-center space-y-3.5 bg-zinc-500/50 w-full h-full">
                        {handleCheckLabel(props.size, "Tall") && <PillButton buttonTitle="Tall" onClick={handleClicked} />}
                        {handleCheckLabel(props.size, "Grande") && <PillButton buttonTitle="Grande" onClick={handleClicked} />}
                        {handleCheckLabel(props.size, "Venti") && <PillButton buttonTitle="Venti" onClick={handleClicked} />}
                    </div>}
                    {step === 3 && <div className="flex justify-center items-center bg-zinc-500/50 w-full h-full" onClick={handleClicked}>
                        <AddCheck />
                    </div>}
                </div>}
            <div className="mt-3">{props.name}</div>
        </div >
    );
}
