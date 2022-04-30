import * as React from "react"
import { SVGProps } from "react"

const LockIcon = (props: SVGProps<SVGSVGElement>) => (
    <svg
        width={15}
        height={14}
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
        {...props}
    >
        <path
            d="M3.5 12.25h8.167a.583.583 0 0 0 .583-.582V5.834a.583.583 0 0 0-.583-.584H3.499a.583.583 0 0 0-.583.584v5.834c0 .322.261.583.583.583Z"
            stroke="#fff"
            strokeWidth={2}
            strokeLinecap="round"
            strokeLinejoin="round"
        />
        <path
            d="M9.198 5.25v-1 1Zm-3.231 0v1-1Zm-.135-.134h-1 1Zm0-1.616h1-1Zm3.5 0h-1 1Zm0 1.616h1-1ZM7.582 1.75v1-1Zm1.616 2.5H5.967v2h3.23v-2Zm-2.366.866V3.5h-2v1.616h2Zm1.5-1.616v1.616h2V3.5h-2Zm-.75-.75a.75.75 0 0 1 .75.75h2A2.75 2.75 0 0 0 7.582.75v2Zm-.75.75a.75.75 0 0 1 .75-.75v-2a2.75 2.75 0 0 0-2.75 2.75h2Zm-.865.75c.478 0 .865.388.865.866h-2c0 .626.508 1.134 1.135 1.134v-2Zm3.23 2c.627 0 1.135-.508 1.135-1.134h-2c0-.478.388-.866.866-.866v2Z"
            fill="#fff"
        />
    </svg>
)

export default LockIcon
