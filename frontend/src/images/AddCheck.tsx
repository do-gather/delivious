import * as React from "react"
import { SVGProps } from "react"

const AddCheck = (props: SVGProps<SVGSVGElement>) => (
    <svg
        className="mx-auto cursor-pointer"
        width={90}
        height={90}
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
        {...props}
    >
        <g filter="url(#a)">
            <circle cx={43} cy={43} r={25} fill="#fff" />
        </g>
        <path
            d="m37 43 4.243 4.243 8.485-8.486"
            stroke="#000"
            strokeWidth={2}
            strokeLinecap="round"
            strokeLinejoin="round"
        />
        <defs>
            <filter
                id="a"
                x={0}
                y={0}
                width={90}
                height={90}
                filterUnits="userSpaceOnUse"
                colorInterpolationFilters="sRGB"
            >
                <feFlood floodOpacity={0} result="BackgroundImageFix" />
                <feColorMatrix
                    in="SourceAlpha"
                    values="0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 127 0"
                    result="hardAlpha"
                />
                <feOffset dx={2} dy={2} />
                <feGaussianBlur stdDeviation={10} />
                <feComposite in2="hardAlpha" operator="out" />
                <feColorMatrix values="0 0 0 0 1 0 0 0 0 1 0 0 0 0 1 0 0 0 0.3 0" />
                <feBlend in2="BackgroundImageFix" result="effect1_dropShadow_39_88" />
                <feBlend
                    in="SourceGraphic"
                    in2="effect1_dropShadow_39_88"
                    result="shape"
                />
            </filter>
        </defs>
    </svg>
)

export default AddCheck
