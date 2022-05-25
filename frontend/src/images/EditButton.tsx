import * as React from 'react';

function EditButton() {
  return (
    <svg width={90} height={90} fill="none" xmlns="http://www.w3.org/2000/svg">
      <g filter="url(#a_edit)">
        <circle cx={43} cy={43} r={25} fill="#fff" />
      </g>
      <path
        d="M38 53v1a1 1 0 0 0 .707-.293L38 53Zm-5 0h-1a1 1 0 0 0 1 1v-1Zm0-5-.707-.707A1 1 0 0 0 32 48h1Zm14.116-14.116.707.707-.707-.707Zm1.768 0-.707.707.707-.707Zm3.232 3.232.707-.707-.707.707Zm0 1.768-.707-.707.707.707ZM38 52h-5v2h5v-2Zm-4 1v-5h-2v5h2Zm-.293-4.293L47.823 34.59l-1.414-1.414-14.116 14.116 1.414 1.414Zm14.47-14.116 3.232 3.232 1.414-1.414-3.232-3.232-1.414 1.414Zm3.232 3.586L37.293 52.293l1.414 1.414L52.823 39.59l-1.414-1.414Zm0-.354a.25.25 0 0 1 0 .354l1.414 1.414a2.25 2.25 0 0 0 0-3.182l-1.414 1.414Zm-3.586-3.232a.25.25 0 0 1 .354 0l1.414-1.414a2.25 2.25 0 0 0-3.182 0l1.414 1.414Z"
        fill="#181818"
      />
      <path d="m43 38 5 5" stroke="#181818" strokeWidth={2} strokeLinecap="round" strokeLinejoin="round" />
      <defs>
        <filter
          id="a_edit"
          x={0}
          y={0}
          width={90}
          height={90}
          filterUnits="userSpaceOnUse"
          colorInterpolationFilters="sRGB"
        >
          <feFlood floodOpacity={0} result="BackgroundImageFix" />
          <feColorMatrix in="SourceAlpha" values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 127 0" result="hardAlpha" />
          <feOffset dx={2} dy={2} />
          <feGaussianBlur stdDeviation={10} />
          <feComposite in2="hardAlpha" operator="out" />
          <feColorMatrix values="0 0 0 0 1 0 0 0 0 1 0 0 0 0 1 0 0 0 0.3 0" />
          <feBlend in2="BackgroundImageFix" result="effect1_dropShadow_31_439" />
          <feBlend in="SourceGraphic" in2="effect1_dropShadow_31_439" result="shape" />
        </filter>
      </defs>
    </svg>
  );
}

export default EditButton;
