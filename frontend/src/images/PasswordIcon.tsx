/* eslint-disable react/require-default-props */
import * as React from "react"

interface Props{
  height? : number;
  width? : number;
}

function PasswordIcon ({height=24, width=24 }:Props){
    return(
        <svg
    width={width}
    height={height}
    viewBox="0 0 24 24"
    fill="none"
    xmlns="http://www.w3.org/2000/svg"
  >
    <path
      d="M5 21h14a1 1 0 0 0 1-1V10a1 1 0 0 0-1-1H5a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1z"
      stroke="#fff"
      strokeWidth={2}
      strokeLinecap="round"
      strokeLinejoin="round"
    />
    <path
      d="M14.77 9V8v1zM9.23 9v1-1zM9 8.77H8h1zM9 6h1-1zm6 0h-1 1zm0 2.77h1-1zM12 3v1-1zm2.77 5H9.23v2h5.54V8zM10 8.77V6H8v2.77h2zM14 6v2.77h2V6h-2zm-2-2a2 2 0 0 1 2 2h2a4 4 0 0 0-4-4v2zm-2 2a2 2 0 0 1 2-2V2a4 4 0 0 0-4 4h2zm-.77 2a.77.77 0 0 1 .77.77H8C8 9.448 8.551 10 9.23 10V8zm5.54 2A1.23 1.23 0 0 0 16 8.77h-2a.77.77 0 0 1 .77-.77v2z"
      fill="#fff"
    />
  </svg>
    )
}

export default PasswordIcon
