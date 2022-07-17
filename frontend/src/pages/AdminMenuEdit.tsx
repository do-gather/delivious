import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import AdminMenuItem from '../components/AdminMenuItem';
import constants from '../utils/constants';
import BasicButton from '../components/BasicButton';
import SearchBar from '../components/SearchBar';
import Tap from '../components/Tap';

/**
 * '/admin/menu/edit'로 연결되는 어드민 메뉴 수정 페이지
 * 메뉴 리스트 수정 및 삭제, 추가가 가능
 */

function Divider() {
  return <div className="border-b w-full" style={{ borderColor: '#c4c4c4' }} />;
}

export default function AdminMenuEdit() {
  const navigate = useNavigate();
  const [finish, setFinish] = useState(false);

  useEffect(() => {
    if (finish) navigate('/admin/menu');
  }, [finish, navigate]);

  return (
    <div className="w-full h-screen pl-14 pr-32 py-24 overflow-y-hidden">
      <div className="grid grid-cols-8 space-x-4 items-center pb-8 justify-between ">
        <div className="col-span-1 font-bold text-3xl whitespace-nowrap">메뉴관리</div>
        <div className="col-span-5">
          <SearchBar placeholder="Search menu name or id" />
        </div>
        <div className="col-span-2 justify-self-end w-36">
          <BasicButton buttonName="편집 완료" onClick={() => setFinish(true)} />
        </div>
      </div>
      <div
        className="grid grid-cols-7 gap-4 px-10 font-semibold whitespace-nowrap text-white h-12 
            text-center items-center text-2xl"
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
      <div className="h-3/5 overflow-y-scroll">
        {constants.MENU_ITEMS.map(menu => (
          <div key={menu.id}>
            <AdminMenuItem props={menu} type="edit" />
            <Divider />
          </div>
        ))}
      </div>
      <div>
        <AdminMenuItem type="new" />
        <Divider />
      </div>
      <div className="flex-col space-y-8 fixed right-0 top-14">
        <Tap color="#000000" name="주문하기" link="/" />
        <Tap color="#435ca5" name="관리페이지" link="/admin" />
      </div>
    </div>
  );
}
