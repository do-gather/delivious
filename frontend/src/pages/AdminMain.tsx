import React from 'react';
import { Link } from 'react-router-dom';
import Tap from '../components/Tap';
import ChartBar from '../images/ChartBar';
import Copy from '../images/Copy';
import Document from '../images/Document';
import Logout from '../images/Logout';
import Notebook from '../images/Notebook';

/**
 * '/admin'으로 연결되는 관리자 메인 페이지
 * 관리자용 메뉴 버튼 네 개가 보임
 */
interface Props {
  title: string;
  icon: any;
  url: string;
}

function MenuBox({ title, icon, url }: Props) {
  return (
    <Link
      to={url}
      className="flex flex-col h-full w-96 justify-between px-7 pt-9 pb-4 shrink rounded bg-white shadow-md "
    >
      <div className="">{title}</div>
      <div className="place-self-end">{icon}</div>
    </Link>
  );
}

export default function AdminMain() {
  return (
    <div className="mx-12 py-20 overflow-y-hidden h-full">
      <div className="text-base font-bold pb-9 whitespace-nowrap">스타벅스 강남R점, 오늘도 반가워요!</div>
      <div className="flex flex-col space-y-12 h-3/4 mx-32 text-left font-bold text-3xl">
        <div className="flex h-full justify-center gap-8 md:gap-28 items-center">
          <MenuBox title="메뉴 관리" icon={<Notebook />} url="/admin/menu" />
          <MenuBox title="주문 관리" icon={<Document />} url="/admin/orders" />
        </div>
        <div className="flex h-full justify-center gap-8 md:gap-28 items-center">
          <MenuBox title="테이블 관리" icon={<Copy />} url="/admin/tables" />
          <MenuBox title="매출 통계" icon={<ChartBar />} url="/admin/reports" />
        </div>
      </div>
      <div className="fixed flex-col space-y-8 right-0 top-14 h-full">
        <Tap color="#000000" name="주문하기" link="/" />
        <Tap color="#435ca5" name="관리페이지" link="/admin" />
        <Link className="fixed bottom-8 right-1.5" to="/login">
          <Logout />
        </Link>
      </div>
    </div>
  );
}
