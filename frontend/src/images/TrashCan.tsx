/* eslint-disable react/require-default-props */
import * as React from 'react';

interface Props {
  height?: number;
  width?: number;
}

function TrashCan({ height = 24, width = 24 }: Props) {
  return (
    <svg width={width} height={height} viewBox="0 0 30 30" fill="none" xmlns="http://www.w3.org/2000/svg">
      <path
        d="M17.5 12.5v8.75m-5-8.75v8.75"
        stroke="#000"
        strokeWidth={2}
        strokeLinecap="round"
        strokeLinejoin="round"
      />
      <path
        d="M7.5 7.5v-1a1 1 0 0 0-1 1h1zm15 0h1a1 1 0 0 0-1-1v1zm-15 1h15v-2h-15v2zm14-1V25h2V7.5h-2zm-.25 17.75H8.75v2h12.5v-2zM8.5 25V7.5h-2V25h2zm.25.25A.25.25 0 0 1 8.5 25h-2a2.25 2.25 0 0 0 2.25 2.25v-2zM21.5 25a.25.25 0 0 1-.25.25v2A2.25 2.25 0 0 0 23.5 25h-2z"
        fill="#000"
      />
      <path d="M5 7.5h20" stroke="#000" strokeWidth={2} strokeLinecap="round" strokeLinejoin="round" />
      <path
        d="M20 7.5v1a1 1 0 0 0 1-1h-1zm-10 0H9a1 1 0 0 0 1 1v-1zm1.25-2.75h7.5v-2h-7.5v2zM19 5v2.5h2V5h-2zm1 1.5H10v2h10v-2zm-9 1V5H9v2.5h2zm7.75-2.75A.25.25 0 0 1 19 5h2a2.25 2.25 0 0 0-2.25-2.25v2zm-7.5-2A2.25 2.25 0 0 0 9 5h2a.25.25 0 0 1 .25-.25v-2z"
        fill="#000"
      />
    </svg>
  );
}

export default TrashCan;
