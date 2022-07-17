/**
 * 테스트를 위해 임포트 하여 사용할 데이터 및 상수 모음
 */

export const API_URL = 'http://localhost:8080/api';
const constants = {
  MENU_ITEMS: [
    {
      category: 'Coffee',
      id: '1391039',
      name: '아이스 아메리카노',
      temp: 'Ice',
      size: 'Tall',
      price: '4,000',
      date: '2021.11.30',
    },
    {
      category: 'Coffee',
      id: '13947839',
      name: '토피넛 라떼',
      temp: 'Ice, Hot',
      size: 'Tall, Grande, Venti',
      price: '6,000',
      date: '2022.4.20',
    },
    {
      category: 'Non-Coffee',
      id: '1414612',
      name: '초코 라떼',
      temp: 'Ice, Hot',
      size: 'Tall, Grande',
      price: '5,000',
      date: '2021.1.30',
    },
    {
      category: 'Coffee',
      id: '13967839',
      name: '카라멜 마키아또',
      temp: 'Ice, Hot',
      size: 'Tall, Venti',
      price: '5,600',
      date: '2022.4.20',
    },
    {
      category: 'Non-Coffee',
      id: '14333612',
      name: '레몬에이드',
      temp: 'Ice',
      size: 'Tall, Grande, Venti',
      price: '7,000',
      date: '2021.7.19',
    },
    {
      category: 'Tea',
      id: '1245666',
      name: '캐모마일 티',
      temp: 'Ice, Hot',
      size: 'Tall, Grande, Venti',
      price: '4,500',
      date: '2021.3.2',
    },
    {
      category: 'Coffee',
      id: '13934513',
      name: '카푸치노',
      temp: 'Hot',
      size: 'Tall, Venti',
      price: '5,500',
      date: '2022.01.01',
    },
  ],
  CATEGORIES: [
    {
      name: 'Coffee',
      id: '1391039',
    },
    {
      name: 'Non-Coffee',
      id: '1414612',
    },
    {
      name: 'Tea',
      id: '1245666',
    },
  ],
  ORDER: {
    orders: [
      {
        menu: {
          category: 'Non-Coffee',
          id: '1414612',
          name: '초코 라떼',
          temp: 'Ice, Hot',
          size: 'Tall, Grande',
          price: '5,000',
          date: '2021.1.30',
        },
        quantity: 1,
      },
      {
        menu: {
          category: 'Coffee',
          id: '13967839',
          name: '카라멜 마키아또',
          temp: 'Ice, Hot',
          size: 'Tall, Venti',
          price: '5,600',
          date: '2022.4.20',
        },
        quantity: 2,
      },
      {
        menu: {
          category: 'Non-Coffee',
          id: '14333612',
          name: '레몬에이드',
          temp: 'Ice',
          size: 'Tall, Grande, Venti',
          price: '7,000',
          date: '2021.7.19',
        },
        quantity: 1,
      },
      {
        menu: {
          category: 'Tea',
          id: '1245666',
          name: '캐모마일 티',
          temp: 'Ice, Hot',
          size: 'Tall, Grande, Venti',
          price: '4,500',
          date: '2021.3.2',
        },
        quantity: 4,
      },
    ],
    takeout: false,
    total: 40000,
  },
};
export default constants;
