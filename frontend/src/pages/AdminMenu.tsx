import React from 'react';
import { Link } from 'react-router-dom';
import AdminMenuItem from '../components/AdminMenuItem';
import constants from '../utils/constants';
import EditButton from '../images/EditButton';
import SearchBar from '../components/SearchBar';
import Tap from '../components/Tap';
import SearchIcon from '../images/SearchIcon';

/**
 * '/admin/menu'로 연결되는 어드민 메뉴 페이지
 * 메뉴 리스트를 보여주고 수정 및 검색이 가능
 */

function Divider() {
  return <div className="border-b w-full" style={{ borderColor: '#c4c4c4' }} />;
}

export default function AdminMenu() {
  return (
    <div className="w-full h-full pl-14 pr-32 py-24 overflow-y-hidden">
      <div className="grid grid-cols-8 space-x-4 items-center pb-8 justify-between ">
        <div className="col-span-1 font-bold text-3xl whitespace-nowrap">메뉴관리</div>
        <div className="col-span-5">
          <SearchBar placeholder="Search menu name or id" icon={<SearchIcon/>}/>
        </div>
      </div>
      <div
        className="grid grid-cols-7 gap-4 px-10 justify-between font-semibold whitespace-nowrap 
            text-white h-12 text-center items-center text-2xl"
        style={{ backgroundColor: '#435CA5' }}
      >
        <div>Category</div>
        <div>ID</div>
        <div>Name</div>
        <div>Ice/Hot</div>
        <div>Size</div>
        <div>Price</div>
        <div>Date</div>
      </div>
      <div className="h-3/4 overflow-y-scroll">
        {constants.MENU_ITEMS.map(menu => (
          <div key={menu.id}>
            <AdminMenuItem props={menu} type="display" />
            <Divider />
          </div>
        ))}
      </div>
      <div className="fixed flex-col space-y-8 right-0 top-14">
        <Tap color="#000000" name="주문하기" link="/" />
        <Tap color="#435ca5" name="관리페이지" link="/admin" />
      </div>
      <Link className="fixed left-11 bottom-11" to="/admin/menu/edit">
        <EditButton />
      </Link>
    </div>
  );
}
