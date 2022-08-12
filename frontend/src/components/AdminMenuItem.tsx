/* eslint-disable no-unused-vars */
/* eslint-disable react/require-default-props */
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import CheckBox from './CheckBox';
import InputBox from './InputBox';
import AddCircle from '../images/AddCircle';
import TrashCan from '../images/TrashCan';
import getYmd10 from '../utils/utils';
import { dts } from '../utils/types';
import Save from '../images/Save';
import ImageUpload from '../images/ImageUpload';
import ImageUploadModal from './ImageUploadModal';
import { API_URL } from '../utils/constants';
import { contentTypeJsonHeader } from '../utils/headerUtils';
/**
 * 어드민 메뉴 목록의 각 아이템
 * 수정 모드일 경우 수정 전 메뉴 아이템 값이 기본으로 들어가 있게 됨
 * @param props 메뉴안에 들어갈 각 항목을 아래 인터페이스 형태로 묶어서 받음
 * @param type 아이템이 수정 상태인지 아닌지 입력, 기본은 'display'. 수정 전일 때 'edit'을 전달.
 *              새로 추가 시 'new' 전달, 수정이 되었을 때 'edited'를 전달. 전달하지 않으면 'display'로 초기화 됨
 */
interface Props {
  props?: dts.menuDto;
  type?: string;
}

export default function AdminMenuItem({
  props = {
    category: '',
    id: '-',
    name: '',
    temp: '',
    size: '',
    price: '',
    date: '',
    image: '',
  },
  type = 'display',
}: Props) {
  const currentDate = getYmd10();
  // const [menu, setMenu] = useState(props || ({
  //     category: '',
  //     id: '-',
  //     name: '',
  //     temp: '',
  //     size: '',
  //     price: '',
  //     date: '',
  // }))

  const [modal, setModal] = useState(false);
  const [menuImage, setMenuImage] = useState(props.image);
  const [categories, setCategories] = useState([]);
  const [keywords, setKeywords] = useState('');
  const [userInfo, setUserInfo] = useState('');

  // const handleAddKeyword = (text: string) => {
  //   console.log('text', text);
  //   const newKeyword = {
  //     text: text,
  //   };
  //   setKeywords([newKeyword, ...keywords]);
  // };

  const handleChecked = (options: string, label: string) => {
    return options.includes(label);
  };

  const changeMenuImage = (image: File, url: string) => {
    setMenuImage(url);
  };

  const handleKeyword = (e: any) => {
    setKeywords(e.target.value);
  };

  const handleCategory = () => {
    if (type === 'edit') {
      // 카테고리 삭제
      axios.delete(`${API_URL}/categories/{categoryId}`, {
        data: {
          categoryName: keywords,
        },
      });
    } else if (type === 'new') {
      // 카테고리 생성
      axios
        .post(`${API_URL}/categories`, {
          categoryName: keywords,
          headers: contentTypeJsonHeader(),
        })
        .then(response => {
          return response;
        })
        .catch(err => {
          console.error(err.response);
          alert('post error');
        });
    } else {
      axios
        // 카테고리 수정
        .put(`${API_URL}/categories/{categoryId}`, {
          categoryName: keywords,
        })
        .then(response => {
          setCategories(response.data);
          console.log(response);
        });
    }
  };

  return type !== 'display' ? (
    <div className="flex p-4 text-center items-center">
      <button type="button" onClick={() => setModal(true)}>
        <ImageUpload />
      </button>
      <div className="w-full grid grid-cols-7 gap-4 whitespace-nowrap text-center items-center text-base">
        <InputBox placeholder="카테고리" text={props.category} onChange={handleKeyword} />
        {type === 'new' ? <div>-</div> : <div>{props.id}</div>}
        <InputBox placeholder="메뉴 이름" text={props.name} />
        <div className="flex justify-center space-x-3">
          <CheckBox label="Hot" checked={handleChecked(props.temp, 'Hot')} />
          <CheckBox label="Ice" checked={handleChecked(props.temp, 'Ice')} />
        </div>
        <div className="flex-col justify-center space-y-1">
          <CheckBox label="Tall" checked={handleChecked(props.size, 'Tall')} />
          <CheckBox label="Grande" checked={handleChecked(props.size, 'Grande')} />
          <CheckBox label="Venti" checked={handleChecked(props.size, 'Venti')} />
        </div>
        <InputBox placeholder="가격" text={props.price} />
        {type === 'new' ? <div>{currentDate}</div> : <div>{props.date}</div>}
      </div>

      <button type="button" className="cursor-pointer" onClick={handleCategory}>
        {type === 'edit' && <TrashCan />}
        {type === 'new' && <AddCircle />}
        {type === 'edited' && <Save />}
      </button>

      {modal && (
        <ImageUploadModal onClose={() => setModal(false)} submitFunction={changeMenuImage} imageURL={menuImage} />
      )}
    </div>
  ) : (
    <div className="grid grid-cols-7 gap-4 py-6 whitespace-nowrap text-center items-center text-base px-10 pr-6">
      <div>{props.category}</div>
      <div>{props.id}</div>
      <div>{props.name}</div>
      <div>{props.temp}</div>
      <div>{props.size}</div>
      <div>{props.price}</div>
      <div>{props.date}</div>
    </div>
  );
}
