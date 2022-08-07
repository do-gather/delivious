/* eslint-disable no-unused-vars */
import create from 'zustand';

/**
 * 전역적으로 관리해야할 상태를 저장하는 곳
 * user token 정보를 저장
 */
interface AccessState {
  access: string;
  setAccess: (token: string) => void;
  removeAccess: () => void;
}

interface UserInfo {
  userId: string;
  userName: string;
  userType: string;
  storeName: string;
  setUserId: (id: string) => void;
  removeUserId: () => void;
  setUserName: (id: string) => void;
  removeUserName: () => void;
  setUserType: (id: string) => void;
  removeUserType: () => void;
  setStoreName: (store: string) => void;
  removeStoreName: () => void;
}

export const useAuth = create<AccessState>(set => ({
  access: '',
  setAccess: (token: string) =>
    set(() => ({
      access: token,
    })),
  removeAccess: () => set({ access: '' }),
}));

export const useUserInfo = create<UserInfo>(set => ({
  userId: '',
  setUserId: (id: string) =>
    set(() => ({
      storeName: id,
    })),
  removeUserId: () => set({ userId: '' }),
  userName: '',
  setUserName: (name: string) =>
    set(() => ({
      userName: name,
    })),
  removeUserName: () => set({ userName: '' }),
  userType: '',
  setUserType: (type: string) =>
    set(() => ({
      userType: type,
    })),
  removeUserType: () => set({ userType: '' }),
  storeName: '',
  setStoreName: (store: string) =>
    set(() => ({
      storeName: store,
    })),
  removeStoreName: () => set({ storeName: '' }),
}));
