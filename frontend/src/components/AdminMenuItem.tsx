import React from "react";

interface Props {
    category: string;
    id: string;
    name: string;
    temp: string;
    size: string;
    price: string;
    date: string;
}

export default function AdminMenuItem(props: Props) {
    return (
        <>
            <div className="flex px-16 py-6 justify-between whitespace-nowrap text-center items-center text-base">
                <div>{props.category}</div>
                <div>{props.id}</div>
                <div>{props.name}</div>
                <div>{props.temp}</div>
                <div>{props.size}</div>
                <div>{props.price}</div>
                <div>{props.date}</div>
            </div>
        </>);
}
