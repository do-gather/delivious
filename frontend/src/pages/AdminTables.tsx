import React from 'react';
import Tap from '../components/Tap';
import constants from '../utils/constants';
import Table from '../components/Table';
import TrashCan from '../images/TrashCan';

/**
 * /admin/tables으로 연결되는 페이지
 * 관리자용 메뉴버튼에서 테이블을 누르고 테이블을 관리하는 페이지
 */

export default function AdminTables() {
  return (
    <div className="w-full h-full pl-24 pr-36 py-24">
      <div className="flex space-x-14 justify-end">
        <div className="w-4 h-4 rounded-full" style={{ backgroundColor: '#435ca5' }}>
          <div className="px-6 text-sm"> Ready </div>
        </div>
        <div className="w-4 h-4 rounded-full" style={{ backgroundColor: '#adbdd4' }}>
          <div className="px-6 text-sm">Done</div>
        </div>
        <div className="w-4 h-4 rounded-full" style={{ backgroundColor: '#c4c4c4' }}>
          <div className="px-6 text-sm">Empty</div>
        </div>
      </div>

      <div className="h-3/4 flex flex-wrap justify-center pt-12">
        {constants.ORDER_ITEMS.map((orders, index) => (
          <div key={orders.order_number}>
            <Table TableNumber={index + 1} history={orders.history} state={orders.state} icon={<TrashCan />} />
          </div>
        ))}
      </div>

      <div className="flex-col space-y-8 fixed right-0 top-14">
        <Tap color="#000000" name="주문하기" link="/" />
        <Tap color="#435ca5" name="관리페이지" link="/admin" />
      </div>
    </div>
  );
}
