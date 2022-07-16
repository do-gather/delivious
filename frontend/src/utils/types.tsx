/**
 * delivious type-script (dts)
 * 자주 쓰이는 타입들을 정리해 놓는 곳
 * import해서 사용
 */

// eslint-disable-next-line @typescript-eslint/no-namespace
export namespace dts {
  export interface menuDto {
    category: string;
    id: string;
    name: string;
    temp: string;
    size: string;
    price: string;
    date: string;
  }

  export interface orderDto {
    menu: menuDto;
    quantity: number;
  }

  export interface orderList {
    orders: Array<orderDto>;
    takeout: boolean;
    total: number;
  }

  export interface tokenDto {
    activation: boolean;
    type: string;
  }

  export interface userInfo {
    username: string;
    password: string;
    passwordConfirm: string;
    name: string;
    phoneNum: string;
    year: string;
    month: string;
    date: string;
    type: string;
    storeName: string;
  }
}
