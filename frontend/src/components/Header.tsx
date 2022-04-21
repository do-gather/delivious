import React from "react";
import Logo from "../images/delivious_logo.png";
import { Link } from 'react-router-dom';

export default function Header() {
    return (
        <>
            <div>
                <Link className="w-28" to='/'>
                    <img className="mx-14 py-9 w-28" alt='main-logo' src={Logo}></img>
                </Link>
            </div>
        </>);
}